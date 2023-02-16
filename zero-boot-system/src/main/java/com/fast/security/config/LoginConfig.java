package com.fast.security.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 登录配置
 *
 * @author liaojunjie
 * @date 2023/2/13
 */
// @Configuration
public class LoginConfig {
  /*  @Bean
    @ConditionalOnMissingBean
    SmsApi smsApi(){
        return new SmsApi(){
            @Override
            public boolean send(String mobile, Map<String, String> params) {
                return false;
            }

            @Override
            public boolean sendCode(String mobile, String key, String value) {
                return false;
            }

            @Override
            public boolean verifyCode(String mobile, String code) {
                return false;
            }
        };
    }*/
}
