package com.fast.system.convert;

import com.fast.system.entity.SysRoleMenuEntity;
import com.fast.system.vo.SysRoleMenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 角色菜单关系 转换类类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysRoleMenuConvert {
    SysRoleMenuConvert INSTANCE = Mappers.getMapper(SysRoleMenuConvert.class);

    SysRoleMenuEntity convert(SysRoleMenuVO vo);

    SysRoleMenuVO convert(SysRoleMenuEntity entity);

    List<SysRoleMenuVO> convertList(List<SysRoleMenuEntity> list);

}