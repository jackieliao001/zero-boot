package com.fast.system.service;

import com.fast.framework.common.bean.PageResult;
import com.fast.framework.mybatis.service.BaseService;
import com.fast.system.entity.SysAttachmentEntity;
import com.fast.system.vo.SysAttachmentVO;
import com.fast.system.query.SysAttachmentQuery;

import java.util.List;
/**
 * <p>
 * 附件管理 服务类
 * </p>
 *
 * @author jackie
 * @date 2023-02-13
 */
public interface SysAttachmentService extends BaseService<SysAttachmentEntity> {
    PageResult<SysAttachmentVO> page(SysAttachmentQuery query);

    void save(SysAttachmentVO vo);

    void update(SysAttachmentVO vo);

    void delete(List<Long> idList);
}