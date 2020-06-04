package com.eighty.gowhere.tencent.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.tencent.entity.CardOrderLogEntity;
import com.eighty.gowhere.tencent.service.CardOrderLogService;

import com.eighty.gowhere.tencent.utils.*;



/**
 * card_order_log
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:40:56
 */
@RestController
@RequestMapping("tencent/card/order/log")
public class CardOrderLogController {
    @Autowired
    private CardOrderLogService cardOrderLogService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("tencent:cardorderlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cardOrderLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    //@RequiresPermissions("tencent:cardorderlog:info")
    public R info(@PathVariable("id") Long id){
		CardOrderLogEntity cardOrderLog = cardOrderLogService.getById(id);

        return R.ok().put("cardOrderLog", cardOrderLog);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("tencent:cardorderlog:save")
    public R save(@RequestBody CardOrderLogEntity cardOrderLog){
		cardOrderLogService.save(cardOrderLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("tencent:cardorderlog:update")
    public R update(@RequestBody CardOrderLogEntity cardOrderLog){
		cardOrderLogService.updateById(cardOrderLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("tencent:cardorderlog:delete")
    public R delete(@RequestBody Long[] ids){
		cardOrderLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
