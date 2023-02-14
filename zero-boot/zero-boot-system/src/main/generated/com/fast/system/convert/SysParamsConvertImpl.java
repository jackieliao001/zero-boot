package com.fast.system.convert;

import com.fast.system.entity.SysParamsEntity;
import com.fast.system.vo.SysParamsVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T17:40:14+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class SysParamsConvertImpl implements SysParamsConvert {

    @Override
    public SysParamsEntity convert(SysParamsVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysParamsEntity sysParamsEntity = new SysParamsEntity();

        sysParamsEntity.setId( vo.getId() );
        sysParamsEntity.setCreator( vo.getCreator() );
        sysParamsEntity.setCreateTime( vo.getCreateTime() );
        sysParamsEntity.setUpdater( vo.getUpdater() );
        sysParamsEntity.setUpdateTime( vo.getUpdateTime() );
        sysParamsEntity.setVersion( vo.getVersion() );
        sysParamsEntity.setDeleted( vo.getDeleted() );
        sysParamsEntity.setParamName( vo.getParamName() );
        sysParamsEntity.setParamType( vo.getParamType() );
        sysParamsEntity.setParamKey( vo.getParamKey() );
        sysParamsEntity.setParamValue( vo.getParamValue() );
        sysParamsEntity.setRemark( vo.getRemark() );

        return sysParamsEntity;
    }

    @Override
    public SysParamsVO convert(SysParamsEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysParamsVO sysParamsVO = new SysParamsVO();

        sysParamsVO.setId( entity.getId() );
        sysParamsVO.setParamName( entity.getParamName() );
        sysParamsVO.setParamType( entity.getParamType() );
        sysParamsVO.setParamKey( entity.getParamKey() );
        sysParamsVO.setParamValue( entity.getParamValue() );
        sysParamsVO.setRemark( entity.getRemark() );
        sysParamsVO.setVersion( entity.getVersion() );
        sysParamsVO.setDeleted( entity.getDeleted() );
        sysParamsVO.setCreator( entity.getCreator() );
        sysParamsVO.setCreateTime( entity.getCreateTime() );
        sysParamsVO.setUpdater( entity.getUpdater() );
        sysParamsVO.setUpdateTime( entity.getUpdateTime() );

        return sysParamsVO;
    }

    @Override
    public List<SysParamsVO> convertList(List<SysParamsEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysParamsVO> list1 = new ArrayList<SysParamsVO>( list.size() );
        for ( SysParamsEntity sysParamsEntity : list ) {
            list1.add( convert( sysParamsEntity ) );
        }

        return list1;
    }
}
