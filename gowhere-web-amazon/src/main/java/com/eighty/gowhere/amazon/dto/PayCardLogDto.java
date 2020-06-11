package com.eighty.gowhere.amazon.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PayCardLogDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     *
     */
    private Long orderId;
    /**
     *
     */
    private Integer payStatus;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date confirmTime;
    /**
     *
     */
    private Integer deleted;
    /**
     *
     */
    private BigDecimal amount;
    /**
     *
     */
    private Long cardId;

    private String airlineName;
}
