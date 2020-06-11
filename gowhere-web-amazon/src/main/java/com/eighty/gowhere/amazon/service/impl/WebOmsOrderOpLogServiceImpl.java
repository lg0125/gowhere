package com.eighty.gowhere.amazon.service.impl;

import com.eighty.gowhere.amazon.utils.PageUtils;
import com.eighty.gowhere.amazon.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.eighty.gowhere.amazon.dao.WebOmsOrderOpLogDao;
import com.eighty.gowhere.amazon.entity.WebOmsOrderOpLogEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderOpLogService;


@Service("webOmsOrderOpLogService")
public class WebOmsOrderOpLogServiceImpl extends ServiceImpl<WebOmsOrderOpLogDao, WebOmsOrderOpLogEntity> implements WebOmsOrderOpLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebOmsOrderOpLogEntity> page = this.page(
                new Query<WebOmsOrderOpLogEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public WebOmsOrderOpLogEntity getByOrderId(Long orderId) {
        QueryWrapper<WebOmsOrderOpLogEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        return this.getOne(wrapper);
    }

}