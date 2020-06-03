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

import com.eighty.gowhere.amazon.entity.WebUmsMemberEntity;
import com.eighty.gowhere.amazon.service.WebUmsMemberService;




/**
 * ums_member
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:58:18
 */
@RestController
@RequestMapping("amazon/webumsmember")
public class WebUmsMemberController {
    @Autowired
    private WebUmsMemberService webUmsMemberService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("amazon:webumsmember:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = webUmsMemberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("amazon:webumsmember:info")
    public R info(@PathVariable("id") Long id){
		WebUmsMemberEntity webUmsMember = webUmsMemberService.getById(id);

        return R.ok().put("webUmsMember", webUmsMember);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("amazon:webumsmember:save")
    public R save(@RequestBody WebUmsMemberEntity webUmsMember){
		webUmsMemberService.save(webUmsMember);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("amazon:webumsmember:update")
    public R update(@RequestBody WebUmsMemberEntity webUmsMember){
		webUmsMemberService.updateById(webUmsMember);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("amazon:webumsmember:delete")
    public R delete(@RequestBody Long[] ids){
		webUmsMemberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
