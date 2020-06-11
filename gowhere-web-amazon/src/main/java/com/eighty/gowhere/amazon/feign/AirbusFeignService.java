package com.eighty.gowhere.amazon.feign;

import com.eighty.gowhere.amazon.dto.AirlineOrderDto;
import com.eighty.gowhere.amazon.utils.R;
import com.eighty.gowhere.amazon.vo.AirlineProductVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient("gowhere-airline-airbus")
public interface AirbusFeignService {

    @GetMapping("/airbus/airline/pms/product/entity/list")
    List<AirlineProductVo> entityList(@RequestParam Map<String, Object> params);


    @GetMapping("/airbus/airline/pms/product/entity/info/{productId}")
    AirlineProductVo entityInfo(@PathVariable Long productId);

    @PostMapping("/airbus/airline/pms/order/save")
    R save(@RequestBody AirlineOrderDto airlinePmsOrderInfo);


}
