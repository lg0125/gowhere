package com.eighty.gowhere.boeing.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.eighty.gowhere.boeing.entity.AirlinePmsProductEntity;
import com.eighty.gowhere.boeing.utils.PageUtils;

import java.util.Map;

/**
 * product
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:48:45
 */
public interface AirlinePmsProductService extends IService<AirlinePmsProductEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

