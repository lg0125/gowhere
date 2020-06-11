package com.eighty.gowhere.amazon.utils;

import com.eighty.gowhere.amazon.dto.AirlineOrderDto;
import com.eighty.gowhere.amazon.dto.PayCardLogDto;
import com.eighty.gowhere.amazon.dto.SaveDto;
import com.eighty.gowhere.amazon.entity.WebOmsOrderEntity;
import com.eighty.gowhere.amazon.entity.WebOmsOrderOpLogEntity;
import com.eighty.gowhere.amazon.entity.WebOmsOrderPayinfoEntity;

import java.util.Date;

public class MyObjConvert {

    public static WebOmsOrderOpLogEntity order2OpLog(WebOmsOrderEntity webOmsOrderEntity){
        WebOmsOrderOpLogEntity opLogEntity = new WebOmsOrderOpLogEntity();
        Long orderId = webOmsOrderEntity.getOrderId();
        opLogEntity.setOrderId(orderId);
        Date date = new Date();
        opLogEntity.setCreateTime(date);
        opLogEntity.setNote(orderId + ":" + date);
        opLogEntity.setOpRole("user");
        return opLogEntity;
    }

    public static WebOmsOrderPayinfoEntity order2PayInfo(WebOmsOrderEntity webOmsOrderEntity){
        WebOmsOrderPayinfoEntity payinfoEntity = new WebOmsOrderPayinfoEntity();
        Date date = new Date();
        payinfoEntity.setConfirmTime(date);
        payinfoEntity.setCreateTime(date);
        payinfoEntity.setOrderId(webOmsOrderEntity.getOrderId());
        payinfoEntity.setAmount(webOmsOrderEntity.getAmountPay());
        return payinfoEntity;
    }

    public static AirlineOrderDto order2AirlineOrderDto(WebOmsOrderEntity webOmsOrderEntity){
        AirlineOrderDto airlineOrderDto = new AirlineOrderDto();
        airlineOrderDto.setOrderId(webOmsOrderEntity.getOrderId());
        airlineOrderDto.setPayName(webOmsOrderEntity.getPayName());
        airlineOrderDto.setProductId(webOmsOrderEntity.getProductId());
        return airlineOrderDto;
    }

    public static PayCardLogDto order2CardLogDto(WebOmsOrderEntity webOmsOrderEntity){
        PayCardLogDto payCardLogDto = new PayCardLogDto();
        Date date = new Date();
        payCardLogDto.setConfirmTime(date);
        payCardLogDto.setCreateTime(date);
        payCardLogDto.setAirlineName(webOmsOrderEntity.getAirlineName());
        payCardLogDto.setAmount(webOmsOrderEntity.getAmountPay());
        payCardLogDto.setOrderId(webOmsOrderEntity.getOrderId());
        payCardLogDto.setCardId(webOmsOrderEntity.getCardId());
        return payCardLogDto;
    }


    public static WebOmsOrderEntity dto2Order(SaveDto saveDto) {
        WebOmsOrderEntity webOmsOrderEntity = new WebOmsOrderEntity();
        webOmsOrderEntity.setAirlineName(saveDto.getAirlineName());
        webOmsOrderEntity.setAmountPay(saveDto.getAmountPay());
        webOmsOrderEntity.setMemberId(saveDto.getMemberId());
        webOmsOrderEntity.setMemberName(saveDto.getMemberName());
        webOmsOrderEntity.setMemberPhone(saveDto.getMemberPhone());
        webOmsOrderEntity.setOrderId(saveDto.getOrderId());
        webOmsOrderEntity.setPayName(saveDto.getPayName());
        webOmsOrderEntity.setProductId(saveDto.getProductId());
        //webOmsOrderEntity.setCardId(saveDto.getCardId());
        return webOmsOrderEntity;
    }
}
