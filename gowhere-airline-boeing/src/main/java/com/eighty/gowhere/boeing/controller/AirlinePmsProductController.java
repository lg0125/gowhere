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

import com.eighty.gowhere.boeing.entity.AirlinePmsProductEntity;
import com.eighty.gowhere.boeing.service.AirlinePmsProductService;



/**
 * product
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:48:45
 */
@RestController
@RequestMapping("boeing/airlinepmsproduct")
public class AirlinePmsProductController {
    @Autowired
    private AirlinePmsProductService airlinePmsProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("boeing:airlinepmsproduct:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = airlinePmsProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("boeing:airlinepmsproduct:info")
    public R info(@PathVariable("id") Long id){
		AirlinePmsProductEntity airlinePmsProduct = airlinePmsProductService.getById(id);

        return R.ok().put("airlinePmsProduct", airlinePmsProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("boeing:airlinepmsproduct:save")
    public R save(@RequestBody AirlinePmsProductEntity airlinePmsProduct){
		airlinePmsProductService.save(airlinePmsProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("boeing:airlinepmsproduct:update")
    public R update(@RequestBody AirlinePmsProductEntity airlinePmsProduct){
		airlinePmsProductService.updateById(airlinePmsProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("boeing:airlinepmsproduct:delete")
    public R delete(@RequestBody Long[] ids){
		airlinePmsProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
