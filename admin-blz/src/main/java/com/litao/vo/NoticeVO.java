package com.litao.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.litao.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * NoticeVo 类
 *
 * @author
 **/
@Data
@Schema(description = "通知")
public class NoticeVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long id;

    @Schema(description = "通知标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "通知标题不能为空")
    private String title;

    @Schema(description = "通知内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "通知内容不能为空")
    private String content;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createTime;
}

