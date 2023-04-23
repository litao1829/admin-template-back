package com.litao.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志vo
 * @author
 **/
@Data
@Schema(description = "登录日志")
public class SysLogLoginVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2985371222936396135L;

    @Schema(description = "id")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "登录IP")
    private String ip;

    @Schema(description = "登录地点")
    private String address;

    @Schema(description = "登录设备UA")
    private String userAgent;

    @Schema(description = "登录状态  0：失败   1：成功")
    private Integer status;

    @Schema(description = "操作信息   0：登录成功   1：退出成功  2：验证码错误  3：账号密码错误")
    private Integer operation;

    @Schema(description = "创建时间")
    private Date createTime;

}