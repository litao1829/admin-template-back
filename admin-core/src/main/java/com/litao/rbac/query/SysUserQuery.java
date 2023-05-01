package com.litao.rbac.query;

import com.litao.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.internal.metadata.aggregated.rule.ParallelMethodsMustNotDefineGroupConversionForCascadedReturnValue;

import java.util.Date;

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

    @Schema(description = "姓名")
    private String realName;


    @Schema(description = "创建起始时间")
    private Date beginTime;

    @Schema(description = "创建结束时间")
    private  Date endTime;
}
