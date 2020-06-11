package com.eighty.gowhere.airbus.listener;

import com.eighty.gowhere.airbus.entity.AirlinePmsOrderInfoEntity;
import com.eighty.gowhere.airbus.entity.AirlinePmsProductEntity;
import com.eighty.gowhere.airbus.service.AirlinePmsOrderInfoService;
import com.eighty.gowhere.airbus.service.AirlinePmsProductService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


//@RabbitListener(queues = "airbus-queue")
@Service
public class AirbusOrderListener {

    @Autowired
    AirlinePmsOrderInfoService airlinePmsOrderInfoService;

    @Autowired
    AirlinePmsProductService airlinePmsProductService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    //@RabbitHandler
    @RabbitListener(queues = "airbus-queue")
    public void payStatusListener(Message message, Channel channel) throws IOException {
        Long orderId = Long.parseLong(new String(message.getBody()));
        System.out.println("支付成功:"+orderId);

        try {

            AirlinePmsOrderInfoEntity airlinePmsOrderInfoEntity = airlinePmsOrderInfoService.queryById(orderId);

            Integer OK = 1;
            airlinePmsOrderInfoEntity.setPayStatus(OK);
            airlinePmsOrderInfoEntity.setTicketStatus(OK);
            airlinePmsOrderInfoService.saveOrUpdate(airlinePmsOrderInfoEntity);

            Long productId = airlinePmsOrderInfoEntity.getProductId();
            AirlinePmsProductEntity airlinePmsProductEntity = airlinePmsProductService.getProductByProductId(productId);
            airlinePmsProductEntity.setNum(airlinePmsProductEntity.getNum() - 1);
            airlinePmsProductService.saveOrUpdate(airlinePmsProductEntity);

            //TODO 给Amazon发消息
            rabbitTemplate.convertAndSend("gowhere-exchange",
                    "amazon",
                    orderId);

            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch (Exception e){
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }

    }

}
