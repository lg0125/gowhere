package com.eighty.gowhere.boeing.service.impl;

import com.eighty.gowhere.boeing.utils.PageUtils;
import com.eighty.gowhere.boeing.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.eighty.gowhere.boeing.dao.AirlinePmsPlaneDao;
import com.eighty.gowhere.boeing.entity.AirlinePmsPlaneEntity;
import com.eighty.gowhere.boeing.service.AirlinePmsPlaneService;


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