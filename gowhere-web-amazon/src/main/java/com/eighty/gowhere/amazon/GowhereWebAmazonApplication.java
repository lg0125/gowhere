package com.eighty.gowhere.amazon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@EnableRabbit
@MapperScan("com.eighty.gowhere.amazon.dao")
@SpringBootApplication
public class GowhereWebAmazonApplication {

    public static void main(String[] args) {
        SpringApplication.run(GowhereWebAmazonApplication.class, args);
    }

}
