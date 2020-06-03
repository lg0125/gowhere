package com.eighty.gowhere.airbus.service.impl;


import com.eighty.gowhere.airbus.utils.PageUtils;
import com.eighty.gowhere.airbus.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.eighty.gowhere.airbus.dao.AirlinePmsAirportRegionDao;
import com.eighty.gowhere.airbus.entity.AirlinePmsAirportRegionEntity;
import com.eighty.gowhere.airbus.service.AirlinePmsAirportRegionService;


@Service("airlinePmsAirportRegionService")
public class AirlinePmsAirportRegionServiceImpl extends ServiceImpl<AirlinePmsAirportRegionDao, AirlinePmsAirportRegionEntity> implements AirlinePmsAirportRegionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AirlinePmsAirportRegionEntity> page = this.page(
                new Query<AirlinePmsAirportRegionEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}