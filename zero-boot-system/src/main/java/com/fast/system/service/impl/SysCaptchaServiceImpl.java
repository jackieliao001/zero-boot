package com.fast.system.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.fast.framework.common.cache.RedisCache;
import com.fast.framework.common.cache.RedisKeys;
import com.fast.system.enums.SysParamsEnum;
import com.fast.system.service.SysCaptchaService;
import com.fast.system.service.SysParamsService;
import com.fast.system.vo.SysCaptchaVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 验证码 服务实现
 *
 * @author liaojunjie
 * @date 2023/2/15
 */
@Service
@AllArgsConstructor
public class SysCaptchaServiceImpl implements SysCaptchaService {
    private final RedisCache redisCache;
    private final SysParamsService sysParamsService;
    @Override
    public SysCaptchaVO generate() {
        // 生成验证码key
        String key = UUID.randomUUID().toString();

        // 生成验证码
        // 定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 6, 4);
        String code = captcha.getCode();
        String image = captcha.getImageBase64();
        // 保存到缓存
        String redisKey = RedisKeys.getCaptchaKey(key);
        redisCache.set(redisKey, code, 300);

        // 封装返回数据
        SysCaptchaVO captchaVO = new SysCaptchaVO();
        captchaVO.setKey(key);
        captchaVO.setImage(image);

        return captchaVO;
    }

    @Override
    public boolean validate(String key, String code) {
        // 如果关闭了验证码，则直接效验通过
        if (!isCaptchaEnabled()) {
            return true;
        }

        if (StrUtil.hasBlank(key,code)) {
            return false;
        }

        // 获取验证码
        String captcha = getCache(key);

        // 效验成功
        return StrUtil.equalsIgnoreCase(captcha,code);
    }

    /**
     * 是否开启登录验证码
     *
     * @return true：开启  false：关闭
     */
    private boolean isCaptchaEnabled() {
        return sysParamsService.getBoolean(SysParamsEnum.LOGIN_CAPTCHA.name());
    }

    private String getCache(String key) {
        key = RedisKeys.getCaptchaKey(key);
        String captcha = (String) redisCache.get(key);
        // 删除验证码
        if (captcha != null) {
            redisCache.delete(key);
        }

        return captcha;
    }
}
