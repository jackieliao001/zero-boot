package com.fast.system.convert;

import com.fast.system.entity.SysRoleEntity;
import com.fast.system.vo.SysRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 角色管理 转换类类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRoleEntity convert(SysRoleVO vo);

    SysRoleVO convert(SysRoleEntity entity);

    List<SysRoleVO> convertList(List<SysRoleEntity> list);

}