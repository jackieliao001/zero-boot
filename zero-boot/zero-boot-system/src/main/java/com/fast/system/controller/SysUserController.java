package com.fast.system.controller;

import com.fast.framework.common.bean.PageResult;
import com.fast.framework.common.bean.Result;
import com.fast.system.convert.SysUserConvert;
import com.fast.system.entity.SysUserEntity;
import com.fast.system.query.SysUserQuery;
import com.fast.system.service.SysUserService;
import com.fast.system.vo.SysUserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理  接口控制器
 *
 * @author jackie
 * @date 2023-02-13
 */
@RestController
@RequestMapping("sys/user" )
@Tag(name = "用户管理" )
@AllArgsConstructor
public class SysUserController {
    private final SysUserService sysUserService;

    @GetMapping("page" )
    @Operation(summary = "分页" )
    @PreAuthorize("hasAuthority('sys:user:page')" )
    public Result<PageResult<SysUserVO>> page(@Valid SysUserQuery query) {
        PageResult<SysUserVO> page = sysUserService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}" )
    @Operation(summary = "信息" )
    @PreAuthorize("hasAuthority('sys:user:info')" )
    public Result<SysUserVO> get(@PathVariable("id" ) Long id) {
        SysUserEntity entity = sysUserService.getById(id);

        return Result.ok(SysUserConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存" )
    @PreAuthorize("hasAuthority('sys:user:save')" )
    public Result<String> save(@RequestBody SysUserVO vo) {
        sysUserService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改" )
    @PreAuthorize("hasAuthority('sys:user:update')" )
    public Result<String> update(@RequestBody @Valid SysUserVO vo) {
        sysUserService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除" )
    @PreAuthorize("hasAuthority('sys:user:delete')" )
    public Result<String> delete(@RequestBody List<Long> idList) {
        sysUserService.delete(idList);

        return Result.ok();
    }
}