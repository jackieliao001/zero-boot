# zero-boot

#### 介绍
采用SpringBoot3.0.2、MapSturct、Mybatis-Plus等框架，开发的一套单体快速开发系统，采用MIT开源协议，完全免费开源。

#### 软件架构

```
zero-boot
├─db        数据库SQL
│  └─mysql  MySQL
│ 
├─zero-boot-api           API模块（用于各模块解耦）
│ 
├─zero-boot-module
│    ├─zero-module-generator    代码生成
│    ├─zero-module-monitor      系统监控
│    ├─zero-module-quartz       定时任务
│    └─zero-module-message      短信模块
│ 
├─zero-boot-system        系统模块（用户、角色、部门、菜单等系统功能）
│  
├─zero-framework          框架模块
│ 
├─zero-server             服务模块（负责项目的配置、启动）
│ 
├─build.gradle            gradle依赖管理
│ 
├─settings.gradle         gradle模块管理
```



#### 开发进度

1. [x] 框架模块
2. [ ] 服务模块
3. [ ] 系统模块
4. [ ] 前端页面
5. [ ] 代码生成
6. [ ] 系统监控
7. [ ] 定时任务
...

#### 鸣谢

1.  maku[maku-boot](https://gitee.com/makunet/maku-boot)



#### 特技

[![Fork me on Gitee](https://gitee.com/jackie_liao/zero-boot/widgets/widget_5.svg)](https://gitee.com/jackie_liao/zero-boot)
