package com.fast.framework.common.cache;

/**
 * redis key 管理
 *
 * @author liaojunjie
 * @date 2023/2/9 17:17
 */
public class RedisKeys {
    /**
     * 验证码Key
     */
    public static String getCaptchaKey(String key) {
        return "sys:captcha:" + key;
    }

    /**
     * accessToken Key
     */
    public static String getAccessTokenKey(String accessToken) {
        return "sys:access:" + accessToken;
    }
}
