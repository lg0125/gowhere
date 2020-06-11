package com.eighty.gowhere.amazon.controller;

import java.util.Arrays;
import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eighty.gowhere.amazon.utils.PageUtils;
import com.eighty.gowhere.amazon.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.amazon.entity.WebOmsOrderEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderService;




/**
 * order
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:58:18
 */
@RestController
@RequestMapping("amazon/web/oms/order")
public class WebOmsOrderController {

    @Autowired
    private WebOmsOrderService webOmsOrderService;

    @GetMapping("/{orderId}")
    public WebOmsOrderEntity getOrderByOrderId(@PathVariable Long orderId){

        return webOmsOrderService.getOne(
                new QueryWrapper<WebOmsOrderEntity>().eq("order_id", orderId));
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = webOmsOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		WebOmsOrderEntity webOmsOrder = webOmsOrderService.getById(id);

        return R.ok().put("webOmsOrder", webOmsOrder);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody WebOmsOrderEntity webOmsOrder){
		webOmsOrderService.save(webOmsOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody WebOmsOrderEntity webOmsOrder){
		webOmsOrderService.updateById(webOmsOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		webOmsOrderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
