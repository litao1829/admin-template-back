package com.litao.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

import java.util.List;
import java.util.Map;

@Data
@Builder
@Schema(description = "饼图")
public class PieChartVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "统计标题",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> name;

    @Schema(description = "数据",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Integer> value;
}

