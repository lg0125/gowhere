package com.eighty.gowhere.amazon.listener;

import com.eighty.gowhere.amazon.entity.WebOmsOrderEntity;
import com.eighty.gowhere.amazon.entity.WebOmsOrderOpLogEntity;
import com.eighty.gowhere.amazon.entity.WebOmsOrderPayinfoEntity;
import com.eighty.gowhere.amazon.service.WebOmsOrderOpLogService;
import com.eighty.gowhere.amazon.service.WebOmsOrderPayinfoService;
import com.eighty.gowhere.amazon.service.WebOmsOrderService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

//@RabbitListener(queues = "amazon-queue")
@Service
public class OrderListener {

    @Autowired
    WebOmsOrderService webOmsOrderService;
    @Autowired
    WebOmsOrderPayinfoService webOmsOrderPayinfoService;
    @Autowired
    WebOmsOrderOpLogService webOmsOrderOpLogService;

    //@RabbitHandler
    @RabbitListener(queues = "amazon-queue")
    public void orderStatusListener(Message message, Channel channel) throws IOException {
        Long orderId = Long.parseLong(new String(message.getBody()));
        System.out.println("航空公司确认成功,出票:"+orderId);

        try {
            Integer OK=1;

            WebOmsOrderEntity webOmsOrderEntity = webOmsOrderService.getByOrderId(orderId);
            webOmsOrderEntity.setPayStatus(OK);
            webOmsOrderEntity.setOrderStatus(OK);
            webOmsOrderService.saveOrUpdate(webOmsOrderEntity);

            WebOmsOrderOpLogEntity webOmsOrderOpLogEntity = webOmsOrderOpLogService.getByOrderId(orderId);
            webOmsOrderOpLogEntity.setOrderStatus(OK);
            webOmsOrderOpLogService.saveOrUpdate(webOmsOrderOpLogEntity);

            WebOmsOrderPayinfoEntity webOmsOrderPayinfoEntity = webOmsOrderPayinfoService.getByOrderId(orderId);
            webOmsOrderPayinfoEntity.setConfirmTime(new Date());
            webOmsOrderPayinfoEntity.setPayStatus(OK);
            webOmsOrderPayinfoService.saveOrUpdate(webOmsOrderPayinfoEntity);


            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch (Exception e){
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }
    }



}
