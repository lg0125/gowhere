package com.eighty.gowhere.tencent;

import com.eighty.gowhere.tencent.entity.CardEntity;
import com.eighty.gowhere.tencent.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class GowherePayTencentApplicationTests {

    @Autowired
    CardService cardService;

    @Test
    void contextLoads() {
        CardEntity cardEntity = new CardEntity();

        cardEntity.setUserName("Gauss");
        cardEntity.setUserId(65896L);
        cardEntity.setCardId(1754878L);
        cardEntity.setAmount(new BigDecimal(50000));

        cardService.save(cardEntity);

        System.out.println("插入成功");
    }

}
