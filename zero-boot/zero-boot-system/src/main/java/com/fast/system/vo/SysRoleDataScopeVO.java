package com.fast.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色数据权限
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@Schema(description = "角色数据权限" )
public class SysRoleDataScopeVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "角色ID" )
    private Long roleId;
    @Schema(description = "机构ID" )
    private Long orgId;
}