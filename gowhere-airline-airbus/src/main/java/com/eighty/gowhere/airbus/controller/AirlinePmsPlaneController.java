package com.eighty.gowhere.airbus.controller;

import java.util.Arrays;
import java.util.Map;


import com.eighty.gowhere.airbus.utils.PageUtils;
import com.eighty.gowhere.airbus.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.airbus.entity.AirlinePmsPlaneEntity;
import com.eighty.gowhere.airbus.service.AirlinePmsPlaneService;




/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:54:24
 */
@RestController
@RequestMapping("airbus/airline/pms/plane")
public class AirlinePmsPlaneController {
    @Autowired
    private AirlinePmsPlaneService airlinePmsPlaneService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("airbus:airlinepmsplane:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = airlinePmsPlaneService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{planeId}")
    //@RequiresPermissions("airbus:airlinepmsplane:info")
    public R info(@PathVariable("planeId") String planeId){
		AirlinePmsPlaneEntity airlinePmsPlane = airlinePmsPlaneService.getById(planeId);

        return R.ok().put("airlinePmsPlane", airlinePmsPlane);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("airbus:airlinepmsplane:save")
    public R save(@RequestBody AirlinePmsPlaneEntity airlinePmsPlane){
		airlinePmsPlaneService.save(airlinePmsPlane);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("airbus:airlinepmsplane:update")
    public R update(@RequestBody AirlinePmsPlaneEntity airlinePmsPlane){
		airlinePmsPlaneService.updateById(airlinePmsPlane);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("airbus:airlinepmsplane:delete")
    public R delete(@RequestBody String[] planeIds){
		airlinePmsPlaneService.removeByIds(Arrays.asList(planeIds));

        return R.ok();
    }

}
