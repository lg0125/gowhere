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

import com.eighty.gowhere.amazon.entity.WebOmsOrderOpLogEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderOpLogService;



/**
 * order_op_log
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:58:18
 */
@RestController
@RequestMapping("amazon/webomsorderoplog")
public class WebOmsOrderOpLogController {
    @Autowired
    private WebOmsOrderOpLogService webOmsOrderOpLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("amazon:webomsorderoplog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = webOmsOrderOpLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("amazon:webomsorderoplog:info")
    public R info(@PathVariable("id") Long id){
		WebOmsOrderOpLogEntity webOmsOrderOpLog = webOmsOrderOpLogService.getById(id);

        return R.ok().put("webOmsOrderOpLog", webOmsOrderOpLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("amazon:webomsorderoplog:save")
    public R save(@RequestBody WebOmsOrderOpLogEntity webOmsOrderOpLog){
		webOmsOrderOpLogService.save(webOmsOrderOpLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("amazon:webomsorderoplog:update")
    public R update(@RequestBody WebOmsOrderOpLogEntity webOmsOrderOpLog){
		webOmsOrderOpLogService.updateById(webOmsOrderOpLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("amazon:webomsorderoplog:delete")
    public R delete(@RequestBody Long[] ids){
		webOmsOrderOpLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
