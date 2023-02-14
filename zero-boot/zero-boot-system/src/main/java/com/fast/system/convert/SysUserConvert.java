package com.fast.system.convert;

import com.fast.framework.security.user.UserDetail;
import com.fast.system.entity.SysUserEntity;
import com.fast.system.vo.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 用户管理 转换类类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserEntity convert(SysUserVO vo);

    SysUserVO convert(SysUserEntity entity);

    List<SysUserVO> convertList(List<SysUserEntity> list);

    UserDetail convertDetail(SysUserEntity entity);

/*    List<SysUserExcelVO> convert2List(List<SysUserEntity> list);

    List<SysUserEntity> convertListEntity(List<SysUserExcelVO> list);*/
}