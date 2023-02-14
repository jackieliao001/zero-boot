package com.fast.security.service;

import com.fast.framework.security.mobile.MobileVerifyCodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 短信验证码效验
 *
 * @author liaojunjie
 * @date 2023/2/13
 */
@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
    // private final SmsApi smsApi;

    @Override
    public boolean verifyCode(String mobile, String code) {
        // return smsApi.verifyCode(mobile, code);
        return false;
    }
}
