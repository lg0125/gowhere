package com.eighty.gowhere.alibaba;

import com.eighty.gowhere.alibaba.entity.CardEntity;
import com.eighty.gowhere.alibaba.service.CardService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


@SpringBootTest
class GowherePayAlibabaApplicationTests {

    @Autowired
    CardService cardService;

    @Test
     void contextLoads() {
        CardEntity cardEntity = new CardEntity();


        cardEntity.setUserName("Abel");
        cardEntity.setUserId(65897L);
        cardEntity.setCardId(1754879L);
        cardEntity.setAmount(new BigDecimal(50000));


        cardService.save(cardEntity);

        System.out.println("插入成功");
    }

}
