package com.fast.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 岗位管理
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@Schema(description = "岗位管理" )
public class SysPostVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "岗位编码" )
    private String postCode;
    @Schema(description = "岗位名称" )
    private String postName;
    @Schema(description = "排序" )
    private Integer sort;
    @Schema(description = "状态  0：停用   1：正常" )
    private Byte status;
}