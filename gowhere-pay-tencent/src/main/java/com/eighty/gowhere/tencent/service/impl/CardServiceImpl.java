package com.eighty.gowhere.tencent.service.impl;

import com.eighty.gowhere.tencent.utils.PageUtils;
import com.eighty.gowhere.tencent.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.eighty.gowhere.tencent.dao.CardDao;
import com.eighty.gowhere.tencent.entity.CardEntity;
import com.eighty.gowhere.tencent.service.CardService;


@Service("cardService")
public class CardServiceImpl extends ServiceImpl<CardDao, CardEntity> implements CardService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CardEntity> page = this.page(
                new Query<CardEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}