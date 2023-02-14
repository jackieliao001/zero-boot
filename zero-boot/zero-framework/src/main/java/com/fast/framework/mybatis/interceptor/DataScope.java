package com.fast.framework.mybatis.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 数据范围
 *
 * @author liaojunjie
 * @date 2023/2/9 15:41
 */
@Data
@AllArgsConstructor
public class DataScope {
    private String sqlFilter;
}
