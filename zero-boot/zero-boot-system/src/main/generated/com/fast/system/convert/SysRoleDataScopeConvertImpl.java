package com.fast.system.convert;

import com.fast.system.entity.SysRoleDataScopeEntity;
import com.fast.system.vo.SysRoleDataScopeVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T17:40:14+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class SysRoleDataScopeConvertImpl implements SysRoleDataScopeConvert {

    @Override
    public SysRoleDataScopeEntity convert(SysRoleDataScopeVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysRoleDataScopeEntity sysRoleDataScopeEntity = new SysRoleDataScopeEntity();

        sysRoleDataScopeEntity.setRoleId( vo.getRoleId() );
        sysRoleDataScopeEntity.setOrgId( vo.getOrgId() );

        return sysRoleDataScopeEntity;
    }

    @Override
    public SysRoleDataScopeVO convert(SysRoleDataScopeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysRoleDataScopeVO sysRoleDataScopeVO = new SysRoleDataScopeVO();

        sysRoleDataScopeVO.setRoleId( entity.getRoleId() );
        sysRoleDataScopeVO.setOrgId( entity.getOrgId() );

        return sysRoleDataScopeVO;
    }

    @Override
    public List<SysRoleDataScopeVO> convertList(List<SysRoleDataScopeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysRoleDataScopeVO> list1 = new ArrayList<SysRoleDataScopeVO>( list.size() );
        for ( SysRoleDataScopeEntity sysRoleDataScopeEntity : list ) {
            list1.add( convert( sysRoleDataScopeEntity ) );
        }

        return list1;
    }
}
