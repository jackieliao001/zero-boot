package com.fast.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fast.framework.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu" )
public class SysMenuEntity extends BaseEntity {

    /**
     * 上级ID，一级菜单为0
     */
    private Long pid;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权标识(多个用逗号分隔，如：sys:menu:list,sys:menu:save)
     */
    private String authority;

    /**
     * 类型   0：菜单   1：按钮   2：接口
     */
    private Byte type;

    /**
     * 打开方式   0：内部   1：外部
     */
    private Byte openStyle;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;
}
