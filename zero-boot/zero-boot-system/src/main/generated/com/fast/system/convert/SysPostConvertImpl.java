package com.fast.system.convert;

import com.fast.system.entity.SysPostEntity;
import com.fast.system.vo.SysPostVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T17:40:14+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class SysPostConvertImpl implements SysPostConvert {

    @Override
    public SysPostEntity convert(SysPostVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysPostEntity sysPostEntity = new SysPostEntity();

        sysPostEntity.setPostCode( vo.getPostCode() );
        sysPostEntity.setPostName( vo.getPostName() );
        sysPostEntity.setSort( vo.getSort() );
        sysPostEntity.setStatus( vo.getStatus() );

        return sysPostEntity;
    }

    @Override
    public SysPostVO convert(SysPostEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysPostVO sysPostVO = new SysPostVO();

        sysPostVO.setPostCode( entity.getPostCode() );
        sysPostVO.setPostName( entity.getPostName() );
        sysPostVO.setSort( entity.getSort() );
        sysPostVO.setStatus( entity.getStatus() );

        return sysPostVO;
    }

    @Override
    public List<SysPostVO> convertList(List<SysPostEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysPostVO> list1 = new ArrayList<SysPostVO>( list.size() );
        for ( SysPostEntity sysPostEntity : list ) {
            list1.add( convert( sysPostEntity ) );
        }

        return list1;
    }
}
