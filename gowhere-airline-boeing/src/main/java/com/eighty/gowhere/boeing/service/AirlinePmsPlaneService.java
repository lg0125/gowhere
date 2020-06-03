package com.eighty.gowhere.boeing.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.eighty.gowhere.boeing.entity.AirlinePmsPlaneEntity;
import com.eighty.gowhere.boeing.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:48:45
 */
public interface AirlinePmsPlaneService extends IService<AirlinePmsPlaneEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

