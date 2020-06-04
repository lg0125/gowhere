package com.eighty.gowhere.amazon.service.impl;


import com.eighty.gowhere.amazon.utils.PageUtils;
import com.eighty.gowhere.amazon.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.eighty.gowhere.amazon.dao.WebOmsOrderItemDao;
import com.eighty.gowhere.amazon.entity.WebOmsOrderItemEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderItemService;


@Service("webOmsOrderItemService")
public class WebOmsOrderItemServiceImpl extends ServiceImpl<WebOmsOrderItemDao, WebOmsOrderItemEntity> implements WebOmsOrderItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebOmsOrderItemEntity> page = this.page(
                new Query<WebOmsOrderItemEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}