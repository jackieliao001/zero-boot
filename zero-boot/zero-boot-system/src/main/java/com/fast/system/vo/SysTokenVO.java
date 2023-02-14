package com.fast.system.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户Token
 *
 * @author liaojunjie
 * @date 2023/2/13 14:12
 */
@Data
@AllArgsConstructor
@Schema(description = "用户登录Token")
public class SysTokenVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "access_token")
    @JsonAlias({"access_token","accessToken"})
    private String accessToken;
}
