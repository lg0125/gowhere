package com.eighty.gowhere.amazon.feign;

import com.eighty.gowhere.amazon.dto.PayCardLogDto;
import com.eighty.gowhere.amazon.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("gowhere-pay-alibaba")
public interface AlibabaFeignService {

    @PostMapping("/alibaba/cardorderlog/save")
    R save(@RequestBody PayCardLogDto cardOrderLog);

}
