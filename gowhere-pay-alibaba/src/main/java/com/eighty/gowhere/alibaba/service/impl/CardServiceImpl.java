package com.eighty.gowhere.alibaba.service.impl;

import com.eighty.gowhere.alibaba.utils.PageUtils;
import com.eighty.gowhere.alibaba.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.eighty.gowhere.alibaba.dao.CardDao;
import com.eighty.gowhere.alibaba.entity.CardEntity;
import com.eighty.gowhere.alibaba.service.CardService;


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

    @Override
    public CardEntity queryByCardId(Long cardId) {
        QueryWrapper<CardEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("card_id",cardId);
        return this.getOne(wrapper);
    }

}