package com.fast.system.service;

import com.fast.framework.common.bean.PageResult;
import com.fast.framework.mybatis.service.BaseService;
import com.fast.system.entity.SysRoleEntity;
import com.fast.system.query.SysRoleQuery;
import com.fast.system.vo.SysRoleVO;

import java.util.List;

/**
 * <p>
 * 角色管理 服务类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {
    PageResult<SysRoleVO> page(SysRoleQuery query);

    void save(SysRoleVO vo);

    void update(SysRoleVO vo);

    void delete(List<Long> idList);
}