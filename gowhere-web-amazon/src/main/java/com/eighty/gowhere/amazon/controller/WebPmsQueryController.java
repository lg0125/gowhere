package com.eighty.gowhere.amazon.controller;

import com.eighty.gowhere.amazon.dto.AirlineOrderDto;
import com.eighty.gowhere.amazon.entity.WebOmsOrderEntity;
import com.eighty.gowhere.amazon.feign.AirbusFeignService;
import com.eighty.gowhere.amazon.feign.BoeingFeignService;
import com.eighty.gowhere.amazon.service.WebOmsOrderService;
import com.eighty.gowhere.amazon.utils.R;
import com.eighty.gowhere.amazon.vo.AirlineProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("amazon/web/pms/query")
@CrossOrigin
public class WebPmsQueryController {

    @Autowired
    WebOmsOrderService webOmsOrderService;

    @Autowired
    AirbusFeignService airbusFeignService;

    @Autowired
    BoeingFeignService boeingFeignService;

    @Autowired
    ThreadPoolExecutor executor;


    //TODO
    @GetMapping("/list")
    @Cacheable(value = {"amazon"},key = "#root.method.name")
    public R list(@RequestParam Map<String, Object> params){
       /* List<AirlineProductVo> listAirbus = airbusFeignService.entityList(params);
        List<AirlineProductVo> listBoeing = boeingFeignService.entityList(params);
        List<AirlineProductVo> list = new ArrayList<>(listAirbus);
        list.addAll(listBoeing);
        return R.ok().put("list",list);*/

        CompletableFuture<List<AirlineProductVo>> airbusCompletableFuture = CompletableFuture.supplyAsync(() -> airbusFeignService.entityList(params),executor);

        CompletableFuture<List<AirlineProductVo>> boeingCompletableFuture = CompletableFuture.supplyAsync(() -> boeingFeignService.entityList(params),executor);

        CompletableFuture<List<AirlineProductVo>> listCompletableFuture = airbusCompletableFuture.thenCombineAsync(boeingCompletableFuture, (A, B) -> {
            A.addAll(B);
            return A;
        }, executor);


        List<AirlineProductVo> list = null;

        try {
            list = listCompletableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }

        return R.ok().put("list",list);
    }

    //TODO
    @GetMapping("/listPriceAsc")
    @Cacheable(value = {"amazon"},key = "#root.method.name")
    public R listPriceAsc(@RequestParam Map<String, Object> params){
       /* List<AirlineProductVo> listAirbus = airbusFeignService.entityList(params);
        List<AirlineProductVo> listBoeing = boeingFeignService.entityList(params);
        listAirbus.addAll(listBoeing);
        List<AirlineProductVo> list = listAirbus.stream()
                .sorted(Comparator.comparing(AirlineProductVo::getPrice))
                .collect(Collectors.toList());
        return R.ok().put("list",list);*/

        CompletableFuture<List<AirlineProductVo>> airbusCompletableFuture = CompletableFuture.supplyAsync(() -> airbusFeignService.entityList(params),executor);
        CompletableFuture<List<AirlineProductVo>> boeingCompletableFuture = CompletableFuture.supplyAsync(() -> boeingFeignService.entityList(params),executor);
        CompletableFuture<List<AirlineProductVo>> listCompletableFuture = airbusCompletableFuture.
                thenCombineAsync(boeingCompletableFuture, (A,B) -> A.stream().sorted(Comparator.comparing(AirlineProductVo::getPrice)).collect(Collectors.toList()),
                        executor);

        List<AirlineProductVo> list = null;

        try {
            list = listCompletableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }

        return R.ok().put("list",list);
    }

    //TODO
    @GetMapping("/listTimeAsc")
    @Cacheable(value = {"amazon"},key = "#root.method.name")
    public R listTimeAsc(@RequestParam Map<String, Object> params){
       /* List<AirlineProductVo> listAirbus = airbusFeignService.entityList(params);
        List<AirlineProductVo> listBoeing = boeingFeignService.entityList(params);
        listAirbus.addAll(listBoeing);
        List<AirlineProductVo> list = listAirbus.stream()
                .sorted(Comparator.comparing(AirlineProductVo::getFromTime))
                .collect(Collectors.toList());
        return R.ok().put("list",list);*/

        CompletableFuture<List<AirlineProductVo>> airbusCompletableFuture = CompletableFuture.supplyAsync(() -> airbusFeignService.entityList(params),executor);
        CompletableFuture<List<AirlineProductVo>> boeingCompletableFuture = CompletableFuture.supplyAsync(() -> boeingFeignService.entityList(params),executor);
        CompletableFuture<List<AirlineProductVo>> listCompletableFuture = airbusCompletableFuture.
                thenCombineAsync(boeingCompletableFuture, (A,B) -> A.stream().sorted(Comparator.comparing(AirlineProductVo::getFromTime)).collect(Collectors.toList()),
                        executor);

        List<AirlineProductVo> list = null;

        try {
            list = listCompletableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }

        return R.ok().put("list",list);
    }

    //TODO
    @GetMapping("/boeing/product/{productId}")
    @Cacheable(value = {"amazon"},key = "#root.method.name")
    public R getBoeingProductByProductId(@PathVariable Long productId){
        AirlineProductVo result = boeingFeignService.entityInfo(productId);
        return R.ok().put("entity",result);
    }

    //TODO
    @GetMapping("/airbus/product/{productId}")
    @Cacheable(value = {"amazon"},key = "#root.method.name")
    public R getAirbusProductByProductId(@PathVariable Long productId){
        AirlineProductVo result = airbusFeignService.entityInfo(productId);
        return R.ok().put("entity",result);
    }

    //TODO
    @GetMapping("/listNotPay")
    @Cacheable(value = {"amazon"},key = "#root.method.name")
    public R listNotPay(@RequestParam Map<String,Object> params){
        List<WebOmsOrderEntity> list = webOmsOrderService.listByMap(params);
        return R.ok().put("list",list);
    }

    //TODO
    @GetMapping("/listDraw")
    @Cacheable(value = {"amazon"},key = "#root.method.name")
    public R listDraw(@RequestParam Map<String,Object> params){
        List<WebOmsOrderEntity> list = webOmsOrderService.listByMap(params);
        return R.ok().put("list",list);
    }



}
