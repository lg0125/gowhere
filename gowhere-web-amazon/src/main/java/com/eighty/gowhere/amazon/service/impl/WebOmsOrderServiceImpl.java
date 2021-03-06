package com.eighty.gowhere.amazon.service.impl;

import com.eighty.gowhere.amazon.utils.PageUtils;
import com.eighty.gowhere.amazon.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.eighty.gowhere.amazon.dao.WebOmsOrderDao;
import com.eighty.gowhere.amazon.entity.WebOmsOrderEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderService;


@Service("webOmsOrderService")
public class WebOmsOrderServiceImpl extends ServiceImpl<WebOmsOrderDao, WebOmsOrderEntity> implements WebOmsOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebOmsOrderEntity> page = this.page(
                new Query<WebOmsOrderEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    //TODO
    @Override
    public void closeOrder(WebOmsOrderEntity entity) {
        WebOmsOrderEntity orderEntity = this.getById(entity.getId());

        if(orderEntity.getPayStatus() == 0){
            WebOmsOrderEntity updateOrder = new WebOmsOrderEntity();
            updateOrder.setId(orderEntity.getId());
            updateOrder.setDeleted(0);
            this.updateById(updateOrder);
        }
    }

    @Override
    public WebOmsOrderEntity getByOrderId(Long orderId) {
        QueryWrapper<WebOmsOrderEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        return this.getOne(wrapper);
    }

}