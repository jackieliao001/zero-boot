package com.fast.system.dao;

import com.fast.framework.mybatis.dao.BaseDao;
import com.fast.system.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色菜单关系 Mapper 接口
 * </p>
 *
 * @author jackie
 * @since 2023-02-13
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
    /**
     * 根据角色ID，获取菜单ID列表
     */
    @Select("select menu_id from sys_role_menu where role_id = #{roleId} and deleted = 0")
    List<Long> getMenuIdList(@Param("roleId") Long roleId);
}
