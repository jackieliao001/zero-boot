package com.fast.system.convert;

import com.fast.system.entity.SysRoleDataScopeEntity;
import com.fast.system.vo.SysRoleDataScopeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 角色数据权限 转换类类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysRoleDataScopeConvert {
    SysRoleDataScopeConvert INSTANCE = Mappers.getMapper(SysRoleDataScopeConvert.class);

    SysRoleDataScopeEntity convert(SysRoleDataScopeVO vo);

    SysRoleDataScopeVO convert(SysRoleDataScopeEntity entity);

    List<SysRoleDataScopeVO> convertList(List<SysRoleDataScopeEntity> list);

}