package com.fast.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fast.framework.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 机构管理
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("sys_org" )
public class SysOrgEntity extends BaseEntity {

    /**
     * 上级ID
     */
    private Long pid;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 上级名称
     */
    @TableField(exist = false)
    private String parentName;
}
