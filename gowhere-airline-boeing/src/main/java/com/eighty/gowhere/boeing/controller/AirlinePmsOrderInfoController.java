package com.eighty.gowhere.boeing.controller;

import java.util.Arrays;
import java.util.Map;


import com.eighty.gowhere.boeing.utils.PageUtils;
import com.eighty.gowhere.boeing.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("boeing/airlinepmsorderinfo")
public class AirlinePmsOrderInfoController {
    @Autowired
    private AirlinePmsOrderInfoService airlinePmsOrderInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("boeing:airlinepmsorderinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = airlinePmsOrderInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("boeing:airlinepmsorderinfo:info")
    public R info(@PathVariable("id") Integer id){
		AirlinePmsOrderInfoEntity airlinePmsOrderInfo = airlinePmsOrderInfoService.getById(id);

        return R.ok().put("airlinePmsOrderInfo", airlinePmsOrderInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("boeing:airlinepmsorderinfo:save")
    public R save(@RequestBody AirlinePmsOrderInfoEntity airlinePmsOrderInfo){
		airlinePmsOrderInfoService.save(airlinePmsOrderInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("boeing:airlinepmsorderinfo:update")
    public R update(@RequestBody AirlinePmsOrderInfoEntity airlinePmsOrderInfo){
		airlinePmsOrderInfoService.updateById(airlinePmsOrderInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("boeing:airlinepmsorderinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		airlinePmsOrderInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
