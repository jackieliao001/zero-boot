package com.fast.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fast.framework.common.bean.Query;

/**
 * 参数管理查询
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "参数管理查询")
public class SysParamsQuery extends Query {
    @Schema(description = "参数名称")
    private String paramName;
    @Schema(description = "系统参数   0：否   1：是")
    private Byte paramType;
    @Schema(description = "参数键")
    private String paramKey;
    @Schema(description = "参数值")
    private String paramValue;
}