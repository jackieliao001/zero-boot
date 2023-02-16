package com.fast.storage.properties;

import lombok.Data;

/**
 * Minio存储配置项
 *
 * @author liaojunjie
 * @date 2023/2/15
 */
@Data
public class MinioStorageProperties {
    private String endPoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
