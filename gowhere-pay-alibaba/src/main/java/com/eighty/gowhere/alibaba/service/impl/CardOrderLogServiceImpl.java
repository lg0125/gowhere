package com.eighty.gowhere.alibaba.service.impl;

import com.eighty.gowhere.alibaba.utils.PageUtils;
import com.eighty.gowhere.alibaba.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.eighty.gowhere.alibaba.dao.CardOrderLogDao;
import com.eighty.gowhere.alibaba.entity.CardOrderLogEntity;
import com.eighty.gowhere.alibaba.service.CardOrderLogService;


@Service("cardOrderLogService")
public class CardOrderLogServiceImpl extends ServiceImpl<CardOrderLogDao, CardOrderLogEntity> implements CardOrderLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CardOrderLogEntity> page = this.page(
                new Query<CardOrderLogEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}