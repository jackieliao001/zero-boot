package com.fast.storage.properties;

import lombok.Data;

/**
 * 阿里云存储配置项
 *
 * @author liaojunjie
 * @date 2023/2/15
 */
@Data
public class AliyunStorageProperties {
    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
