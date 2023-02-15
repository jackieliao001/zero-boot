package com.fast.storage.properties;

import com.fast.storage.enums.StorageTypeEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 存储配置项
 *
 * @author liaojunjie
 * @date 2023/2/15
 */
@Data
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {
    /**
     * 是否开启存储
     */
    private boolean enabled;
    /**
     * 通用配置项
     */
    private StorageConfig config;
    /**
     * 本地配置项
     */
    private LocalStorageProperties local;
    /**
     * 阿里云配置项
     */
    private AliyunStorageProperties aliyun;
    /**
     * 七牛云配置项
     */
    private QiniuStorageProperties qiniu;
    /**
     * Minio配置项
     */
    private MinioStorageProperties minio;
    /**
     * 腾讯云配置项
     */
    private TencentStorageProperties tencent;

    @Data
    public static class StorageConfig {
        /**
         * 访问域名
         */
        private String domain;
        /**
         * 配置路径前缀
         */
        private String prefix;
        /**
         * 存储类型
         */
        private StorageTypeEnum type;
    }

    @Bean
    @ConfigurationProperties(prefix = "storage.local")
    public LocalStorageProperties localStorageProperties() {
        return new LocalStorageProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "storage.aliyun")
    public AliyunStorageProperties aliyunStorageProperties() {
        return new AliyunStorageProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "storage.qiniu")
    public QiniuStorageProperties qiniuStorageProperties() {
        return new QiniuStorageProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "storage.minio")
    public MinioStorageProperties minioStorageProperties() {
        return new MinioStorageProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "storage.tencent")
    public TencentStorageProperties tencentStorageProperties() {
        return new TencentStorageProperties();
    }

}
