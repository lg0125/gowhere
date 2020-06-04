package com.eighty.gowhere.amazon.controller;

import java.util.Arrays;
import java.util.Map;


import com.eighty.gowhere.amazon.utils.PageUtils;
import com.eighty.gowhere.amazon.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.amazon.entity.WebOmsOrderEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderService;




/**
 * order
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:58:18
 */
@RestController
@RequestMapping("amazon/web/oms/order")
public class WebOmsOrderController {
    @Autowired
    private WebOmsOrderService webOmsOrderService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("amazon:webomsorder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = webOmsOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    //@RequiresPermissions("amazon:webomsorder:info")
    public R info(@PathVariable("id") Long id){
		WebOmsOrderEntity webOmsOrder = webOmsOrderService.getById(id);

        return R.ok().put("webOmsOrder", webOmsOrder);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("amazon:webomsorder:save")
    public R save(@RequestBody WebOmsOrderEntity webOmsOrder){
		webOmsOrderService.save(webOmsOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("amazon:webomsorder:update")
    public R update(@RequestBody WebOmsOrderEntity webOmsOrder){
		webOmsOrderService.updateById(webOmsOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("amazon:webomsorder:delete")
    public R delete(@RequestBody Long[] ids){
		webOmsOrderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
