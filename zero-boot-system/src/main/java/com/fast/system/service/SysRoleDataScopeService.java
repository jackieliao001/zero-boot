package com.fast.system.service;

import com.fast.framework.mybatis.service.BaseService;
import com.fast.system.entity.SysRoleDataScopeEntity;

import java.util.List;

/**
 * <p>
 * 角色数据权限 服务类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
public interface SysRoleDataScopeService extends BaseService<SysRoleDataScopeEntity> {
    /**
     * 保存或修改
     * @param roleId      角色ID
     * @param orgIdList   机构ID列表
     */
    void saveOrUpdate(Long roleId, List<Long> orgIdList);

    /**
     * 根据角色ID，获取机构ID列表
     */
    List<Long> getOrgIdList(Long roleId);

    /**
     * 根据角色id列表，删除角色数据权限关系
     * @param roleIdList 角色id列表
     */
    void deleteByRoleIdList(List<Long> roleIdList);
}