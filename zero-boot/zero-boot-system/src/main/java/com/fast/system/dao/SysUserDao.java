package com.fast.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fast.framework.mybatis.dao.BaseDao;
import com.fast.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
    List<SysUserEntity> findList(Map<String,Object> params);

    SysUserEntity getById(@Param("id") Long id);

    List<SysUserEntity> getRoleUserList(Map<String, Object> params);

    default SysUserEntity getByUsername(String username){
        return this.selectOne(new LambdaQueryWrapper<>(SysUserEntity.class).eq(SysUserEntity::getUsername, username));
    }

    default SysUserEntity getByMobile(String mobile){
        return this.selectOne(new LambdaQueryWrapper<>(SysUserEntity.class).eq(SysUserEntity::getMobile, mobile));
    }
}

