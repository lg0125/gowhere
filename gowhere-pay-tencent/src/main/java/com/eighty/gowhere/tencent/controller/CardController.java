package com.eighty.gowhere.tencent.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eighty.gowhere.tencent.entity.CardEntity;
import com.eighty.gowhere.tencent.service.CardService;


import com.eighty.gowhere.tencent.utils.*;



/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:40:56
 */
@RestController
@RequestMapping("tencent/card")
public class CardController {
    @Autowired
    private CardService cardService;

    /**
     * 列表
     *
     *
     */
    @RequestMapping("/list")
    //@RequiresPermissions("tencent:card:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cardService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("tencent:card:info")
    public R info(@PathVariable("id") Long id){
		CardEntity card = cardService.getById(id);

        return R.ok().put("card", card);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("tencent:card:save")
    public R save(@RequestBody CardEntity card){
		cardService.save(card);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("tencent:card:update")
    public R update(@RequestBody CardEntity card){
		cardService.updateById(card);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("tencent:card:delete")
    public R delete(@RequestBody Long[] ids){
		cardService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
