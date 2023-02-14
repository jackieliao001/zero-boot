package com.fast.system.convert;

import com.fast.system.entity.SysOrgEntity;
import com.fast.system.vo.SysOrgVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T17:40:14+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class SysOrgConvertImpl implements SysOrgConvert {

    @Override
    public SysOrgEntity convert(SysOrgVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysOrgEntity sysOrgEntity = new SysOrgEntity();

        sysOrgEntity.setId( vo.getId() );
        sysOrgEntity.setPid( vo.getPid() );
        sysOrgEntity.setName( vo.getName() );
        sysOrgEntity.setSort( vo.getSort() );

        return sysOrgEntity;
    }

    @Override
    public SysOrgVO convert(SysOrgEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysOrgVO sysOrgVO = new SysOrgVO();

        sysOrgVO.setId( entity.getId() );
        sysOrgVO.setPid( entity.getPid() );
        sysOrgVO.setName( entity.getName() );
        sysOrgVO.setSort( entity.getSort() );

        return sysOrgVO;
    }

    @Override
    public List<SysOrgVO> convertList(List<SysOrgEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysOrgVO> list1 = new ArrayList<SysOrgVO>( list.size() );
        for ( SysOrgEntity sysOrgEntity : list ) {
            list1.add( convert( sysOrgEntity ) );
        }

        return list1;
    }
}
