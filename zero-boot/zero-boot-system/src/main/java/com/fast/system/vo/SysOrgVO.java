package com.fast.system.vo;

import com.fast.framework.common.bean.TreeNode;
import com.fast.framework.common.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


/**
 * 机构管理
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "机构管理" )
public class SysOrgVO extends TreeNode<SysOrgVO> {
    @Schema(description = "机构名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "机构名称不能为空")
    private String name;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @Min(value = 0, message = "排序值不能小于0")
    private Integer sort;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime createTime;

    @Schema(description = "上级名称")
    private String parentName;
}