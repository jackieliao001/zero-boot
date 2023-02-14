package com.fast.system.service;

import com.fast.framework.common.bean.PageResult;
import com.fast.framework.mybatis.service.BaseService;
import com.fast.system.entity.SysDictDataEntity;
import com.fast.system.query.SysDictDataQuery;
import com.fast.system.vo.SysDictDataVO;

import java.util.List;

/**
 * 数据字典
 *
 * @author jackie
 * @date 2023-02-13
 */
public interface SysDictDataService extends BaseService<SysDictDataEntity> {

    PageResult<SysDictDataVO> page(SysDictDataQuery query);

    void save(SysDictDataVO vo);

    void update(SysDictDataVO vo);

    void delete(List<Long> idList);
}