package com.fast.framework.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.fast.framework.security.user.SecurityUser;
import com.fast.framework.security.user.UserDetail;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * 自动填充字段
 * 
 * @author liaojunjie
 * @date 2023/2/9 16:00
 */
public class FieldMetaObjectHandler implements MetaObjectHandler {
    private final static String CREATE_TIME = "createTime";
    private final static String CREATOR = "creator";
    private final static String UPDATE_TIME = "updateTime";
    private final static String UPDATER = "updater";
    private final static String ORG_ID = "orgId";
    private final static String VERSION = "version";
    private final static String DELETED = "deleted";

    @Override
    public void insertFill(MetaObject metaObject) {
        UserDetail user = SecurityUser.getUser();
        LocalDateTime date = LocalDateTime.now();

        // 创建者
        strictInsertFill(metaObject, CREATOR, Long.class, user.getId());
        // 创建时间
        strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, date);
        // 更新者
        strictInsertFill(metaObject, UPDATER, Long.class, user.getId());
        // 更新时间
        strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class, date);
        // 创建者所属机构
        strictInsertFill(metaObject, ORG_ID, Long.class, user.getOrgId());
        // 版本号
        strictInsertFill(metaObject, VERSION, Integer.class, 0);
        // 删除标识
        strictInsertFill(metaObject, DELETED, Integer.class, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新者
        strictUpdateFill(metaObject, UPDATER, Long.class, SecurityUser.getUserId());
        // 更新时间
        strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
    }
}
