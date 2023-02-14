package com.fast.system.service;

import com.fast.framework.common.bean.PageResult;
import com.fast.framework.mybatis.service.BaseService;
import com.fast.system.entity.SysPostEntity;
import com.fast.system.query.SysPostQuery;
import com.fast.system.vo.SysPostVO;

import java.util.List;

/**
 * <p>
 * 岗位管理 服务类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
public interface SysPostService extends BaseService<SysPostEntity> {
    PageResult<SysPostVO> page(SysPostQuery query);

    void save(SysPostVO vo);

    void update(SysPostVO vo);

    void delete(List<Long> idList);

    List<SysPostVO> getList();
}