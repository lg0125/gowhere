package com.eighty.gowhere.amazon;

import com.eighty.gowhere.amazon.entity.WebUmsMemberEntity;
import com.eighty.gowhere.amazon.service.WebUmsMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GowhereWebAmazonApplicationTests {

    @Autowired
    WebUmsMemberService webUmsMemberService;

    @Test
    void contextLoads() {
        WebUmsMemberEntity webUmsMemberEntity = new WebUmsMemberEntity();

        webUmsMemberEntity.setCardId(15358L);
        webUmsMemberEntity.setMemberId(32564L);
        webUmsMemberEntity.setMemberName("Chris");
        webUmsMemberEntity.setMemberPassword("3250033");
        webUmsMemberEntity.setUserId(202354L);

        webUmsMemberService.save(webUmsMemberEntity);

        System.out.println("插入成功");
    }

}
