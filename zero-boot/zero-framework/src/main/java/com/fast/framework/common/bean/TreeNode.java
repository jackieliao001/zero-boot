package com.fast.framework.common.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树节点，所有需要实现树节点的，都需要继承该类
 *
 * @author liaojunjie
 * @date 2023/2/13 15:08
 */
@Data
public class TreeNode<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @Schema(description = "id")
    private Long id;
    /**
     * 上级ID
     */
    @Schema(description = "上级ID")
    @NotNull(message = "上级ID不能为空")
    private Long pid;
    /**
     * 子节点列表
     */
    private List<T> children = new ArrayList<>();
}