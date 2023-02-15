package com.fast.storage.properties;

import lombok.Data;

/**
 * 七牛云存储配置项
 *
 * @author liaojunjie
 * @date 2023/2/15
 */
@Data
public class QiniuStorageProperties {
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
