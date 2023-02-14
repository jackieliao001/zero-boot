package com.fast.system.service;

import com.fast.framework.common.bean.PageResult;
import com.fast.framework.mybatis.service.BaseService;
import com.fast.system.entity.SysDictTypeEntity;
import com.fast.system.query.SysDictTypeQuery;
import com.fast.system.vo.SysDictTypeVO;
import com.fast.system.vo.SysDictVO;

import java.util.List;

/**
 * 数据字典
 *
 * @author jackie
 * @date 2023-02-13
 */
public interface SysDictTypeService extends BaseService<SysDictTypeEntity> {

    PageResult<SysDictTypeVO> page(SysDictTypeQuery query);

    void save(SysDictTypeVO vo);

    void update(SysDictTypeVO vo);

    void delete(List<Long> idList);

    /**
     * 获取动态SQL数据
     */
    List<SysDictVO.DictData> getDictSql(Long id);

    /**
     * 获取全部字典列表
     */
    List<SysDictVO> getDictList();

    /**
     * 刷新字典缓存
     */
    void refreshTransCache();
}