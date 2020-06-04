package com.eighty.gowhere.amazon.controller;

import java.util.Arrays;
import java.util.Map;

import com.eighty.gowhere.amazon.utils.PageUtils;
import com.eighty.gowhere.amazon.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.amazon.entity.WebOmsOrderPayinfoEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderPayinfoService;




/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:58:18
 */
@RestController
@RequestMapping("amazon/web/oms/order/pay/info")
public class WebOmsOrderPayinfoController {

    @Autowired
    private WebOmsOrderPayinfoService webOmsOrderPayinfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("amazon:webomsorderpayinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = webOmsOrderPayinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    //@RequiresPermissions("amazon:webomsorderpayinfo:info")
    public R info(@PathVariable("id") Long id){
		WebOmsOrderPayinfoEntity webOmsOrderPayinfo = webOmsOrderPayinfoService.getById(id);

        return R.ok().put("webOmsOrderPayinfo", webOmsOrderPayinfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("amazon:webomsorderpayinfo:save")
    public R save(@RequestBody WebOmsOrderPayinfoEntity webOmsOrderPayinfo){
		webOmsOrderPayinfoService.save(webOmsOrderPayinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("amazon:webomsorderpayinfo:update")
    public R update(@RequestBody WebOmsOrderPayinfoEntity webOmsOrderPayinfo){
		webOmsOrderPayinfoService.updateById(webOmsOrderPayinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("amazon:webomsorderpayinfo:delete")
    public R delete(@RequestBody Long[] ids){
		webOmsOrderPayinfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
