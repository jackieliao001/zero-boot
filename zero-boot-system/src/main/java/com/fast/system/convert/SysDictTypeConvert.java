package com.fast.system.convert;

import com.fast.system.entity.SysDictTypeEntity;
import com.fast.system.vo.SysDictTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 字典类型
 *
 * @author liaojunjie
 * @date 2023/2/13 15:42
 */
@Mapper
public interface SysDictTypeConvert {
    SysDictTypeConvert INSTANCE = Mappers.getMapper(SysDictTypeConvert.class);

    SysDictTypeVO convert(SysDictTypeEntity entity);

    SysDictTypeEntity convert(SysDictTypeVO vo);
    
    List<SysDictTypeVO> convertList(List<SysDictTypeEntity> list);

}
