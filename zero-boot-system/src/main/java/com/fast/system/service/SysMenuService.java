package com.fast.system.service;

import com.fast.framework.common.bean.PageResult;
import com.fast.framework.mybatis.service.BaseService;
import com.fast.framework.security.user.UserDetail;
import com.fast.system.entity.SysMenuEntity;
import com.fast.system.query.SysMenuQuery;
import com.fast.system.vo.SysMenuVO;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {
    PageResult<SysMenuVO> page(SysMenuQuery query);

    void save(SysMenuVO vo);

    void update(SysMenuVO vo);

    void delete(Long id);

    /**
     * 菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuVO> getMenuList(Integer type);

    /**
     * 用户菜单列表
     *
     * @param user  用户
     * @param type 菜单类型
     */
    List<SysMenuVO> getUserMenuList(UserDetail user, Integer type);

    /**
     * 获取子菜单的数量
     * @param pid  父菜单ID
     */
    Long getSubMenuCount(Long pid);

    /**
     * 获取用户权限列表
     */
    Set<String> getUserAuthority(UserDetail user);
}