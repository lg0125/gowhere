package com.eighty.gowhere.amazon.service.impl;

import com.eighty.gowhere.amazon.utils.PageUtils;
import com.eighty.gowhere.amazon.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eighty.gowhere.amazon.dao.WebUmsMemberDao;
import com.eighty.gowhere.amazon.entity.WebUmsMemberEntity;
import com.eighty.gowhere.amazon.service.WebUmsMemberService;


@Service("webUmsMemberService")
public class WebUmsMemberServiceImpl extends ServiceImpl<WebUmsMemberDao, WebUmsMemberEntity> implements WebUmsMemberService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebUmsMemberEntity> page = this.page(
                new Query<WebUmsMemberEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}