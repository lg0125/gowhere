package com.eighty.gowhere.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 1.整合mybatisPlus
 *      (1)导入依赖
 *      (2)
 *          配置数据源
 *              导入数据库驱动
 *              application.yml配置相关信息
 *          配置MybatisPlus
 *              入口处@MapperScan
 *              告诉MybatisPlus SQL映射文件位置
 */

@EnableCaching
@EnableRabbit
@MapperScan("com.eighty.gowhere.alibaba.dao")
@SpringBootApplication
public class GowherePayAlibabaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GowherePayAlibabaApplication.class, args);
    }

}
