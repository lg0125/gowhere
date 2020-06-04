package com.eighty.gowhere.tencent;

import com.eighty.gowhere.tencent.entity.CardEntity;
import com.eighty.gowhere.tencent.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@Slf4j
@SpringBootTest
class GowherePayTencentApplicationTests {

    @Autowired
    CardService cardService;

    @Autowired
    AmqpAdmin amqpAdmin;

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

    @Test
    void testExchange(){
        DirectExchange directExchange = new DirectExchange("pay-tencent-exchange",
                true,
                false);
        amqpAdmin.declareExchange(directExchange);
        log.info("exchange创建成功");
    }

    @Test
    void testQueue(){
        Queue queue = new Queue("pay-tencent-queue",
                true,
                false,
                false);
        amqpAdmin.declareQueue(queue);
        log.info("queue创建成功");
    }

    @Test
    void testBinding(){
        Binding binding = new Binding("pay-tencent-queue",
                Binding.DestinationType.QUEUE,
                "pay-tencent-exchange",
                "tencent-1",
                null);
        amqpAdmin.declareBinding(binding);
        log.info("binding创建成功");
    }


}
