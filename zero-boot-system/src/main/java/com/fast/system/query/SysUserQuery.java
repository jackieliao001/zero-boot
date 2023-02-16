package com.fast.system.query;

import com.fast.framework.common.bean.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户管理查询
 *
 * @author jackie
 * @since 2023-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "用户管理查询" )
public class SysUserQuery extends Query {
    @Schema(description = "用户名" )
    private String username;

    @Schema(description = "姓名" )
    private String realName;

    @Schema(description = "性别   0：男   1：女   2：未知" )
    private Integer gender;

    @Schema(description = "邮箱" )
    private String email;

    @Schema(description = "手机号" )
    private String mobile;

    @Schema(description = "机构ID" )
    private Long orgId;
}