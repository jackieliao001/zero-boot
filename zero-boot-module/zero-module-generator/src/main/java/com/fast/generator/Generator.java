package com.fast.generator;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.fast.framework.mybatis.dao.BaseDao;
import com.fast.framework.mybatis.entity.BaseEntity;
import com.fast.framework.mybatis.service.BaseService;
import com.fast.framework.mybatis.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 代码生成
 * 基于mybatis-plus 3.5.3.1
 *
 * @author liaojunjie
 * @date 2023/2/9 11:28
 */
@Slf4j
public class Generator {
    /**
     * 指定输出根路径
     */
    private static final String ROOT_PATH = "D://zero-boot/";
    /**
     * 项目名
     */
    private static final String PROJECT_NAME = "zero-boot";
    /**
     * 父包名
     */
    private static final String PARENT_PACKAGE = "com.fast";

    /**
     * 数据库
     */
    private static final String DB = "zero_boot";

    public static void main(String[] args) {
//        String a = "SysOrgService";
//        System.out.println(a.substring(0, 1).toLowerCase(Locale.ROOT));
//        System.out.println(a.replace() .substring(1,a.length()-7));
        generateCode("system","sys","params","sys_params");
//        generateCode("sys","sys_org","sys_post","sys_role","sys_user","sys_params","sys_menu");
    }


    /**
     * 批量生成代码
     * @param moduleTableMap  map<模块信息，相关表[]>。模块信息逗号隔开:(模块名,别名,功能名),eg:system,sys,org
     */
    public static void generateCodeBatch(Map<String,String[]> moduleTableMap){
        for (Map.Entry<String, String[]> entry : moduleTableMap.entrySet()) {
            String model = entry.getKey();
            String[] tables = entry.getValue();
            String[] models = StrUtil.splitToArray(model, CharUtil.COMMA);
            generateCode(models[0],models[1],models[2],tables);
        }
    }

