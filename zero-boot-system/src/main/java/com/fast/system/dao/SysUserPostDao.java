package com.fast.system.dao;

import com.fast.framework.mybatis.dao.BaseDao;
import com.fast.system.entity.SysUserPostEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户岗位关系 Mapper 接口
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysUserPostDao extends BaseDao<SysUserPostEntity> {
    /**
     * 岗位ID列表
     * @param userId  用户ID
     */
    List<Long> getPostIdList(Long userId);
}

