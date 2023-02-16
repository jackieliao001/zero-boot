package com.fast.system.controller;

import com.fast.system.convert.SysAttachmentConvert;
import com.fast.system.entity.SysAttachmentEntity;
import com.fast.system.query.SysAttachmentQuery;
import com.fast.system.service.SysAttachmentService;
import com.fast.system.vo.SysAttachmentVO;
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
 * 附件管理  接口控制器
 *
 * @author jackie
 * @date 2023-02-13
 */
@RestController
@RequestMapping("sys/attachment")
@Tag(name="附件管理")
@AllArgsConstructor
public class SysAttachmentController {
    private final SysAttachmentService sysAttachmentService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:attachment:page')")
    public Result<PageResult<SysAttachmentVO>> page(@Valid SysAttachmentQuery query){
        PageResult<SysAttachmentVO> page = sysAttachmentService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sys:attachment:info')")
    public Result<SysAttachmentVO> get(@PathVariable("id") Long id){
        SysAttachmentEntity entity = sysAttachmentService.getById(id);

        return Result.ok(SysAttachmentConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('sys:attachment:save')")
    public Result<String> save(@RequestBody SysAttachmentVO vo){
        sysAttachmentService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('sys:attachment:update')")
    public Result<String> update(@RequestBody @Valid SysAttachmentVO vo){
        sysAttachmentService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('sys:attachment:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        sysAttachmentService.delete(idList);

        return Result.ok();
    }
}