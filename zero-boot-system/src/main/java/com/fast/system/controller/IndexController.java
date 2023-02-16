package com.fast.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 欢迎信息
 *
 * @author liaojunjie
 * @date 2023/2/13 13:57
 */
@RestController
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "您好，项目已启动，祝您使用愉快！";
    }
}
