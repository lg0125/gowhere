package com.eighty.gowhere.airbus.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eighty.gowhere.airbus.utils.PageUtils;
import com.eighty.gowhere.airbus.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.airbus.entity.AirlinePmsProductEntity;
import com.eighty.gowhere.airbus.service.AirlinePmsProductService;




/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:54:24
 */
@RestController
@RequestMapping("airbus/airline/pms/product")
public class AirlinePmsProductController {
    @Autowired
    private AirlinePmsProductService airlinePmsProductService;


    //TODO
    @GetMapping("/listTimeAsc")
    @Cacheable(value = {"list"},key = "#root.method.name")
    public R listTimeAsc(@RequestParam Map<String, Object> params){
        List<AirlinePmsProductEntity> listTimeAsc =  airlinePmsProductService.queryTimeAsc(params);
        return R.ok().put("list",listTimeAsc);
    }

    //TODO
    @GetMapping("/listPriceAsc")
    @Cacheable(value = {"list"},key = "#root.method.name")
    public R listPriceAsc(@RequestParam Map<String, Object> params){
        List<AirlinePmsProductEntity> listPriceAsc =  airlinePmsProductService.queryPriceAsc(params);

        return R.ok().put("list",listPriceAsc);
    }

    //TODO
    @GetMapping("/list")
    @Cacheable(value = {"list"},key = "#root.method.name")
    public R list(@RequestParam Map<String, Object> params){
        List<AirlinePmsProductEntity> list = airlinePmsProductService.listByMap(params);
        return R.ok().put("list",list);
    }


    @GetMapping("/entity/list")
    @Cacheable(value = {"list"},key = "#root.method.name")
    public List<AirlinePmsProductEntity> entityList(@RequestParam Map<String, Object> params){
        return airlinePmsProductService.listByMap(params);
    }

    @GetMapping("/entity/info/{productId}")
    @Cacheable(value = {"list"},key = "#root.method.name")
    public AirlinePmsProductEntity entityInfo(@PathVariable Long productId){
        QueryWrapper<AirlinePmsProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id",productId);

        return airlinePmsProductService.getOne(wrapper);
    }

    /**
     * 列表
     */
    /*@GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = airlinePmsProductService.queryPage(params);

        return R.ok().put("page", page);
    }*/


    /**
     * 信息
     */
    @GetMapping("/info/{id}")

    public R info(@PathVariable("id") Long id){
		AirlinePmsProductEntity airlinePmsProduct = airlinePmsProductService.getById(id);

        return R.ok().put("airlinePmsProduct", airlinePmsProduct);
    }

    /**
     * 保存
     */
    @PostMapping("/save")

    public R save(@RequestBody AirlinePmsProductEntity airlinePmsProduct){
		airlinePmsProductService.save(airlinePmsProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")

    public R update(@RequestBody AirlinePmsProductEntity airlinePmsProduct){
		airlinePmsProductService.updateById(airlinePmsProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		airlinePmsProductService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
