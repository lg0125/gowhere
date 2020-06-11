package com.eighty.gowhere.alibaba.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.eighty.gowhere.alibaba.entity.CardOrderLogEntity;
import com.eighty.gowhere.alibaba.utils.PageUtils;

import java.util.Map;

/**
 * card_order_log
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 09:35:20
 */
public interface CardOrderLogService extends IService<CardOrderLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

    CardOrderLogEntity getByOrderId(Long orderId);
}

