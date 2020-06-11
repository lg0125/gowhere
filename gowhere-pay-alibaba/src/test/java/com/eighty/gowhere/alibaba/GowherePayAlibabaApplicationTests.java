package com.eighty.gowhere.alibaba;

import com.eighty.gowhere.alibaba.entity.CardEntity;
import com.eighty.gowhere.alibaba.service.CardService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@Ignore
@Slf4j
@SpringBootTest
class GowherePayAlibabaApplicationTests {

/*    @Autowired
    CardService cardService;

    @Autowired
    AmqpAdmin amqpAdmin;


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

    @Test
    void testExchange(){
        DirectExchange directExchange = new DirectExchange("pay-alibaba-exchange",
                true,
                false);
        amqpAdmin.declareExchange(directExchange);
        log.info("exchange创建成功");
    }

    @Test
    void testQueue(){
        Queue queue = new Queue("pay-alibaba-queue",
                true,
                false,
                false);
        amqpAdmin.declareQueue(queue);
        log.info("queue创建成功");
    }

    @Test
    void testBinding(){
        Binding binding = new Binding("pay-alibaba-queue",
                Binding.DestinationType.QUEUE,
                "pay-alibaba-exchange",
                "alibaba-1",
                null);
        amqpAdmin.declareBinding(binding);
        log.info("binding创建成功");
    }*/

}
