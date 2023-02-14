package com.fast.system.convert;

import com.fast.system.entity.SysAttachmentEntity;
import com.fast.system.vo.SysAttachmentVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T17:40:13+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class SysAttachmentConvertImpl implements SysAttachmentConvert {

    @Override
    public SysAttachmentEntity convert(SysAttachmentVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysAttachmentEntity sysAttachmentEntity = new SysAttachmentEntity();

        sysAttachmentEntity.setName( vo.getName() );
        sysAttachmentEntity.setUrl( vo.getUrl() );
        sysAttachmentEntity.setSize( vo.getSize() );
        sysAttachmentEntity.setPlatform( vo.getPlatform() );

        return sysAttachmentEntity;
    }

    @Override
    public SysAttachmentVO convert(SysAttachmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysAttachmentVO sysAttachmentVO = new SysAttachmentVO();

        sysAttachmentVO.setName( entity.getName() );
        sysAttachmentVO.setUrl( entity.getUrl() );
        sysAttachmentVO.setSize( entity.getSize() );
        sysAttachmentVO.setPlatform( entity.getPlatform() );

        return sysAttachmentVO;
    }

    @Override
    public List<SysAttachmentVO> convertList(List<SysAttachmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysAttachmentVO> list1 = new ArrayList<SysAttachmentVO>( list.size() );
        for ( SysAttachmentEntity sysAttachmentEntity : list ) {
            list1.add( convert( sysAttachmentEntity ) );
        }

        return list1;
    }
}
