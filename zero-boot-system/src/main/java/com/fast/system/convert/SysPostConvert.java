package com.fast.system.convert;

import com.fast.system.entity.SysPostEntity;
import com.fast.system.vo.SysPostVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 岗位管理 转换类类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysPostConvert {
    SysPostConvert INSTANCE = Mappers.getMapper(SysPostConvert.class);

    SysPostEntity convert(SysPostVO vo);

    SysPostVO convert(SysPostEntity entity);

    List<SysPostVO> convertList(List<SysPostEntity> list);
}