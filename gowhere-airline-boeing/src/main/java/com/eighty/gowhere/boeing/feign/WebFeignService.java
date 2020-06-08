package com.eighty.gowhere.boeing.feign;

import com.eighty.gowhere.boeing.vo.WebOmsOrderItemVo;
import com.eighty.gowhere.boeing.vo.WebOmsOrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
@FeignClient("gowhere-web-amazon")
public interface WebFeignService {

    @GetMapping("/{orderId}")
    WebOmsOrderVo getOrderByOrderId(@PathVariable Long orderId);

    @GetMapping("/{orderId}")
    WebOmsOrderItemVo getOrderItemByOrderId(@PathVariable Long orderId);

}

