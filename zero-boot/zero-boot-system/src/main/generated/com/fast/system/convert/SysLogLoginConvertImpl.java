package com.fast.system.convert;

import com.fast.system.entity.SysLogLoginEntity;
import com.fast.system.vo.SysLogLoginVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T17:40:14+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class SysLogLoginConvertImpl implements SysLogLoginConvert {

    @Override
    public SysLogLoginEntity convert(SysLogLoginVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysLogLoginEntity sysLogLoginEntity = new SysLogLoginEntity();

        return sysLogLoginEntity;
    }

    @Override
    public SysLogLoginVO convert(SysLogLoginEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysLogLoginVO sysLogLoginVO = new SysLogLoginVO();

        return sysLogLoginVO;
    }

    @Override
    public List<SysLogLoginVO> convertList(List<SysLogLoginEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysLogLoginVO> list1 = new ArrayList<SysLogLoginVO>( list.size() );
        for ( SysLogLoginEntity sysLogLoginEntity : list ) {
            list1.add( convert( sysLogLoginEntity ) );
        }

        return list1;
    }
}
