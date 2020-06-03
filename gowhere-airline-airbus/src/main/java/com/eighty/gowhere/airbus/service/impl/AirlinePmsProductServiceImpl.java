package com.eighty.gowhere.airbus.service.impl;

import com.eighty.gowhere.airbus.utils.PageUtils;
import com.eighty.gowhere.airbus.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.eighty.gowhere.airbus.dao.AirlinePmsProductDao;
import com.eighty.gowhere.airbus.entity.AirlinePmsProductEntity;
import com.eighty.gowhere.airbus.service.AirlinePmsProductService;


@Service("airlinePmsProductService")
public class AirlinePmsProductServiceImpl extends ServiceImpl<AirlinePmsProductDao, AirlinePmsProductEntity> implements AirlinePmsProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AirlinePmsProductEntity> page = this.page(
                new Query<AirlinePmsProductEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}