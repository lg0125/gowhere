package com.eighty.gowhere.boeing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@EnableRabbit
@MapperScan("com.eighty.gowhere.boeing.dao")
@SpringBootApplication
public class GowhereAirlineBoeingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GowhereAirlineBoeingApplication.class, args);
    }

}
