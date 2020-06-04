package com.eighty.gowhere.airbus.controller;

import java.util.Arrays;
import java.util.Map;


import com.eighty.gowhere.airbus.utils.PageUtils;
import com.eighty.gowhere.airbus.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.airbus.entity.AirlinePmsOrderInfoEntity;
import com.eighty.gowhere.airbus.service.AirlinePmsOrderInfoService;




/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:54:24
 */
@RestController
@RequestMapping("airbus/airline/pms/order/info")
public class AirlinePmsOrderInfoController {
    @Autowired
    private AirlinePmsOrderInfoService airlinePmsOrderInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("airbus:airlinepmsorderinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = airlinePmsOrderInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    //@RequiresPermissions("airbus:airlinepmsorderinfo:info")
    public R info(@PathVariable("id") Integer id){
		AirlinePmsOrderInfoEntity airlinePmsOrderInfo = airlinePmsOrderInfoService.getById(id);

        return R.ok().put("airlinePmsOrderInfo", airlinePmsOrderInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("airbus:airlinepmsorderinfo:save")
    public R save(@RequestBody AirlinePmsOrderInfoEntity airlinePmsOrderInfo){
		airlinePmsOrderInfoService.save(airlinePmsOrderInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("airbus:airlinepmsorderinfo:update")
    public R update(@RequestBody AirlinePmsOrderInfoEntity airlinePmsOrderInfo){
		airlinePmsOrderInfoService.updateById(airlinePmsOrderInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("airbus:airlinepmsorderinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		airlinePmsOrderInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
