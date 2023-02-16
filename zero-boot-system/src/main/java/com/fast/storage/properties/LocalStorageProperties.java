package com.fast.storage.properties;

import lombok.Data;

/**
 * 本地存储配置项
 *
 * @author liaojunjie
 * @date 2023/2/15
 */
@Data
public class LocalStorageProperties {
    /**
     * 本地存储路径
     */
    private String path;
    /**
     * 资源起始路径
     */
    private String url = "upload";
}
