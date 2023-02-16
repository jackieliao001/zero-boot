package com.fast.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fast.framework.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色菜单关系
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role_menu" )
public class SysRoleMenuEntity extends BaseEntity {

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;
}
