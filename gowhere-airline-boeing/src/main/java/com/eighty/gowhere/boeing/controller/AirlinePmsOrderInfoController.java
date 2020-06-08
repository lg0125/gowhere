package com.eighty.gowhere.boeing.controller;

import java.util.Arrays;
import java.util.Map;


import com.eighty.gowhere.boeing.utils.PageUtils;
import com.eighty.gowhere.boeing.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.boeing.entity.AirlinePmsOrderInfoEntity;
import com.eighty.gowhere.boeing.service.AirlinePmsOrderInfoService;




/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:48:45
 */
@RestController
@RequestMapping("boeing/airline/pms/order")
public class AirlinePmsOrderInfoController {

    @Autowired
    private AirlinePmsOrderInfoService airlinePmsOrderInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = airlinePmsOrderInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		AirlinePmsOrderInfoEntity airlinePmsOrderInfo = airlinePmsOrderInfoService.getById(id);

        return R.ok().put("airlinePmsOrderInfo", airlinePmsOrderInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody AirlinePmsOrderInfoEntity airlinePmsOrderInfo){
		airlinePmsOrderInfoService.save(airlinePmsOrderInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody AirlinePmsOrderInfoEntity airlinePmsOrderInfo){
		airlinePmsOrderInfoService.updateById(airlinePmsOrderInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		airlinePmsOrderInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
