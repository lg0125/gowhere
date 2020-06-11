package com.eighty.gowhere.amazon.listener;

import com.eighty.gowhere.amazon.entity.WebOmsOrderEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RabbitListener(queues = "order.release.order.queue")
@Service
public class OrderCloseListener {

    @Autowired
    WebOmsOrderService webOmsOrderService;

    @RabbitHandler
    public void listener(WebOmsOrderEntity webOmsOrderEntity, Channel channel, Message message) throws IOException {
        System.out.println("收到过期订单,准备关闭订单:"+webOmsOrderEntity.getOrderId());

        try {
            webOmsOrderService.closeOrder(webOmsOrderEntity);

            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch (Exception e){
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }
    }
}
