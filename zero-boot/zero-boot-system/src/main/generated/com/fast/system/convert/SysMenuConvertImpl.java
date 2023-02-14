package com.fast.system.convert;

import com.fast.system.entity.SysMenuEntity;
import com.fast.system.vo.SysMenuVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T20:22:20+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class SysMenuConvertImpl implements SysMenuConvert {

    @Override
    public SysMenuEntity convert(SysMenuVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysMenuEntity sysMenuEntity = new SysMenuEntity();

        sysMenuEntity.setId( vo.getId() );
        sysMenuEntity.setCreateTime( vo.getCreateTime() );
        sysMenuEntity.setPid( vo.getPid() );
        sysMenuEntity.setName( vo.getName() );
        sysMenuEntity.setUrl( vo.getUrl() );
        sysMenuEntity.setAuthority( vo.getAuthority() );
        sysMenuEntity.setType( vo.getType() );
        sysMenuEntity.setOpenStyle( vo.getOpenStyle() );
        sysMenuEntity.setIcon( vo.getIcon() );
        sysMenuEntity.setSort( vo.getSort() );

        return sysMenuEntity;
    }

    @Override
    public SysMenuVO convert(SysMenuEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysMenuVO sysMenuVO = new SysMenuVO();

        sysMenuVO.setId( entity.getId() );
        sysMenuVO.setPid( entity.getPid() );
        sysMenuVO.setName( entity.getName() );
        sysMenuVO.setUrl( entity.getUrl() );
        sysMenuVO.setAuthority( entity.getAuthority() );
        sysMenuVO.setType( entity.getType() );
        sysMenuVO.setOpenStyle( entity.getOpenStyle() );
        sysMenuVO.setIcon( entity.getIcon() );
        sysMenuVO.setSort( entity.getSort() );
        sysMenuVO.setCreateTime( entity.getCreateTime() );

        return sysMenuVO;
    }

    @Override
    public List<SysMenuVO> convertList(List<SysMenuEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysMenuVO> list1 = new ArrayList<SysMenuVO>( list.size() );
        for ( SysMenuEntity sysMenuEntity : list ) {
            list1.add( convert( sysMenuEntity ) );
        }

        return list1;
    }
}
