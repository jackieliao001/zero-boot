package com.fast.generator;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import jakarta.validation.constraints.NotNull;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 自定义模板引擎
 * 继承官方，覆写自定义输出的文件名
 *
 * @author liaojunjie
 * @date 2023/2/13 11:27
 */
public class MyVelocityTemplateEngine extends VelocityTemplateEngine {
    /**
     * 视图对象模板文件名
     */
    public static final String VUE_SUFFIX = ".vue";

    /**
     * 输出自定义模板文件
     *
     * @param customFiles 自定义模板文件列表
     * @param tableInfo   表信息
     * @param objectMap   渲染数据
     * @since 3.5.3
     */
    @Override
    protected void outputCustomFile(@NotNull List<CustomFile> customFiles, @NotNull TableInfo tableInfo, @NotNull Map<String, Object> objectMap) {
        String entity = StrUtil.toCamelCase(tableInfo.getName());
        String entityName = StrUtil.upperFirst(entity);
        String parentPath = getPathInfo(OutputFile.parent);
        customFiles.forEach(file -> {
            String filePath = StrUtil.isNotBlank(file.getFilePath()) ? file.getFilePath() : parentPath;
            if (StrUtil.isNotBlank(file.getPackageName())) {
                filePath = filePath + File.separator + file.getPackageName();
                filePath = filePath.replaceAll("\\.", StringPool.BACK_SLASH + File.separator);
            }
            //只有为视图对象时，才附加实体名，对于其他模板，如前端页面，如list.vue/edit.vue,不附加实体名
            String prefix = "";
            if (file.getFileName().endsWith(ConstVal.JAVA_SUFFIX)) {
                prefix = entityName;
            }
            objectMap.put("ClassName", entityName);
            objectMap.put("className", entity);
            objectMap.put("entityName", entityName);
            String fileName = filePath + File.separator + prefix + file.getFileName();
            outputFile(new File(fileName), objectMap, file.getTemplatePath(), file.isFileOverride());
        });
    }
}
