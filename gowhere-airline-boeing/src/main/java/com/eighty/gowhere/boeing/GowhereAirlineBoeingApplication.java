package com.eighty.gowhere.boeing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.eighty.gowhere.boeing.dao")
@SpringBootApplication
public class GowhereAirlineBoeingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GowhereAirlineBoeingApplication.class, args);
    }

}
