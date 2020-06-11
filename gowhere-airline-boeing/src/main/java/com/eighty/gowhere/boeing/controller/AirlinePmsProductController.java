package com.eighty.gowhere.boeing.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eighty.gowhere.boeing.utils.PageUtils;
import com.eighty.gowhere.boeing.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("boeing/airline/pms/product")
@CrossOrigin
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

    //TODO
    @GetMapping("/entity/list")
    public List<AirlinePmsProductEntity> entityList(@RequestParam Map<String, Object> params){
        return airlinePmsProductService.listByMap(params);
    }

    //TODO
    @GetMapping("/entity/info/{productId}")
    public AirlinePmsProductEntity entityInfo(@PathVariable Long productId){
        QueryWrapper<AirlinePmsProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("product_id",productId);

        return airlinePmsProductService.getOne(wrapper);
    }

  /*  @GetMapping("/entity/listPriceAsc")
    public List<AirlinePmsProductEntity> entityListPriceAsc(@RequestParam Map<String, Object> params){
        return airlinePmsProductService.queryPriceAsc(params);
    }

    @GetMapping("/entity/listTimeAsc")
    public List<AirlinePmsProductEntity> entityListTimeAsc(@RequestParam Map<String, Object> params){
        return airlinePmsProductService.queryTimeAsc(params);
    }*/

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
