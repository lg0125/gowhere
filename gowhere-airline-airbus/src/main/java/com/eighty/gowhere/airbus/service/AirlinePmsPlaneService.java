package com.eighty.gowhere.airbus.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.eighty.gowhere.airbus.entity.AirlinePmsPlaneEntity;
import com.eighty.gowhere.airbus.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:54:24
 */
public interface AirlinePmsPlaneService extends IService<AirlinePmsPlaneEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

