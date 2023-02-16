package com.fast.system.service;

import com.fast.framework.mybatis.service.BaseService;
import com.fast.system.entity.SysUserPostEntity;

import java.util.List;

/**
 * <p>
 * 用户岗位关系 服务类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
public interface SysUserPostService extends BaseService<SysUserPostEntity> {
    /**
     * 保存或修改
     *
     * @param userId     用户ID
     * @param postIdList 岗位ID列表
     */
    void saveOrUpdate(Long userId, List<Long> postIdList);

    /**
     * 根据岗位id列表，删除用户岗位关系
     *
     * @param postIdList 岗位id列表
     */
    void deleteByPostIdList(List<Long> postIdList);

    /**
     * 根据用户id列表，删除用户岗位关系
     *
     * @param userIdList 用户id列表
     */
    void deleteByUserIdList(List<Long> userIdList);

    /**
     * 岗位ID列表
     *
     * @param userId 用户ID
     */
    List<Long> getPostIdList(Long userId);
}