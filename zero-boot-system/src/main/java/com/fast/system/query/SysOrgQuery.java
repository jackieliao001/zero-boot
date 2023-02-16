package com.fast.system.query;

import com.fast.framework.common.bean.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 机构管理查询
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "机构管理查询" )
public class SysOrgQuery extends Query {
    @Schema(description = "上级ID" )
    private Long pid;
    @Schema(description = "机构名称" )
    private String name;
    @Schema(description = "排序" )
    private Integer sort;
}