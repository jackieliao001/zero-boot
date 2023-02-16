package com.fast.security.event;

import com.fast.framework.common.constant.Constant;
import com.fast.framework.security.user.UserDetail;
import com.fast.system.enums.LoginOperationEnum;
import com.fast.system.service.SysLogLoginService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * 认证事件处理
 *
 * @author liaojunjie
 * @date 2023/2/13
 */
@Component
@AllArgsConstructor
public class AuthenticationEvents {
    private final SysLogLoginService logLoginService;

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event){
        // 登录成功日志
        UserDetail user = (UserDetail) event.getAuthentication().getPrincipal();
        logLoginService.save(user.getUsername(), Constant.SUCCESS, LoginOperationEnum.LOGIN_SUCCESS.getValue());
    }
    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent event) {
        // 登录失败日志
        String username = (String) event.getAuthentication().getPrincipal();
        logLoginService.save(username, Constant.FAIL, LoginOperationEnum.ACCOUNT_FAIL.getValue());
    }
}
