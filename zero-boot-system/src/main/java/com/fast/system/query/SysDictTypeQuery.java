package com.fast.system.query;

import com.fast.framework.common.bean.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典类型
 *
 * @author liaojunjie
 * @date 2023/2/13 15:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "字典类型查询")
public class SysDictTypeQuery extends Query {
    @Schema(description = "字典类型")
    private String dictType;

    @Schema(description = "字典名称")
    private String dictName;
}
