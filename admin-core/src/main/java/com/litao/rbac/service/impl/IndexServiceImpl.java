package com.litao.rbac.service.impl;

import com.litao.rbac.service.IndexService;
import com.litao.rbac.vo.BarVO;
import com.litao.rbac.vo.LabelVO;
import com.litao.rbac.vo.PanelVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class IndexServiceImpl implements IndexService {
    @Override
    public List<PanelVO> statistics1() {
        PanelVO panel1=PanelVO.builder().title("支付订单").value(499).unit("年").unitColor("success").subTitle("总支付订单").subValue(4999).subUnit("年").build();
        PanelVO panel2=PanelVO.builder().title("订单量").value(567).unit("周").unitColor("danger").subTitle("总订单量").subValue(6666).subUnit("年").build();
        PanelVO panel3=PanelVO.builder().title("销售额（万元）").value(365).unit("年").unitColor("primary").subTitle("总销售额（万元）").subValue(666).subUnit("年").build();
        PanelVO panel4=PanelVO.builder().title("新增用户").value(78).unit("月").unitColor("warning").subTitle("总用户数").subValue(888).subUnit("年").build();

        return List.of(panel1,panel2,panel3,panel4);
    }

    @Override
    public BarVO statistics2(String type) {
        BarVO barVO = null;
        switch (type) {
            case "hour" -> {
                List<String> x = List.of("00", "23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "09", "08", "07", "06", "05", "04", "03", "02", "01");
                List<Integer> y = List.of(0, 0, 0, 0, 0, 4, 6, 3, 0, 6, 3, 0, 0, 11, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                barVO = BarVO.builder().x(x).y(y).build();
            }
            case "week" -> {
                List<String> x = List.of("07-24", "07-23", "07-22", "07-21", "07-20", "07-19", "07-18");
                List<Integer> y = List.of(51, 0, 1, 1, 0, 2, 1);
                barVO = BarVO.builder().x(x).y(y).build();
            }
            case "month" -> {
                List<String> x = List.of("07-24", "07-23", "07-22", "07-21", "07-20", "07-19", "07-18", "07-17", "07-16", "07-15", "07-14", "07-13", "07-12",
                        "07-11", "07-10", "07-09", "07-08", "07-07", "07-06", "07-05", "07-04", "07-03", "07-02", "07-01", "06-30", "06-29", "06-28", "06-27", "06-26");
                List<Integer> y = List.of(51, 51, 10, 11, 31, 20, 22, 41, 20, 34, 32, 12, 10, 7, 8, 5, 17, 9, 20, 30, 41, 10, 20, 14, 16, 18, 28, 20, 30, 29);
                barVO = BarVO.builder().x(x).y(y).build();
            }
        }
        return barVO;
    }

    @Override
    public Map<String, List<LabelVO>> statistics3() {
        List<LabelVO> goods=List.of(new LabelVO("审核中",5),new LabelVO("销售中",17),new LabelVO("已下架",8),new LabelVO("库存预警",5));
        List<LabelVO> orders=List.of(new LabelVO("待付款",24),new LabelVO("待发货",65),new LabelVO("已发货",89),new LabelVO("退款中",5));
        Map<String,List<LabelVO>> map=new HashMap<>();
        map.put("goods",goods);
        map.put("orders",orders);
        return map;
    }
}
