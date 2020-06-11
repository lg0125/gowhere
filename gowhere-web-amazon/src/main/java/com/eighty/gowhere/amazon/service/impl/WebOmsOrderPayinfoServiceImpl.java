package com.eighty.gowhere.amazon.service.impl;

import com.eighty.gowhere.amazon.utils.PageUtils;
import com.eighty.gowhere.amazon.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.eighty.gowhere.amazon.dao.WebOmsOrderPayinfoDao;
import com.eighty.gowhere.amazon.entity.WebOmsOrderPayinfoEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderPayinfoService;


@Service("webOmsOrderPayinfoService")
public class WebOmsOrderPayinfoServiceImpl extends ServiceImpl<WebOmsOrderPayinfoDao, WebOmsOrderPayinfoEntity> implements WebOmsOrderPayinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebOmsOrderPayinfoEntity> page = this.page(
                new Query<WebOmsOrderPayinfoEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public WebOmsOrderPayinfoEntity getByOrderId(Long orderId) {
        QueryWrapper<WebOmsOrderPayinfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        return this.getOne(wrapper);
    }

}