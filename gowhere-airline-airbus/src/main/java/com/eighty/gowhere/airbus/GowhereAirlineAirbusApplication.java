package com.eighty.gowhere.airbus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableCaching
@EnableRabbit
@MapperScan("com.eighty.gowhere.airbus.dao")
@SpringBootApplication
public class GowhereAirlineAirbusApplication {

    public static void main(String[] args) {
        SpringApplication.run(GowhereAirlineAirbusApplication.class, args);
    }

}
