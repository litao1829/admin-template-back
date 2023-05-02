package com.litao.query;

import com.litao.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 通知管理查询参数
 *
 * @author mqxu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "通知管理查询")
public class NoticeQuery extends Query {

    @Schema(description = "通知标题")
    private String title;

    @Schema(description = "通知内容")
    private String content;

}