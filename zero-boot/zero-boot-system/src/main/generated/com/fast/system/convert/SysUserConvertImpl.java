package com.fast.system.convert;

import com.fast.framework.security.user.UserDetail;
import com.fast.system.entity.SysUserEntity;
import com.fast.system.vo.SysUserVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T20:22:20+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public SysUserEntity convert(SysUserVO vo) {
        if ( vo == null ) {
            return null;
        }

        SysUserEntity sysUserEntity = new SysUserEntity();

        sysUserEntity.setId( vo.getId() );
        sysUserEntity.setCreateTime( vo.getCreateTime() );
        sysUserEntity.setUsername( vo.getUsername() );
        sysUserEntity.setPassword( vo.getPassword() );
        sysUserEntity.setRealName( vo.getRealName() );
        sysUserEntity.setAvatar( vo.getAvatar() );
        sysUserEntity.setGender( vo.getGender() );
        sysUserEntity.setEmail( vo.getEmail() );
        sysUserEntity.setMobile( vo.getMobile() );
        sysUserEntity.setOrgId( vo.getOrgId() );
        sysUserEntity.setSuperAdmin( vo.getSuperAdmin() );
        sysUserEntity.setStatus( vo.getStatus() );
        sysUserEntity.setOrgName( vo.getOrgName() );
        if ( sysUserEntity.getTransMap() != null ) {
            Map<String, String> map = vo.getTransMap();
            if ( map != null ) {
                sysUserEntity.getTransMap().putAll( map );
            }
        }

        return sysUserEntity;
    }

    @Override
    public SysUserVO convert(SysUserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SysUserVO sysUserVO = new SysUserVO();

        sysUserVO.setId( entity.getId() );
        sysUserVO.setUsername( entity.getUsername() );
        sysUserVO.setPassword( entity.getPassword() );
        sysUserVO.setRealName( entity.getRealName() );
        sysUserVO.setAvatar( entity.getAvatar() );
        sysUserVO.setGender( entity.getGender() );
        sysUserVO.setEmail( entity.getEmail() );
        sysUserVO.setMobile( entity.getMobile() );
        sysUserVO.setOrgId( entity.getOrgId() );
        sysUserVO.setStatus( entity.getStatus() );
        sysUserVO.setSuperAdmin( entity.getSuperAdmin() );
        sysUserVO.setOrgName( entity.getOrgName() );
        sysUserVO.setCreateTime( entity.getCreateTime() );
        if ( sysUserVO.getTransMap() != null ) {
            Map<String, String> map = entity.getTransMap();
            if ( map != null ) {
                sysUserVO.getTransMap().putAll( map );
            }
        }

        return sysUserVO;
    }

    @Override
    public List<SysUserVO> convertList(List<SysUserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SysUserVO> list1 = new ArrayList<SysUserVO>( list.size() );
        for ( SysUserEntity sysUserEntity : list ) {
            list1.add( convert( sysUserEntity ) );
        }

        return list1;
    }

    @Override
    public UserDetail convertDetail(SysUserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDetail userDetail = new UserDetail();

        userDetail.setId( entity.getId() );
        userDetail.setUsername( entity.getUsername() );
        userDetail.setPassword( entity.getPassword() );
        userDetail.setRealName( entity.getRealName() );
        userDetail.setAvatar( entity.getAvatar() );
        userDetail.setGender( entity.getGender() );
        userDetail.setEmail( entity.getEmail() );
        userDetail.setMobile( entity.getMobile() );
        userDetail.setOrgId( entity.getOrgId() );
        userDetail.setStatus( entity.getStatus() );
        userDetail.setSuperAdmin( entity.getSuperAdmin() );

        return userDetail;
    }
}
