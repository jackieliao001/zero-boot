package com.fast.system.dao;

import com.fast.framework.mybatis.dao.BaseDao;
import com.fast.system.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户角色关系 Mapper 接口
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {
    /**
     * 角色ID列表
     * @param userId  用户ID
     *
     * @return  返回角色ID列表
     */
    List<Long> getRoleIdList(Long userId);
}

