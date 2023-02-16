package com.fast.framework.security.user;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * spring security user
 *
 * @author liaojunjie
 * @date 2023/2/9 17:20
 */
public class SecurityUser {

    /**
     * spring security获取当前用户信息
     * @return UserDetail object
     */
    public static UserDetail getUser(){
        UserDetail userDetail;
        try {
            userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return new UserDetail();
        }
        return userDetail;
    }

    /**
     * 获取当前用户ID
     * @return Long
     */
    public static Long getUserId(){
        return getUser().getId();
    }
}
