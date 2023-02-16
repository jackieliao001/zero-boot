package com.fast.system.service;

import com.fast.system.vo.SysCaptchaVO;

/**
 * 验证码 服务
 *
 * @author liaojunjie
 * @date 2023/2/13 14:11
 */
public interface SysCaptchaService {
    /**
     * 生成验证码
     * @return 验证码captcha vo
     */
    SysCaptchaVO generate();

    /**
     * 验证码效验
     *
     * @param key  key
     * @param code 验证码
     * @return true：成功  false：失败
     */
    boolean validate(String key, String code);
}
