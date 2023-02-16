package com.fast.framework.security.config;

import com.fast.framework.common.cache.RedisCache;
import com.fast.framework.common.cache.RedisKeys;
import com.fast.framework.security.user.UserDetail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 认证 Cache
 *
 * @author liaojunjie
 * @date 2023/2/9 17:37
 */
@Component
@AllArgsConstructor
public class TokenStoreCache {
    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserDetail user) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public UserDetail getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return (UserDetail) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}
