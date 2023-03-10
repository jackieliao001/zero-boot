package com.fast.system.query;

import com.fast.framework.common.bean.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 登录日志查询
 *
 * @author liaojunjie
 * @date 2023/2/13 15:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "登录日志查询")
public class SysLogLoginQuery extends Query {
    @Schema(description = "用户名")
    private String username;

    @Schema(description = "登录地点")
    private String address;

    @Schema(description = "登录状态  0：失败   1：成功")
    private Integer status;
}