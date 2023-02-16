package com.fast.storage.config;

import com.fast.storage.enums.StorageTypeEnum;
import com.fast.storage.properties.StorageProperties;
import com.fast.storage.service.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 存储配置文件
 *
 * @author liaojunjie
 * @date 2023/2/15
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
@ConditionalOnProperty(prefix = "storage", value = "enabled")
public class StorageConfiguration {

    @Bean
    public StorageService storageService(StorageProperties properties) {
        return switch (properties.getConfig().getType()){
            case ALIYUN -> new AliyunStorageService(properties);
            case TENCENT -> new TencentStorageService(properties);
            case QINIU -> new QiniuStorageService(properties);
            case MINIO -> new MinioStorageService(properties);
            default -> new LocalStorageService(properties);
        };
    }

}
