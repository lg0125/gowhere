package com.eighty.gowhere.amazon.controller;

import java.util.Arrays;
import java.util.Map;


import com.eighty.gowhere.amazon.utils.PageUtils;
import com.eighty.gowhere.amazon.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eighty.gowhere.amazon.entity.WebOmsOrderItemEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderItemService;




/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-04 09:29:50
 */
@RestController
@RequestMapping("amazon/webomsorderitem")
public class WebOmsOrderItemController {
    @Autowired
    private WebOmsOrderItemService webOmsOrderItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("amazon:webomsorderitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = webOmsOrderItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("amazon:webomsorderitem:info")
    public R info(@PathVariable("id") Long id){
		WebOmsOrderItemEntity webOmsOrderItem = webOmsOrderItemService.getById(id);

        return R.ok().put("webOmsOrderItem", webOmsOrderItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("amazon:webomsorderitem:save")
    public R save(@RequestBody WebOmsOrderItemEntity webOmsOrderItem){
		webOmsOrderItemService.save(webOmsOrderItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("amazon:webomsorderitem:update")
    public R update(@RequestBody WebOmsOrderItemEntity webOmsOrderItem){
		webOmsOrderItemService.updateById(webOmsOrderItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("amazon:webomsorderitem:delete")
    public R delete(@RequestBody Long[] ids){
		webOmsOrderItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
