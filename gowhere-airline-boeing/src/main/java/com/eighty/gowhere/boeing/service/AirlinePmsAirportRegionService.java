package com.eighty.gowhere.boeing.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.eighty.gowhere.boeing.entity.AirlinePmsAirportRegionEntity;
import com.eighty.gowhere.boeing.utils.PageUtils;

import java.util.Map;

/**
 * airport_region
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:48:45
 */
public interface AirlinePmsAirportRegionService extends IService<AirlinePmsAirportRegionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

