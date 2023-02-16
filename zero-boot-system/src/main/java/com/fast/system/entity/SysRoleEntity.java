package com.fast.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fast.framework.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色管理
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role" )
public class SysRoleEntity extends BaseEntity {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据范围  0：全部数据  1：本机构及子机构数据  2：本机构数据  3：本人数据  4：自定义数据
     */
    private Byte dataScope;

    /**
     * 机构ID
     */
    private Long orgId;

}
