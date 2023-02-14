package com.fast.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色菜单关系
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@Schema(description = "角色菜单关系" )
public class SysRoleMenuVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "角色ID" )
    private Long roleId;
    @Schema(description = "菜单ID" )
    private Long menuId;
}