package com.eighty.gowhere.boeing;

import com.eighty.gowhere.boeing.entity.AirlinePmsOrderInfoEntity;
import com.eighty.gowhere.boeing.service.AirlinePmsOrderInfoService;
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
class GowhereAirlineBoeingApplicationTests {

/*    @Autowired
    AirlinePmsOrderInfoService airlinePmsOrderInfoService;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void contextLoads() {
        AirlinePmsOrderInfoEntity airlinePmsOrderInfoEntity = new AirlinePmsOrderInfoEntity();

        //airlinePmsOrderInfoEntity.setId(1000);
        airlinePmsOrderInfoEntity.setOrderId(1111L);
        airlinePmsOrderInfoEntity.setPayStatus(0);
        airlinePmsOrderInfoEntity.setTicketStatus(0);

        airlinePmsOrderInfoService.save(airlinePmsOrderInfoEntity);

        System.out.println("插入成功");

    }

    @Test
    void testExchange(){
        DirectExchange directExchange = new DirectExchange("airline-boeing-exchange",
                true,
                false);
        amqpAdmin.declareExchange(directExchange);
        log.info("exchange创建成功");
    }

    @Test
    void testQueue(){
        Queue queue = new Queue("airline-boeing-queue",
                true,
                false,
                false);
        amqpAdmin.declareQueue(queue);
        log.info("queue创建成功");
    }

    @Test
    void testBinding(){
        Binding binding = new Binding("airline-boeing-queue",
                Binding.DestinationType.QUEUE,
                "airline-boeing-exchange",
                "boeing-1",
                null);
        amqpAdmin.declareBinding(binding);
        log.info("binding创建成功");
    }*/

}
