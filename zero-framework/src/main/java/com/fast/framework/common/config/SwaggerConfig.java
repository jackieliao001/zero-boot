package com.fast.framework.common.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfig
 *
 * @author liaojunjie
 * @date 2023/2/9 16:06
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi userApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"com.fast"};
        return GroupedOpenApi.builder().group("ZeroBoot")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("Jackie");

        return new OpenAPI().info(new Info()
                .title("ZeroBoot")
                .description("ZeroBoot")
                .contact(contact)
                .version("3.0")
                .termsOfService("http://localhost:8080/zero-boot")
                .license(new License().name("MIT")
                        .url("https://gitee.com/jackie_liao/zero-boot")));
    }
}
