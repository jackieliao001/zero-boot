package com.fast.system.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fast.framework.common.bean.Query;

/**
 * 附件管理查询
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "附件管理查询")
public class SysAttachmentQuery extends Query {
    @Schema(description = "附件名称")
    private String name;
    @Schema(description = "附件地址")
    private String url;
    @Schema(description = "附件大小")
    private Long size;
    @Schema(description = "存储平台")
    private String platform;
}