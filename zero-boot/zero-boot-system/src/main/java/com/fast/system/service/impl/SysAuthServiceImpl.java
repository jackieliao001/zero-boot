package com.fast.system.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.fast.framework.common.constant.Constant;
import com.fast.framework.common.exception.ServerException;
import com.fast.framework.common.utils.TokenUtils;
import com.fast.framework.security.config.TokenStoreCache;
import com.fast.framework.security.mobile.MobileAuthenticationToken;
import com.fast.framework.security.user.UserDetail;
import com.fast.system.enums.LoginOperationEnum;
import com.fast.system.service.SysAuthService;
import com.fast.system.service.SysCaptchaService;
import com.fast.system.service.SysLogLoginService;
import com.fast.system.service.SysUserService;
import com.fast.system.vo.SysAccountLoginVO;
import com.fast.system.vo.SysMobileLoginVO;
import com.fast.system.vo.SysTokenVO;
import com.fast.system.vo.SysUserVO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


/**
 * 权限认证服务
 *
 * @author liaojunjie
 * @date 2023/2/13
 */
@Service
@AllArgsConstructor
public class SysAuthServiceImpl implements SysAuthService {
    private final TokenStoreCache tokenStoreCache;
    private final SysUserService sysUserService;
    private final SysLogLoginService sysLogLoginService;
    private final AuthenticationManager authenticationManager;
    private final SysCaptchaService sysCaptchaService;

    @Override
    public SysTokenVO loginByAccount(SysAccountLoginVO login) {
        // 验证码校验
        /*boolean flag = sysCaptchaService.validate(login.getKey(),login.getCaptcha());
        if (!flag) {
            // 登录日志
            sysLogLoginService.save(login.getUsername(), Constant.FAIL, LoginOperationEnum.CAPTCHA_FAIL.getValue());
            throw new ServerException(LoginOperationEnum.CAPTCHA_FAIL.getMsg());
        }*/
        // 用户认证
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword()));
        }catch (BadCredentialsException e){
            throw new ServerException(LoginOperationEnum.ACCOUNT_FAIL.getMsg());
        }
        UserDetail user = (UserDetail) authentication.getPrincipal();
        String tokenStr = TokenUtils.generator();
        tokenStoreCache.saveUser(tokenStr,user);
        return new SysTokenVO(tokenStr);
    }

    @Override
    public boolean sendCode(String mobile) {
        String code  = RandomUtil.randomNumbers(6);
        SysUserVO user = sysUserService.getByMobile(mobile);
        if (user == null){
            throw new ServerException(LoginOperationEnum.MOBILE_NOT_REGISTERED.getMsg());
        }
        // return smsApi.sendCode(mobile, "code", code);
        return false;
    }

    @Override
    public SysTokenVO loginByMobile(SysMobileLoginVO login) {
        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new MobileAuthenticationToken(login.getMobile(), login.getCode()));
        } catch (BadCredentialsException e) {
            throw new ServerException("手机号或验证码错误");
        }

        // 用户信息
        UserDetail user = (UserDetail) authentication.getPrincipal();

        // 生成 accessToken
        String accessToken = TokenUtils.generator();

        // 保存用户信息到缓存
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    @Override
    public void logout(String accessToken) {
        UserDetail user = tokenStoreCache.getUser(accessToken);
        sysLogLoginService.save(user.getUsername(), Constant.SUCCESS, LoginOperationEnum.LOGOUT_SUCCESS.getValue());
        tokenStoreCache.deleteUser(accessToken);
    }
}
