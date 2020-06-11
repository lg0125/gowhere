package com.eighty.gowhere.amazon.service;

import com.baomidou.mybatisplus.extension.service.IService;


import com.eighty.gowhere.amazon.entity.WebOmsOrderOpLogEntity;
import com.eighty.gowhere.amazon.utils.PageUtils;

import java.util.Map;

/**
 * order_op_log
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:58:18
 */
public interface WebOmsOrderOpLogService extends IService<WebOmsOrderOpLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

    WebOmsOrderOpLogEntity getByOrderId(Long orderId);
}

