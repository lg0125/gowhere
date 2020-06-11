package com.eighty.gowhere.amazon.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO
@Configuration
public class MySimpleMQConfig {

    @Bean
    public Queue alibabaQueue(){
        return  new Queue("alibaba-queue",true,false,false);
    }

    @Bean
    public Queue tencentQueue(){
        return new Queue("tencent-queue",true,false,false);
    }

    @Bean
    public Queue airbusQueue(){
        return new Queue("airbus-queue",true,false,false);
    }

    @Bean
    public Queue boeingQueue(){
        return new Queue("boeing-queue",true,false,false);
    }

    @Bean
    public Queue amazonQueue(){
        return new Queue("amazon-queue",true,false,false);
    }

    @Bean
    public Exchange gowhereExchange(){
        return new TopicExchange("gowhere-exchange",true,false);
    }

    @Bean
    public Binding airbusBinding(){
        return new Binding("airbus-queue",
                Binding.DestinationType.QUEUE,
                "gowhere-exchange",
                "airbus",null);
    }

    @Bean
    public Binding boeingBinding(){
        return new Binding("boeing-queue",
                Binding.DestinationType.QUEUE,
                "gowhere-exchange",
                "boeing",null);
    }

    @Bean
    public Binding amazonBinding(){
        return new Binding("amazon-queue",
                Binding.DestinationType.QUEUE,
                "gowhere-exchange",
                "amazon",null);
    }


}
