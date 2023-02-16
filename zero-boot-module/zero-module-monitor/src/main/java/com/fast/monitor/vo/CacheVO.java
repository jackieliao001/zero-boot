package com.fast.monitor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * redis 缓存信息
 *
 * @author liaojunjie
 * @date 2023/2/10 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheVO {
    @Schema(description = "redis 缓存KEY")
    private String cacheKey;

    @Schema(description = "redis 缓存值")
    private Object cacheValue;
}
