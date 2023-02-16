package com.fast.system.dao;

import com.fast.framework.mybatis.dao.BaseDao;
import com.fast.system.entity.SysLogLoginEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录日志
 *
 * @author liaojunjie
 * @date 2023/2/13 15:47
 */
@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {
}