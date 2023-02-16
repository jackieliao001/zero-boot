package com.fast.system.convert;

import com.fast.system.entity.SysAttachmentEntity;
import com.fast.system.vo.SysAttachmentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 附件管理 转换类类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@Mapper
public interface SysAttachmentConvert {
    SysAttachmentConvert INSTANCE = Mappers.getMapper(SysAttachmentConvert.class);

    SysAttachmentEntity convert(SysAttachmentVO vo);

    SysAttachmentVO convert(SysAttachmentEntity entity);

    List<SysAttachmentVO> convertList(List<SysAttachmentEntity> list);
}