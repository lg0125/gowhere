package com.eighty.gowhere.airbus.service.impl;

import com.eighty.gowhere.airbus.utils.PageUtils;
import com.eighty.gowhere.airbus.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.eighty.gowhere.airbus.dao.AirlinePmsOrderInfoDao;
import com.eighty.gowhere.airbus.entity.AirlinePmsOrderInfoEntity;
import com.eighty.gowhere.airbus.service.AirlinePmsOrderInfoService;


@Service("airlinePmsOrderInfoService")
public class AirlinePmsOrderInfoServiceImpl extends ServiceImpl<AirlinePmsOrderInfoDao, AirlinePmsOrderInfoEntity> implements AirlinePmsOrderInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AirlinePmsOrderInfoEntity> page = this.page(
                new Query<AirlinePmsOrderInfoEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public AirlinePmsOrderInfoEntity queryById(Long orderId) {
        QueryWrapper<AirlinePmsOrderInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        return this.getOne(wrapper);
    }

}