package com.eighty.gowhere.amazon.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MyRabbitConfig {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Bean
    public MessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }

    @PostConstruct
    public void initRabbitTemplate() {
        rabbitTemplate.setConfirmCallback((correlationData, b, s) -> System.out.println("confirm...CorrelationData[" + correlationData + "]==>ACK[" + b + "]==>Cause[" + s + "]"));

        rabbitTemplate.setReturnCallback((message, i, s, s1, s2) -> {
            System.out.println("Fail Message["+message+"]==>replyCode["+i+"]==>replyText["+s+"]==>exchange["+s1+"]==>routingKey["+s2+"]");
        });
    }
}
