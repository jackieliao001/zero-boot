package com.fast.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fast.framework.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色数据权限
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role_data_scope" )
public class SysRoleDataScopeEntity extends BaseEntity {

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 机构ID
     */
    private Long orgId;

}
