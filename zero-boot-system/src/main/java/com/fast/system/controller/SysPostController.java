package com.fast.system.controller;

import com.fast.framework.common.bean.PageResult;
import com.fast.framework.common.bean.Result;
import com.fast.system.convert.SysPostConvert;
import com.fast.system.entity.SysPostEntity;
import com.fast.system.query.SysPostQuery;
import com.fast.system.service.SysPostService;
import com.fast.system.vo.SysPostVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 岗位管理  接口控制器
 *
 * @author jackie
 * @date 2023-02-13
 */
@RestController
@RequestMapping("sys/post" )
@Tag(name = "岗位管理" )
@AllArgsConstructor
public class SysPostController {
    private final SysPostService sysPostService;

    @GetMapping("page" )
    @Operation(summary = "分页" )
    @PreAuthorize("hasAuthority('sys:post:page')" )
    public Result<PageResult<SysPostVO>> page(@Valid SysPostQuery query) {
        PageResult<SysPostVO> page = sysPostService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}" )
    @Operation(summary = "信息" )
    @PreAuthorize("hasAuthority('sys:post:info')" )
    public Result<SysPostVO> get(@PathVariable("id" ) Long id) {
        SysPostEntity entity = sysPostService.getById(id);

        return Result.ok(SysPostConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存" )
    @PreAuthorize("hasAuthority('sys:post:save')" )
    public Result<String> save(@RequestBody SysPostVO vo) {
        sysPostService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改" )
    @PreAuthorize("hasAuthority('sys:post:update')" )
    public Result<String> update(@RequestBody @Valid SysPostVO vo) {
        sysPostService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除" )
    @PreAuthorize("hasAuthority('sys:post:delete')" )
    public Result<String> delete(@RequestBody List<Long> idList) {
        sysPostService.delete(idList);

        return Result.ok();
    }
}