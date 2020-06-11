package com.eighty.gowhere.boeing.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.eighty.gowhere.boeing.entity.AirlinePmsOrderInfoEntity;
import com.eighty.gowhere.boeing.utils.PageUtils;
import com.eighty.gowhere.boeing.vo.OrderDrawVo;

import java.util.Map;

/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:48:45
 */
public interface AirlinePmsOrderInfoService extends IService<AirlinePmsOrderInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    OrderDrawVo DrawOrder(Long orderId);

    AirlinePmsOrderInfoEntity queryById(Long orderId);
}

