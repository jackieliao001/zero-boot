package com.fast.system.query;

import com.fast.framework.common.bean.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色管理查询
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "角色管理查询" )
public class SysRoleQuery extends Query {
    @Schema(description = "角色名称" )
    private String name;
}