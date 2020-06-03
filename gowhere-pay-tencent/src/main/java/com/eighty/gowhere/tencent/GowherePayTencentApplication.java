package com.eighty.gowhere.tencent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.eighty.gowhere.tencent.dao")
@SpringBootApplication
public class GowherePayTencentApplication {

    public static void main(String[] args) {
        SpringApplication.run(GowherePayTencentApplication.class, args);
    }

}
