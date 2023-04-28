package com.litao.rbac.query;

import com.litao.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户查询参数
 *
 * @author
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "用户分页查询参数")
public class SysUserQuery extends Query {

    @Schema(description = "用户名")
    private String username;


    @Schema(description = "性别")
    private Integer gender;


    @Schema(description = "手机号")
    private String mobile;
}
