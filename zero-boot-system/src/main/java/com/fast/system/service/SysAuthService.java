package com.fast.system.service;

import com.fast.system.vo.SysAccountLoginVO;
import com.fast.system.vo.SysMobileLoginVO;
import com.fast.system.vo.SysTokenVO;

/**
 * 权限认证服务
 *
 * @author liaojunjie
 * @date 2023/2/13 14:08
 */
public interface SysAuthService {

    /**
     * 账号密码登录
     * @param login 登录信息
     * @return token vo
     */
    SysTokenVO loginByAccount(SysAccountLoginVO login);

    /**
     * 发送短信验证码
     * @param mobile    手机号码
     * @return boolean
     */
    boolean sendCode(String mobile);

    /**
     * 手机短信登录
     * @param login 登录信息
     * @return  token vo
     */
    SysTokenVO loginByMobile(SysMobileLoginVO login);

    /**
     * 登出
     * @param accessToken token info
     */
    void logout(String accessToken);
}
