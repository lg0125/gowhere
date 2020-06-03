package com.eighty.gowhere.airbus.service.impl;

import com.eighty.gowhere.airbus.utils.PageUtils;
import com.eighty.gowhere.airbus.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.eighty.gowhere.airbus.dao.AirlinePmsPlaneDao;
import com.eighty.gowhere.airbus.entity.AirlinePmsPlaneEntity;
import com.eighty.gowhere.airbus.service.AirlinePmsPlaneService;


@Service("airlinePmsPlaneService")
public class AirlinePmsPlaneServiceImpl extends ServiceImpl<AirlinePmsPlaneDao, AirlinePmsPlaneEntity> implements AirlinePmsPlaneService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AirlinePmsPlaneEntity> page = this.page(
                new Query<AirlinePmsPlaneEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}