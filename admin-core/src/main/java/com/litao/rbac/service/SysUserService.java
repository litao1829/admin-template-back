package com.litao.rbac.service;


import com.litao.common.utils.PageResult;
import com.litao.mybatis.service.BaseService;
import com.litao.rbac.entity.SysUserEntity;
import com.litao.rbac.query.SysUserQuery;
import com.litao.rbac.vo.SysUserVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 系统用户业务接口
 *
 * @author
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);


    /**
     * 分页查询用户
     *
     * @param query  查询参数
     * @return  分页数据
     */
    PageResult<SysUserVO> page(SysUserQuery query);

    /**
     * 新增用户
     *
     * @param vo  入参
     */
    void save(SysUserVO vo);


    /**
     * 修改用户
     *
     * @param vo  入参
     */
    void update(SysUserVO vo);

    /**
     * 批量删除用户用户
     *
     * @param  ids  入参
     */
    void delete(List<Long> ids);

    /**
     * 从表格批量导入用户
     * @param file excel文件
     * @param password 密码
     */
    void importByExcel(MultipartFile file,String password);

    /**
     * 导出用户信息到表格
     *
     *
     */
    void export();
}
