package com.eighty.gowhere.airbus.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.eighty.gowhere.airbus.entity.AirlinePmsOrderInfoEntity;
import com.eighty.gowhere.airbus.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:54:24
 */
public interface AirlinePmsOrderInfoService extends IService<AirlinePmsOrderInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    AirlinePmsOrderInfoEntity queryById(Long orderId);
}

