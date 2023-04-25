package com.litao.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Schema(description = "柱状图")
public class BarVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "x轴数据",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> x;

    @Schema(description = "y轴数据",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Integer> y;
}
