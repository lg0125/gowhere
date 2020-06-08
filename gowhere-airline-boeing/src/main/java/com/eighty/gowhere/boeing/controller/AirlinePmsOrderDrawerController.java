package com.eighty.gowhere.boeing.controller;


import com.eighty.gowhere.boeing.service.AirlinePmsOrderInfoService;

import com.eighty.gowhere.boeing.utils.R;
import com.eighty.gowhere.boeing.vo.OrderDrawVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("boeing/airline/pms/order/drawer")
public class AirlinePmsOrderDrawerController {

    @Autowired
    AirlinePmsOrderInfoService airlinePmsOrderInfoService;

    @GetMapping("/{orderId}")
    public R drawOrder(@PathVariable Long orderId){
        OrderDrawVo orderDrawVo = airlinePmsOrderInfoService.DrawOrder(orderId);

        return R.ok().put("order",orderDrawVo);
    }


}
