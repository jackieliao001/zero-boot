package com.fast.system.convert;

import com.fast.system.entity.SysDictDataEntity;
import com.fast.system.vo.SysDictDataVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据字典
 *
 * @author liaojunjie
 * @date 2023/2/13 15:42
 */
@Mapper
public interface SysDictDataConvert {
    SysDictDataConvert INSTANCE = Mappers.getMapper(SysDictDataConvert.class);

    SysDictDataVO convert(SysDictDataEntity entity);

    SysDictDataEntity convert(SysDictDataVO vo);
    
    List<SysDictDataVO> convertList(List<SysDictDataEntity> list);

}
