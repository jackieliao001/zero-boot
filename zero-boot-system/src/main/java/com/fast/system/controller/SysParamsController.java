package com.fast.system.controller;

import com.fast.system.convert.SysParamsConvert;
import com.fast.system.entity.SysParamsEntity;
import com.fast.system.query.SysParamsQuery;
import com.fast.system.service.SysParamsService;
import com.fast.system.vo.SysParamsVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.fast.framework.common.bean.PageResult;
import com.fast.framework.common.bean.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 参数管理  接口控制器
 *
 * @author jackie
 * @date 2023-02-13
 */
@RestController
@RequestMapping("sys/params")
@Tag(name="参数管理")
@AllArgsConstructor
public class SysParamsController {
    private final SysParamsService sysParamsService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:params:page')")
    public Result<PageResult<SysParamsVO>> page(@Valid SysParamsQuery query){
        PageResult<SysParamsVO> page = sysParamsService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sys:params:info')")
    public Result<SysParamsVO> get(@PathVariable("id") Long id){
        SysParamsEntity entity = sysParamsService.getById(id);

        return Result.ok(SysParamsConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('sys:params:save')")
    public Result<String> save(@RequestBody SysParamsVO vo){
        sysParamsService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('sys:params:update')")
    public Result<String> update(@RequestBody @Valid SysParamsVO vo){
        sysParamsService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('sys:params:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysParamsService.delete(idList);

        return Result.ok();
    }
}