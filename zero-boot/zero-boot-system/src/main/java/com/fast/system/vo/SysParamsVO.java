package com.fast.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fast.framework.common.utils.DateUtils;

/**
 * 参数管理
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@Schema(description = "参数管理")
public class SysParamsVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "id")
    private Long id;

    @Schema(description = "参数名称")
    private String paramName;
    @Schema(description = "系统参数   0：否   1：是")
    private Byte paramType;
    @Schema(description = "参数键")
    private String paramKey;
    @Schema(description = "参数值")
    private String paramValue;
    @Schema(description = "备注")
    private String remark;

    @Schema(description = "版本号")
    private Integer version;

    @Schema(description = "删除标识")
    private Integer deleted;

    @Schema(description = "创建者")
    private Long creator;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime createTime;

    @Schema(description = "更新者")
    private Long updater;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime updateTime;
}