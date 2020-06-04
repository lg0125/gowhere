package com.eighty.gowhere.airbus.controller;

import java.util.Arrays;
import java.util.Map;

import com.eighty.gowhere.airbus.utils.PageUtils;
import com.eighty.gowhere.airbus.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.airbus.entity.AirlinePmsAirportRegionEntity;
import com.eighty.gowhere.airbus.service.AirlinePmsAirportRegionService;



/**
 * airport_region
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:54:24
 */
@RestController
@RequestMapping("airbus/airline/pms/airport/region")
public class AirlinePmsAirportRegionController {
    @Autowired
    private AirlinePmsAirportRegionService airlinePmsAirportRegionService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("airbus:airlinepmsairportregion:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = airlinePmsAirportRegionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    //@RequiresPermissions("airbus:airlinepmsairportregion:info")
    public R info(@PathVariable("id") Long id){
		AirlinePmsAirportRegionEntity airlinePmsAirportRegion = airlinePmsAirportRegionService.getById(id);

        return R.ok().put("airlinePmsAirportRegion", airlinePmsAirportRegion);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("airbus:airlinepmsairportregion:save")
    public R save(@RequestBody AirlinePmsAirportRegionEntity airlinePmsAirportRegion){
		airlinePmsAirportRegionService.save(airlinePmsAirportRegion);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("airbus:airlinepmsairportregion:update")
    public R update(@RequestBody AirlinePmsAirportRegionEntity airlinePmsAirportRegion){
		airlinePmsAirportRegionService.updateById(airlinePmsAirportRegion);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("airbus:airlinepmsairportregion:delete")
    public R delete(@RequestBody Long[] ids){
		airlinePmsAirportRegionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
