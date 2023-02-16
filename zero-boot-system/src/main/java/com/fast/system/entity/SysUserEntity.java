package com.fast.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fast.framework.mybatis.entity.BaseEntity;
import com.fast.system.enums.UserStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user" )
public class SysUserEntity extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别   0：男   1：女   2：未知
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 机构ID
     */
    private Long orgId;

    /**
     * 超级管理员   0：否   1：是
     */
    private Integer superAdmin;

    /**
     * 状态  0：停用   1：正常  {@link UserStatusEnum}
     */
    private Integer status;

    /**
     * 机构名称
     */
    @TableField(exist=false)
    private String orgName;
}
