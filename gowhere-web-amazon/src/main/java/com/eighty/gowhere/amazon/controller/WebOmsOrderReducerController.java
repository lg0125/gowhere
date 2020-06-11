package com.eighty.gowhere.amazon.controller;

import com.eighty.gowhere.amazon.dto.AirlineOrderDto;
import com.eighty.gowhere.amazon.dto.PayCardLogDto;
import com.eighty.gowhere.amazon.dto.SaveDto;
import com.eighty.gowhere.amazon.entity.WebOmsOrderEntity;
import com.eighty.gowhere.amazon.entity.WebOmsOrderOpLogEntity;
import com.eighty.gowhere.amazon.entity.WebOmsOrderPayinfoEntity;
import com.eighty.gowhere.amazon.feign.AirbusFeignService;
import com.eighty.gowhere.amazon.feign.AlibabaFeignService;
import com.eighty.gowhere.amazon.feign.BoeingFeignService;
import com.eighty.gowhere.amazon.feign.TencentFeignService;
import com.eighty.gowhere.amazon.service.WebOmsOrderOpLogService;
import com.eighty.gowhere.amazon.service.WebOmsOrderPayinfoService;
import com.eighty.gowhere.amazon.service.WebOmsOrderService;
import com.eighty.gowhere.amazon.utils.MyObjConvert;
import com.eighty.gowhere.amazon.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@CrossOrigin
@RequestMapping("web/oms/order/reducer")
public class WebOmsOrderReducerController {

    @Autowired
    WebOmsOrderService webOmsOrderService;
    @Autowired
    WebOmsOrderOpLogService webOmsOrderOpLogService;
    @Autowired
    WebOmsOrderPayinfoService webOmsOrderPayinfoService;

    @Autowired
    AirbusFeignService airbusFeignService;
    @Autowired
    BoeingFeignService boeingFeignService;
    @Autowired
    AlibabaFeignService alibabaFeignService;
    @Autowired
    TencentFeignService tencentFeignService;

    @Autowired
    ThreadPoolExecutor executor;


    //TODO
    @PostMapping("/save")
    @Cacheable(value = {"amazon"},key = "#root.method.name")
    public R save(@RequestBody SaveDto saveDto){
        WebOmsOrderEntity webOmsOrderEntity = MyObjConvert.dto2Order(saveDto);

        WebOmsOrderOpLogEntity webOmsOrderOpLogEntity = MyObjConvert.order2OpLog(webOmsOrderEntity);
        WebOmsOrderPayinfoEntity webOmsOrderPayinfoEntity = MyObjConvert.order2PayInfo(webOmsOrderEntity);

        webOmsOrderService.save(webOmsOrderEntity);
        webOmsOrderOpLogService.save(webOmsOrderOpLogEntity);
        webOmsOrderPayinfoService.save(webOmsOrderPayinfoEntity);

        AirlineOrderDto airlineOrderDto = MyObjConvert.order2AirlineOrderDto(webOmsOrderEntity);
        if(webOmsOrderEntity.getAirlineName().equals("airbus")){
            airbusFeignService.save(airlineOrderDto);
        }else{
            boeingFeignService.save(airlineOrderDto);
        }

        PayCardLogDto payCardLogDto = MyObjConvert.order2CardLogDto(webOmsOrderEntity);
        if(webOmsOrderEntity.getPayName().equals("alibaba")){
            alibabaFeignService.save(payCardLogDto);
        }else {
            tencentFeignService.save(payCardLogDto);
        }


       /* WebOmsOrderEntity webOmsOrderEntity = MyObjConvert.dto2Order(saveDto);
        CompletableFuture<Void> orderCompletableFuture = CompletableFuture.runAsync(() -> {
            webOmsOrderService.save(webOmsOrderEntity);
        }, executor);

        CompletableFuture<Void> payInfoCompletableFuture = CompletableFuture.runAsync(() -> {
            WebOmsOrderPayinfoEntity webOmsOrderPayinfoEntity =
                    MyObjConvert.order2PayInfo(webOmsOrderEntity);
            webOmsOrderPayinfoService.save(webOmsOrderPayinfoEntity);
        }, executor);

        CompletableFuture<Void> opLogCompletableFuture = CompletableFuture.runAsync(() -> {
            WebOmsOrderOpLogEntity webOmsOrderOpLogEntity =
                    MyObjConvert.order2OpLog(webOmsOrderEntity);
            webOmsOrderOpLogService.save(webOmsOrderOpLogEntity);
        }, executor);



        AirlineOrderDto airlineOrderDto = MyObjConvert.order2AirlineOrderDto(webOmsOrderEntity);
        PayCardLogDto payCardLogDto = MyObjConvert.order2CardLogDto(webOmsOrderEntity);

        CompletableFuture<Void> airlineOrderDtoCompletableFuture = new CompletableFuture<>();
        CompletableFuture<Void> payCardLogDtoCompletableFuture = new CompletableFuture<>();

        CompletableFuture<Void> airlineCompletableFuture;
        if(webOmsOrderEntity.getAirlineName().equals("airbus")){
            airlineCompletableFuture = airlineOrderDtoCompletableFuture.thenRunAsync(() -> {
                airbusFeignService.save(airlineOrderDto);
            }, executor);
        }else{
            airlineCompletableFuture = airlineOrderDtoCompletableFuture.thenRunAsync(() -> {
                boeingFeignService.save(airlineOrderDto);
            },executor);
        }

        CompletableFuture<Void> payCompletableFuture;
        if(webOmsOrderEntity.getPayName().equals("alibaba")){
            payCompletableFuture = payCardLogDtoCompletableFuture.thenRunAsync(()->{
                alibabaFeignService.save(payCardLogDto);
            },executor);
        }else{
            payCompletableFuture = payCardLogDtoCompletableFuture.thenRunAsync(() -> {
               tencentFeignService.save(payCardLogDto);
            });
        }

        try {
            CompletableFuture.allOf(
                    orderCompletableFuture,
                    payInfoCompletableFuture,
                    opLogCompletableFuture,
                    airlineCompletableFuture,
                    payCompletableFuture
            ).get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }*/



        return R.ok();
    }
}

