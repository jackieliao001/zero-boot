package com.fast.system.convert;

import com.fast.system.entity.SysRoleMenuEntity;
import com.fast.system.vo.SysRoleMenuVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T17:40:14+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class SysRoleMenuConvertImpl implements SysRoleMenuConvert {

    @Override
    public SysRoleMenuEntity convert(SysRoleMenuVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();

        sysRoleMenuEntity.setRoleId( vo.getRoleId() );
        sysRoleMenuEntity.setMenuId( vo.getMenuId() );

        return sysRoleMenuEntity;
    }

    @Override
    public SysRoleMenuVO convert(SysRoleMenuEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysRoleMenuVO sysRoleMenuVO = new SysRoleMenuVO();

        sysRoleMenuVO.setRoleId( entity.getRoleId() );
        sysRoleMenuVO.setMenuId( entity.getMenuId() );

        return sysRoleMenuVO;
    }

    @Override
    public List<SysRoleMenuVO> convertList(List<SysRoleMenuEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysRoleMenuVO> list1 = new ArrayList<SysRoleMenuVO>( list.size() );
        for ( SysRoleMenuEntity sysRoleMenuEntity : list ) {
            list1.add( convert( sysRoleMenuEntity ) );
        }

        return list1;
    }
}
