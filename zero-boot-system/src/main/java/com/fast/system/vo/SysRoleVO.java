package com.fast.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色管理
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@Schema(description = "角色管理" )
public class SysRoleVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "角色名称" )
    private String name;
    @Schema(description = "备注" )
    private String remark;
    @Schema(description = "数据范围  0：全部数据  1：本机构及子机构数据  2：本机构数据  3：本人数据  4：自定义数据" )
    private Byte dataScope;
    @Schema(description = "机构ID" )
    private Long orgId;
}