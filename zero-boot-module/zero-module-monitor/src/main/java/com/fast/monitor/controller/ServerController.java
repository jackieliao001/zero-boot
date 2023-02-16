package com.fast.monitor.controller;

import com.fast.framework.common.bean.Result;
import com.fast.monitor.model.*;
import com.fast.monitor.vo.ServerVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务器监控controller
 *
 * @author liaojunjie
 * @date 2023/2/10 10:37
 */
@RestController
@RequestMapping("monitor/server")
public class ServerController {

    /**
     * 服务器相关信息
     */
    @GetMapping("info")
    @PreAuthorize("hasAuthority('monitor:server:all')")
    public Result<ServerVO> getServerInfo() {
        ServerVO server = new ServerVO();
        return Result.ok(server);
    }

    /**
     * CPU相关信息
     */
    @GetMapping("cpu")
    @PreAuthorize("hasAuthority('monitor:server:all')")
    public Result<Cpu> getCpuInfo() {
        Cpu cpu = new Cpu();
        return Result.ok(cpu);
    }

    /**
     * 内存相关信息
     */
    @GetMapping("mem")
    @PreAuthorize("hasAuthority('monitor:server:all')")
    public Result<Mem> getMemInfo() {
        Mem mem = new Mem();
        return Result.ok(mem);
    }

    /**
     * JVM相关信息
     */
    @GetMapping("jvm")
    @PreAuthorize("hasAuthority('monitor:server:all')")
    public Result<Jvm> getJvmInfo() {
        Jvm jvm = new Jvm();
        return Result.ok(jvm);
    }

    /**
     * 系统相关信息
     */
    @GetMapping("sys")
    @PreAuthorize("hasAuthority('monitor:server:all')")
    public Result<Sys> getSysInfo() {
        Sys sys = new Sys();
        return Result.ok(sys);
    }

    /**
     * 系统文件相关信息
     */
    @GetMapping("disk")
    @PreAuthorize("hasAuthority('monitor:server:all')")
    public Result<List<Disk>> getSysFileInfo() {
        ServerVO server = new ServerVO(new Disk());
        return Result.ok(server.getDisks());
    }
}
