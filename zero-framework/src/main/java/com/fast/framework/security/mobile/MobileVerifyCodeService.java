package com.fast.framework.security.mobile;

/**
 * 手机短信登录，验证码效验
 *
 * @author liaojunjie
 * @date 2023/2/9 17:47
 */
public interface MobileVerifyCodeService {
    boolean verifyCode(String mobile, String code);
}
