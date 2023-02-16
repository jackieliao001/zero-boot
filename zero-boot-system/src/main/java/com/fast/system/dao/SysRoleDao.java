package com.fast.system.dao;

import com.fast.framework.mybatis.dao.BaseDao;
import com.fast.system.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 角色管理 Mapper 接口
 * </p>
 *
 * @author jackie
 * @since 2023-02-13
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {
    /**
     * 根据用户ID，获取用户最大的数据范围
     */
    Integer getDataScopeByUserId(@Param("userId") Long userId);
}
