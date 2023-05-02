package com.litao.rbac.query;

import com.litao.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单查询
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "菜单查询")
public class SysMenuQuery extends Query {
    @Schema(description = "菜单类型")
    private Integer type;

//    @Schema(description = "菜单名称")
//    private String name;

}
