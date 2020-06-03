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

import com.eighty.gowhere.boeing.entity.AirlinePmsPlaneEntity;
import com.eighty.gowhere.boeing.service.AirlinePmsPlaneService;




/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:48:45
 */
@RestController
@RequestMapping("boeing/airlinepmsplane")
public class AirlinePmsPlaneController {
    @Autowired
    private AirlinePmsPlaneService airlinePmsPlaneService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("boeing:airlinepmsplane:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = airlinePmsPlaneService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{planeId}")
    //@RequiresPermissions("boeing:airlinepmsplane:info")
    public R info(@PathVariable("planeId") String planeId){
		AirlinePmsPlaneEntity airlinePmsPlane = airlinePmsPlaneService.getById(planeId);

        return R.ok().put("airlinePmsPlane", airlinePmsPlane);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("boeing:airlinepmsplane:save")
    public R save(@RequestBody AirlinePmsPlaneEntity airlinePmsPlane){
		airlinePmsPlaneService.save(airlinePmsPlane);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("boeing:airlinepmsplane:update")
    public R update(@RequestBody AirlinePmsPlaneEntity airlinePmsPlane){
		airlinePmsPlaneService.updateById(airlinePmsPlane);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("boeing:airlinepmsplane:delete")
    public R delete(@RequestBody String[] planeIds){
		airlinePmsPlaneService.removeByIds(Arrays.asList(planeIds));

        return R.ok();
    }

}
