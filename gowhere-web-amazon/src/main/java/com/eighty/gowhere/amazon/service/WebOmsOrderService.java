package com.eighty.gowhere.amazon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eighty.gowhere.amazon.utils.PageUtils;
import com.eighty.gowhere.amazon.entity.WebOmsOrderEntity;

import java.util.Map;

/**
 * order
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:58:18
 */
public interface WebOmsOrderService extends IService<WebOmsOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

