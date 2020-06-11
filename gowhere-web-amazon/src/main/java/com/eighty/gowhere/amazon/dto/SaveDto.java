package com.eighty.gowhere.amazon.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SaveDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long orderId;

    private Long memberId;

    private BigDecimal amountPay;

    private String payName;

    private Long memberPhone;

    private String memberName;

    private String airlineName;

    private Long productId;

    //private Long cardId;

}
