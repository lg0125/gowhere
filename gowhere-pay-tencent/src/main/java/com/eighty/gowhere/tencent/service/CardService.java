package com.eighty.gowhere.tencent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eighty.gowhere.tencent.entity.CardEntity;
import com.eighty.gowhere.tencent.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:40:56
 */
public interface CardService extends IService<CardEntity> {

    PageUtils queryPage(Map<String, Object> params);

    CardEntity queryByCardId(Long cardId);
}