    /**
     * 生成代码
     * @param module 模块名
     * @param moduleAlias 模块别名
     * @param tables 表名
     */
    public static void generateCode(String module,String moduleAlias,String functionName,String... tables){
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    builder.author("jackie") // 设置作者
                            .disableOpenDir()
                            .dateType(DateType.TIME_PACK) // 使用java8新的时间类型
                            .commentDate("yyyy-MM-dd")
                            .outputDir(ROOT_PATH); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT_PACKAGE) // 设置父包名
                            .moduleName(module)
                            .controller("controller")
                            .service("service")
                            .serviceImpl("service.impl")
                            .entity("entity")
                            .mapper("dao")
                            .xml("mapper")
                            .pathInfo(getInfo(module, moduleAlias)); // 设置生成路径
                })
                .strategyConfig(builder -> builder.addInclude(tables)
                        //开始定制实体类
                        .entityBuilder().superClass(BaseEntity.class).enableLombok().enableFileOverride()
                        .formatFileName("%sEntity").disableSerialVersionUID()
                        .addSuperEntityColumns("id","create_time", "update_time","creator", "updater","version", "deleted")
                        .logicDeleteColumnName("deleted")   // 逻辑删除字段
                        .addTableFills(makeInitTableFills())  // 自动填充字段

                        //开始定制控制器
                        .controllerBuilder().enableRestStyle().enableFileOverride()
                        //开始定制Service
                        .serviceBuilder().enableFileOverride().superServiceClass(BaseService.class).formatServiceFileName("%sService")
                        .superServiceImplClass(BaseServiceImpl.class).formatServiceImplFileName("%sServiceImpl")
                        //开始定制映射器
                        .mapperBuilder().superClass(BaseDao.class).enableFileOverride()
                        .mapperAnnotation(Mapper.class).enableBaseResultMap().enableBaseColumnList()
                        .formatMapperFileName("%sDao").formatXmlFileName("%sDao")
                )
                .templateConfig(template())
                .injectionConfig(builder -> builder.beforeOutputFile((tab, map) -> tab.getImportPackages().removeIf("java.io.Serializable"::equals))
                        .customFile(customFile(module, moduleAlias))
                        .customMap(customMap(module,moduleAlias,functionName))
                )
                .templateEngine(new MyVelocityTemplateEngine())
                .execute();
        String path = StringUtils.replace(ROOT_PATH, "//", "/") + moduleAlias + "-service";
        log.info("文件生成成功:");
        System.out.println("文件生成成功:" + StringUtils.replace(path, "/", "\\"));
    }



    /**
     * 类生成策略
     *      配置字段默认填充装置
     *
     * @return
     */
    private static List<IFill> makeInitTableFills(){
        List<IFill> tableFillList = new ArrayList<>();
        /**定义创建时间 插入时默认填充**/
        Column createTableFill = new Column("create_time", FieldFill.INSERT);
        /** 定义修改时间 插入或修改时默认填充**/
        Column updateTableFill = new Column("update_time", FieldFill.INSERT_UPDATE);
        tableFillList.add(createTableFill);
        tableFillList.add(updateTableFill);

        return tableFillList;
    }


    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://127.0.0.1:3306/" + DB + "?serverTimezone=Asia/Shanghai&useSSL=false&useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true", "root", "root")
            .dbQuery(new MySqlQuery())
            .typeConvert(new EasyMySqlTypeConvert());

    private static Map<OutputFile, String> getInfo(String module, String moduleAlias) {
        Map<OutputFile, String> pathInfo = new HashMap<>(8);
        pathInfo.put(OutputFile.xml, ROOT_PATH + moduleAlias + "-service/src/main/resources/mapper/"+module+"/");
        pathInfo.put(OutputFile.mapper, ROOT_PATH + moduleAlias + "-service/src/main/java/com/fast/"+module+"/dao/");
        pathInfo.put(OutputFile.entity, ROOT_PATH + moduleAlias + "-service/src/main/java/com/fast/"+module+"/entity/");
        pathInfo.put(OutputFile.service, ROOT_PATH + moduleAlias + "-service/src/main/java/com/fast/"+module+"/service/");
        pathInfo.put(OutputFile.serviceImpl, ROOT_PATH + moduleAlias + "-service/src/main/java/com/fast/"+module+"/service/impl/");
        pathInfo.put(OutputFile.controller, ROOT_PATH + moduleAlias + "-service/src/main/java/com/fast/"+module+"/controller/");
        // pathInfo.put(OutputFile.other, ROOT_PATH + moduleAlias + "-service/src/main/resources/templates/"+module+"/");
        return pathInfo;
    }

    /**
     * 设置自定义模板路径
     * @return TemplateConfig.Builder
     */
    private static Consumer<TemplateConfig.Builder> template() {
        return builder -> builder.entity("templates/velocity/entity.java.vm")
                .controller("templates/velocity/controller.java.vm")
                .service("templates/velocity/service.java.vm")
                .serviceImpl("templates/velocity/serviceImpl.java.vm")
                .mapper("templates/velocity/dao.java.vm")
                .xml("templates/velocity/mapper.xml.vm");
    }

    /**
     * 自定义文件
     * 文件名->模板名称
     */
    private static List<CustomFile> customFile(String module, String moduleAlias) {
        String filePath = ROOT_PATH + moduleAlias + "-service/src/main/java/com/fast/"+module+"/";
        List<CustomFile> customFileList = new ArrayList<>();
        customFileList.add(new CustomFile.Builder().enableFileOverride().filePath(filePath).packageName("query").fileName("Query.java").templatePath("templates/velocity/query.java.vm").build());
        customFileList.add(new CustomFile.Builder().enableFileOverride().filePath(filePath).packageName("vo").fileName("VO.java").templatePath("templates/velocity/vo.java.vm").build());
        customFileList.add(new CustomFile.Builder().enableFileOverride().filePath(filePath).packageName("convert").fileName("Convert.java").templatePath("templates/velocity/convert.java.vm").build());

/*
        String webFilePath = ROOT_PATH + moduleAlias + "-service/src/main/resources/templates/"+module+"/";
        customFileList.add(new CustomFile.Builder().enableFileOverride().filePath(webFilePath).fileName("index.vue").templatePath("templates/index.vue.vm").build());
        customFileList.add(new CustomFile.Builder().enableFileOverride().filePath(webFilePath).fileName("add.vue").templatePath("templates/add.vue.vm").build());
        customFileList.add(new CustomFile.Builder().enableFileOverride().filePath(webFilePath).fileName("edit.vue").templatePath("templates/edit.vue.vm").build());
        customFileList.add(new CustomFile.Builder().enableFileOverride().filePath(webFilePath).fileName("rule.vue").templatePath("templates/rule.vue.vm").build());
        customFileList.add(new CustomFile.Builder().enableFileOverride().filePath(webFilePath).fileName("api.vue").templatePath("templates/api.vue.vm").build());
*/

        return customFileList;
    }


    /**
     * 自定义模板内参数
     */
    private static Map<String, Object> customMap(String module, String moduleAlias, String functionName) {
        final HashMap<String, Object> map = new HashMap<>(8);
        map.put("projectName", PROJECT_NAME);
        map.put("projectPath", PARENT_PACKAGE);
        map.put("moduleName", module);
        map.put("moduleAlias", moduleAlias);
        map.put("functionName", functionName);
        return map;
    }

    /**
     * 自定义转换器转换器 内部类
     *         eg:将数据库表中定义的 tinyint 或 bit类型转变为 java Integer 类型
     * @author timerbin
     */
    static class EasyMySqlTypeConvert extends MySqlTypeConvert {
        @Override
        public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
            IColumnType iColumnType = super.processTypeConvert(config, fieldType);
            return iColumnType;
        }
    }
}
