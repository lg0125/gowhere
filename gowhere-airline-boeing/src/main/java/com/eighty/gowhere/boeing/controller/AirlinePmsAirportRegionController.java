package com.eighty.gowhere.boeing.controller;

import java.util.Arrays;
import java.util.Map;


import com.eighty.gowhere.boeing.utils.PageUtils;
import com.eighty.gowhere.boeing.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.boeing.entity.AirlinePmsAirportRegionEntity;
import com.eighty.gowhere.boeing.service.AirlinePmsAirportRegionService;




/**
 * airport_region
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:48:45
 */
@RestController
@RequestMapping("boeing/airline/pms/airport/region")
public class AirlinePmsAirportRegionController {
    @Autowired
    private AirlinePmsAirportRegionService airlinePmsAirportRegionService;

    /**
     * 列表
     */
    @GetMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = airlinePmsAirportRegionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")

    public R info(@PathVariable("id") Long id){
		AirlinePmsAirportRegionEntity airlinePmsAirportRegion = airlinePmsAirportRegionService.getById(id);

        return R.ok().put("airlinePmsAirportRegion", airlinePmsAirportRegion);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody AirlinePmsAirportRegionEntity airlinePmsAirportRegion){
		airlinePmsAirportRegionService.save(airlinePmsAirportRegion);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody AirlinePmsAirportRegionEntity airlinePmsAirportRegion){
		airlinePmsAirportRegionService.updateById(airlinePmsAirportRegion);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		airlinePmsAirportRegionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
