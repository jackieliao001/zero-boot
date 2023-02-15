package com.fast.storage.config;

import com.fast.storage.enums.StorageTypeEnum;
import com.fast.storage.properties.LocalStorageProperties;
import com.fast.storage.properties.StorageProperties;
import jakarta.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 本地资源映射配置
 *
 * @author liaojunjie
 * @date 2023/2/15
 */
@Configuration
@ConditionalOnProperty(prefix = "storage", value = "enabled")
public class LocalResourceConfiguration implements WebMvcConfigurer {
    @Resource
    private StorageProperties properties;

    @Override
    public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
        // 如果不是本地存储，则返回
        if (properties.getConfig().getType() != StorageTypeEnum.LOCAL) {
            return;
        }

        LocalStorageProperties local = properties.getLocal();
        registry.addResourceHandler("/" + local.getUrl() + "/**")
                .addResourceLocations("file:" + local.getPath() + "/");
    }
}