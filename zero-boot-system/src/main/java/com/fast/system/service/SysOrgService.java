package com.fast.system.service;

import com.fast.framework.common.bean.PageResult;
import com.fast.framework.mybatis.service.BaseService;
import com.fast.system.entity.SysOrgEntity;
import com.fast.system.query.SysOrgQuery;
import com.fast.system.vo.SysOrgVO;

import java.util.List;

/**
 * <p>
 * 机构管理 服务类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
public interface SysOrgService extends BaseService<SysOrgEntity> {
    PageResult<SysOrgVO> page(SysOrgQuery query);

    List<SysOrgVO> getList();

    void save(SysOrgVO vo);

    void update(SysOrgVO vo);

    void delete(Long id);

    /**
     * 根据机构ID，获取子机构ID列表(包含本机构ID)
     * @param orgId   机构ID
     * @return orgId list
     */
    List<Long> getSubOrgIdList(Long orgId);
}