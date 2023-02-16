package com.fast.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import com.fast.framework.common.utils.DateUtils;

/**
 * 附件管理
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@Schema(description = "附件管理")
public class SysAttachmentVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "附件名称")
    private String name;
    @Schema(description = "附件地址")
    private String url;
    @Schema(description = "附件大小")
    private Long size;
    @Schema(description = "存储平台")
    private String platform;
}