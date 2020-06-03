package com.eighty.gowhere.airbus;

import com.eighty.gowhere.airbus.entity.AirlinePmsOrderInfoEntity;
import com.eighty.gowhere.airbus.service.AirlinePmsOrderInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GowhereAirlineAirbusApplicationTests {

    @Autowired
    AirlinePmsOrderInfoService airlinePmsOrderInfoService;

    @Test
    void contextLoads() {

        AirlinePmsOrderInfoEntity airlinePmsOrderInfoEntity = new AirlinePmsOrderInfoEntity();

        //airlinePmsOrderInfoEntity.setId(1000);
        airlinePmsOrderInfoEntity.setOrderId(1111L);
        airlinePmsOrderInfoEntity.setPayStatus(0);
        airlinePmsOrderInfoEntity.setTicketStatus(0);

        airlinePmsOrderInfoService.save(airlinePmsOrderInfoEntity);

        System.out.println("插入成功");

    }

}
