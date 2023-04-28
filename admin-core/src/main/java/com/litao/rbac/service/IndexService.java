package com.litao.rbac.service;

import com.litao.rbac.vo.BarVO;
import com.litao.rbac.vo.LabelVO;
import com.litao.rbac.vo.PanelVO;
import com.litao.rbac.vo.PieChartVO;

import java.util.List;
import java.util.Map;

public interface IndexService {

    /**
     * 后台首页统计1：项目主要数据统计面板
     * @return List<PanelVO>
     *
     */
    List<PanelVO> statistics1();


    /**
     * 后台首页统计2：echarts柱状图
     * @return BarVO
     *
     */
    BarVO statistics2(String type);


    /**
     * 后台首页统计3：分类统计标签
     * @return Map<String,List<LabelVO>>
     *
     */
    Map<String,List<LabelVO>> statistics3();


    /**
     * 后台首页统计4：饼图
     * @return Map<String,List<LabelVO>>
     *
     */
    PieChartVO statistics4();
}
