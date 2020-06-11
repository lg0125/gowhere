package com.eighty.gowhere.boeing.service.impl;

import com.eighty.gowhere.boeing.feign.WebFeignService;
import com.eighty.gowhere.boeing.utils.PageUtils;
import com.eighty.gowhere.boeing.utils.Query;
import com.eighty.gowhere.boeing.vo.OrderDrawVo;
import com.eighty.gowhere.boeing.vo.WebOmsOrderItemVo;
import com.eighty.gowhere.boeing.vo.WebOmsOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.eighty.gowhere.boeing.dao.AirlinePmsOrderInfoDao;
import com.eighty.gowhere.boeing.entity.AirlinePmsOrderInfoEntity;
import com.eighty.gowhere.boeing.service.AirlinePmsOrderInfoService;


@Service("airlinePmsOrderInfoService")
public class AirlinePmsOrderInfoServiceImpl extends ServiceImpl<AirlinePmsOrderInfoDao, AirlinePmsOrderInfoEntity> implements AirlinePmsOrderInfoService {

 /*   @Autowired(required = true)
    WebFeignService webFeignService;*/

    @Autowired()
    AirlinePmsOrderInfoService airlinePmsOrderInfoService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AirlinePmsOrderInfoEntity> page = this.page(
                new Query<AirlinePmsOrderInfoEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public OrderDrawVo DrawOrder(Long orderId) {
       /* OrderDrawVo orderDrawVo = new OrderDrawVo();

        WebOmsOrderItemVo webOmsOrderItemVo = webFeignService.getOrderItemByOrderId(orderId);

        WebOmsOrderVo webOmsOrderVo = webFeignService.getOrderByOrderId(orderId);

        AirlinePmsOrderInfoEntity airlinePmsOrderInfoEntity =
                airlinePmsOrderInfoService.getOne(
                        new QueryWrapper<AirlinePmsOrderInfoEntity>().eq("order_id",orderId)
                );

        orderDrawVo.setAirlinePmsOrderInfoEntity(airlinePmsOrderInfoEntity);
        orderDrawVo.setWebOmsOrderItemVo(webOmsOrderItemVo);
        orderDrawVo.setWebOmsOrderVo(webOmsOrderVo);

        return orderDrawVo;*/
       return null;
    }

    @Override
    public AirlinePmsOrderInfoEntity queryById(Long orderId) {
        QueryWrapper<AirlinePmsOrderInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        return this.getOne(wrapper);
    }

}