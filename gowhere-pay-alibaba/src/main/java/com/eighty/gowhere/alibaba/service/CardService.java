package com.eighty.gowhere.alibaba.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.eighty.gowhere.alibaba.entity.CardEntity;
import com.eighty.gowhere.alibaba.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 09:35:21
 */
public interface CardService extends IService<CardEntity> {

    PageUtils queryPage(Map<String, Object> params);

    CardEntity queryByCardId(Long cardId);
}

