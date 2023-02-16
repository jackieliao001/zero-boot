package com.fast.system.dao;

import com.fast.framework.mybatis.dao.BaseDao;
import com.fast.system.entity.SysPostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 岗位管理 Mapper 接口
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysPostDao extends BaseDao<SysPostEntity> {
}

