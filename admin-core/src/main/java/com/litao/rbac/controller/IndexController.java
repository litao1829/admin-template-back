package com.litao.rbac.controller;

import com.litao.common.utils.Result;
import com.litao.rbac.service.IndexService;
import com.litao.rbac.vo.BarVO;
import com.litao.rbac.vo.LabelVO;
import com.litao.rbac.vo.PanelVO;
import com.litao.rbac.vo.PieChartVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/index")
@Tag(name = "首页统计")
@AllArgsConstructor
public class IndexController {
    private final IndexService indexService;

    @GetMapping("statistics1")
    @Operation(summary = "统计组件1")
    public Result<List<PanelVO>> getstatistics1(){
        List<PanelVO> list=indexService.statistics1();
        return Result.ok(list);
    }

    @GetMapping("statistics2")
    @Operation(summary = "统计组件2")
    public Result<BarVO> getstatistics2(String type){
        BarVO barVO=indexService.statistics2(type);
        return Result.ok(barVO);
    }

    @GetMapping("statistics3")
    @Operation(summary = "统计组件3")
    public Result<Map<String,List<LabelVO>>> getstatistics3(){
        Map<String,List<LabelVO>> map=indexService.statistics3();
        return Result.ok(map);
    }
    @GetMapping("statistics4")
    @Operation(summary = "统计组件4")
    public Result<PieChartVO> getstatistics4(){
        PieChartVO pieChartVO=indexService.statistics4();
        return Result.ok(pieChartVO);
    }
}
