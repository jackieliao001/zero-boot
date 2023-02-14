package com.fast.system.convert;

import com.fast.system.entity.SysRoleEntity;
import com.fast.system.vo.SysRoleVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T17:40:14+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class SysRoleConvertImpl implements SysRoleConvert {

    @Override
    public SysRoleEntity convert(SysRoleVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysRoleEntity sysRoleEntity = new SysRoleEntity();

        sysRoleEntity.setName( vo.getName() );
        sysRoleEntity.setRemark( vo.getRemark() );
        sysRoleEntity.setDataScope( vo.getDataScope() );
        sysRoleEntity.setOrgId( vo.getOrgId() );

        return sysRoleEntity;
    }

    @Override
    public SysRoleVO convert(SysRoleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysRoleVO sysRoleVO = new SysRoleVO();

        sysRoleVO.setName( entity.getName() );
        sysRoleVO.setRemark( entity.getRemark() );
        sysRoleVO.setDataScope( entity.getDataScope() );
        sysRoleVO.setOrgId( entity.getOrgId() );

        return sysRoleVO;
    }

    @Override
    public List<SysRoleVO> convertList(List<SysRoleEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysRoleVO> list1 = new ArrayList<SysRoleVO>( list.size() );
        for ( SysRoleEntity sysRoleEntity : list ) {
            list1.add( convert( sysRoleEntity ) );
        }

        return list1;
    }
}
