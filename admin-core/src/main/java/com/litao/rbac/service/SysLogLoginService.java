package com.litao.rbac.service;


import com.litao.common.utils.PageResult;
import com.litao.mybatis.service.BaseService;
import com.litao.rbac.entity.SysLogLoginEntity;
import com.litao.rbac.query.SysLogLoginQuery;
import com.litao.rbac.vo.SysLogLoginVO;

/**
 * 登录日志业务接口
 *
 * @author
 **/
public interface SysLogLoginService extends BaseService<SysLogLoginEntity> {
    /**
     * 按条件分页查询
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<SysLogLoginVO> page(SysLogLoginQuery query);

    /**
     * 保存登录日志
     *
     * @param username  用户名
     * @param status    登录状态
     * @param operation 操作信息
     */
    void save(String username, Integer status, Integer operation);
}