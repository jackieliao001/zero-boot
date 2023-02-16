package com.fast.system.query;

import com.fast.framework.common.bean.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单管理查询
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "菜单管理查询" )
public class SysMenuQuery extends Query {
    @Schema(description = "上级ID，一级菜单为0" )
    private Long pid;
    @Schema(description = "菜单名称" )
    private String name;
    @Schema(description = "菜单URL" )
    private String url;
    @Schema(description = "授权标识(多个用逗号分隔，如：sys:menu:list,sys:menu:save)" )
    private String authority;
    @Schema(description = "类型   0：菜单   1：按钮   2：接口" )
    private Byte type;
    @Schema(description = "打开方式   0：内部   1：外部" )
    private Byte openStyle;
    @Schema(description = "菜单图标" )
    private String icon;
    @Schema(description = "排序" )
    private Integer sort;
}