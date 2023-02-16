package com.fast.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fast.framework.common.bean.PageResult;
import com.fast.framework.common.constant.Constant;
import com.fast.framework.common.exception.ServerException;
import com.fast.framework.common.utils.TreeUtils;
import com.fast.framework.mybatis.service.impl.BaseServiceImpl;
import com.fast.system.convert.SysOrgConvert;
import com.fast.system.dao.SysOrgDao;
import com.fast.system.dao.SysUserDao;
import com.fast.system.entity.SysOrgEntity;
import com.fast.system.entity.SysUserEntity;
import com.fast.system.query.SysOrgQuery;
import com.fast.system.service.SysOrgService;
import com.fast.system.vo.SysOrgVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 机构管理 服务实现类
 *
 * @author jackie
 * @date 2023-02-13
 */
@Service
@AllArgsConstructor
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrgDao, SysOrgEntity> implements SysOrgService {
    private final SysUserDao sysUserDao;

    @Override
    public PageResult<SysOrgVO> page(SysOrgQuery query) {
        IPage<SysOrgEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysOrgConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<SysOrgEntity> getWrapper(SysOrgQuery query) {
        LambdaQueryWrapper<SysOrgEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(SysOrgEntity::getName,query.getName())
                .eq(SysOrgEntity::getPid,query.getPid());
        return wrapper;
    }

    @Override
    public List<SysOrgVO> getList() {
        Map<String, Object> params = new HashMap<>();

        // 数据权限
        params.put(Constant.DATA_SCOPE, getDataScope("t1", "id"));

        // 机构列表
        List<SysOrgEntity> entityList = baseMapper.getList(params);

        return TreeUtils.build(SysOrgConvert.INSTANCE.convertList(entityList));
    }




    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysOrgVO vo) {
        SysOrgEntity entity = SysOrgConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysOrgVO vo) {
        SysOrgEntity entity = SysOrgConvert.INSTANCE.convert(vo);
        // 上级机构不能为自身
        if(entity.getId().equals(entity.getPid())){
            throw new ServerException("上级机构不能为自身");
        }

        // 上级机构不能为下级
        List<Long> subOrgList = getSubOrgIdList(entity.getId());
        if(subOrgList.contains(entity.getPid())){
            throw new ServerException("上级机构不能为下级");
        }
        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        // 判断是否有子机构
        long orgCount = count(new LambdaQueryWrapper<SysOrgEntity>().eq(SysOrgEntity::getPid, id));
        if(orgCount > 0){
            throw new ServerException("请先删除子机构");
        }

        // 判断机构下面是否有用户
        long userCount = sysUserDao.selectCount(new LambdaQueryWrapper<SysUserEntity>().eq(SysUserEntity::getOrgId, id));
        if(userCount > 0){
            throw new ServerException("机构下面有用户，不能删除");
        }

        removeById(id);
    }

    @Override
    public List<Long> getSubOrgIdList(Long orgId) {
        // 所有机构的id、pid列表
        List<SysOrgEntity> orgList = baseMapper.getIdAndPidList();

        // 递归查询所有子机构ID列表
        List<Long> subIdList = new ArrayList<>();
        getTree(orgId, orgList, subIdList);

        // 本机构也添加进去
        subIdList.add(orgId);

        return subIdList;
    }

    private void getTree(Long id, List<SysOrgEntity> orgList, List<Long> subIdList) {
        for(SysOrgEntity org : orgList){
            if (org.getPid().equals(id)){
                getTree(org.getId(), orgList, subIdList);

                subIdList.add(org.getId());
            }
        }
    }
}