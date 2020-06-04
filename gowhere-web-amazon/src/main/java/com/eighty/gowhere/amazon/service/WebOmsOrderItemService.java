package com.eighty.gowhere.amazon.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.eighty.gowhere.amazon.entity.WebOmsOrderItemEntity;
import com.eighty.gowhere.amazon.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-04 09:29:50
 */
public interface WebOmsOrderItemService extends IService<WebOmsOrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

