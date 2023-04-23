package com.litao.rbac.service;

import com.litao.rbac.vo.SysAccountLoginVO;
import com.litao.rbac.vo.SysTokenVO;

/**
 * 权限认证服务
 *
 * @author
 */

public interface SysAuthService {

    /**
     * 账号密码登录
     *
     * @param login 登录信息
     */
    SysTokenVO loginByAccount(SysAccountLoginVO login);

    /**
     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);
}
