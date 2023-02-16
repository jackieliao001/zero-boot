package com.fast.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 登录信息
 *
 * @author liaojunjie
 * @date 2023/2/13
 */
@Getter
@AllArgsConstructor
public enum LoginOperationEnum {
    /**
     * 登录成功
     */
    LOGIN_SUCCESS(0,"登录成功"),
    /**
     * 退出成功
     */
    LOGOUT_SUCCESS(1,"退出成功"),
    /**
     * 验证码错误
     */
    CAPTCHA_FAIL(2,"验证码错误"),
    /**
     * 账号密码错误
     */
    ACCOUNT_FAIL(3,"账号密码错误"),
    /**
     * 手机号未注册
     */
    MOBILE_NOT_REGISTERED(4,"手机号未注册");

    private final int value;
    private final String msg;
}
