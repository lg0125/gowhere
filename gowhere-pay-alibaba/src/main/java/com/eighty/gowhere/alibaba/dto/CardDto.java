package com.eighty.gowhere.alibaba.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CardDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long orderId;
    private Long cardId;
    private String airlineName;
    private BigDecimal amountPay;
}
