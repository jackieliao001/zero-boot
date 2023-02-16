package com.fast.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fast.framework.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户岗位关系
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user_post" )
public class SysUserPostEntity extends BaseEntity {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 岗位ID
     */
    private Long postId;

}
