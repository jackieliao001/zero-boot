# zero-web

### 介绍

是基于Vue3、TypeScript、Element Plus、Vue Router、Pinia、Axios、i18n、Vite等开发的后台管理，使用门槛极低，采用MIT开源协议，完全免费开源且终身免费，可免费用于商业项目等场景！`<br />`

### 软件架构

```
├─public   静态文件
│
├─src      源文件
│    ├─api         接口模块
│    ├─assets      资源文件
│    ├─components  常用组件
│    ├─hooks       业务封装
│    ├─i18n        国际化
│    ├─icons       svg图标
│    ├─layout      框架布局
│    ├─router      路由文件
│    ├─store       状态管理
│    ├─stypes      SCSS样式
│    ├─types       d.ts声明
│    ├─utils       常用工具
│    ├─views       业务视图
│    ├─App.vue     入口页面
│    ├─main.ts     入口文件，组件加载、初始化等
│
├─.env.development      开发环境配置
├─.env.production       生产环境配置
├─.eslintignore         eslint忽略的文件
├─.eslintrc.js          eslint规则配置
├─.prettierrc.js        prettier规则配置
├─components.d.ts       动态生成的
├─index.html            首页文件
├─package.json          依赖管理
├─tsconfig.json         TypeScript配置
├─vite.config.ts        Vite配置

```

### 快速入门

#### 软件安装

> 注意：需使用 Node.js 长期维护版本，如：[16.x、18.x]，能保证项目的稳定运行，且 Node.js 推荐使用 nvm 进行安装，方便以后切换不同的版本。

1. 安装nvm
   nvm是一个nodejs版本管理工具，需要先把本地安装的Node.js卸载，然后再下载nvm,地址：[https://github.com/coreybutler/nvm-windows/releases](nvm github)
2. 安装nodejs
   安装好了nvm后，再通过nvm安装Node.js

   ```bash
   # 查看Node.js可用的版本列表
   nvm ls available

   # 安装版本号为16.15.0的Node.js
   nvm install 16.15.0

   # 查看已安装的版本号
   nvm list

   # 切换版本号到16.15.0
   nvm use 16.15.0

   # 查看当前Node.js的版本号
   node -v

   # 卸载版本号为16.15.0的Node.js
   nvm uninstall 16.15.0
   ```
3. 配置镜像源
   配置淘宝镜像源，执行如下命令：`npm config set registry https://registry.npmmirror.com/`

   查看镜像源是否配置成功：`npm config get registry`
4. 启动项目

   ```
   # git克隆项目并进入项目文件
   cd zero-web
   # 安装依赖
   npm install
   # 运行项目
   npm run dev
   ```

   环境配置，一般是配置项目的后端接口地址。本项目提供了.env.development和.env.production两个配置文件，分别用于配置开发环境和生产环境的接口地址。
