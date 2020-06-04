package com.eighty.gowhere.amazon;

import com.eighty.gowhere.amazon.entity.WebUmsMemberEntity;
import com.eighty.gowhere.amazon.service.WebUmsMemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class GowhereWebAmazonApplicationTests {

    @Autowired
    WebUmsMemberService webUmsMemberService;

    @Autowired
    AmqpAdmin amqpAdmin;

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

    @Test
    void testAmqpAdmin(){
        DirectExchange directExchange = new DirectExchange("web-amazon-new-exchange",
                true,
                false);

        amqpAdmin.declareExchange(directExchange);
        log.info("web-amazon-exchange创建成功");
    }

    @Test
    void testQueue(){
        Queue queue = new Queue("web-amazon-queue",true,false,false);
        amqpAdmin.declareQueue(queue);
        log.info("queue创建成功");
    }

    @Test
    void testBinding(){
        //destination :
        //destinationType:
        //exchange:
        //routingKey:
        Binding binding = new Binding("web-amazon-queue",
                Binding.DestinationType.QUEUE,
                "web-amazon-exchange",
                "amazon-1",
                null);
        amqpAdmin.declareBinding(binding);
        log.info("binding创建成功");
    }

}
