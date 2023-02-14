package com.fast.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fast.framework.mybatis.dao.BaseDao;
import com.fast.system.entity.SysParamsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 参数管理 Mapper 接口
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysParamsDao extends BaseDao<SysParamsEntity> {
    default boolean isExist(String paramKey) {
        return this.exists(new QueryWrapper<SysParamsEntity>().eq("param_key", paramKey));
    }
}

