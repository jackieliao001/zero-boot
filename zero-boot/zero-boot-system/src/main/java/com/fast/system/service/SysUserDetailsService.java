package com.fast.system.service;

import com.fast.system.entity.SysUserEntity;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户详情
 *
 * @author liaojunjie
 * @date 2023/2/13
 */
public interface SysUserDetailsService {
    /**
     * 获取 UserDetails 对象
     */
    UserDetails getUserDetails(SysUserEntity userEntity);
}
