package com.fast.system.controller;

import com.fast.framework.common.bean.PageResult;
import com.fast.framework.common.bean.Result;
import com.fast.system.convert.SysRoleConvert;
import com.fast.system.entity.SysRoleEntity;
import com.fast.system.query.SysRoleQuery;
import com.fast.system.service.SysRoleService;
import com.fast.system.vo.SysRoleVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理  接口控制器
 *
 * @author jackie
 * @date 2023-02-13
 */
@RestController
@RequestMapping("sys/role" )
@Tag(name = "角色管理" )
@AllArgsConstructor
public class SysRoleController {
    private final SysRoleService sysRoleService;

    @GetMapping("page" )
    @Operation(summary = "分页" )
    @PreAuthorize("hasAuthority('sys:role:page')" )
    public Result<PageResult<SysRoleVO>> page(@Valid SysRoleQuery query) {
        PageResult<SysRoleVO> page = sysRoleService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}" )
    @Operation(summary = "信息" )
    @PreAuthorize("hasAuthority('sys:role:info')" )
    public Result<SysRoleVO> get(@PathVariable("id" ) Long id) {
        SysRoleEntity entity = sysRoleService.getById(id);

        return Result.ok(SysRoleConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存" )
    @PreAuthorize("hasAuthority('sys:role:save')" )
    public Result<String> save(@RequestBody SysRoleVO vo) {
        sysRoleService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改" )
    @PreAuthorize("hasAuthority('sys:role:update')" )
    public Result<String> update(@RequestBody @Valid SysRoleVO vo) {
        sysRoleService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除" )
    @PreAuthorize("hasAuthority('sys:role:delete')" )
    public Result<String> delete(@RequestBody List<Long> idList) {
        sysRoleService.delete(idList);

        return Result.ok();
    }
}