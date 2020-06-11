package com.eighty.gowhere.alibaba.controller;

import java.util.Arrays;
import java.util.Map;


import com.eighty.gowhere.alibaba.utils.PageUtils;
import com.eighty.gowhere.alibaba.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eighty.gowhere.alibaba.entity.CardOrderLogEntity;
import com.eighty.gowhere.alibaba.service.CardOrderLogService;




/**
 * card_order_log
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 09:35:20
 */
@RestController
@RequestMapping("alibaba/cardorderlog")
public class CardOrderLogController {
    @Autowired
    private CardOrderLogService cardOrderLogService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("alibaba:cardorderlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cardOrderLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    //@RequiresPermissions("alibaba:cardorderlog:info")
    public R info(@PathVariable("id") Long id){
		CardOrderLogEntity cardOrderLog = cardOrderLogService.getById(id);

        return R.ok().put("cardOrderLog", cardOrderLog);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CardOrderLogEntity cardOrderLog){
		cardOrderLogService.save(cardOrderLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("alibaba:cardorderlog:update")
    public R update(@RequestBody CardOrderLogEntity cardOrderLog){
		cardOrderLogService.updateById(cardOrderLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("alibaba:cardorderlog:delete")
    public R delete(@RequestBody Long[] ids){
		cardOrderLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
