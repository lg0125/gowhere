package com.eighty.gowhere.boeing.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WebOmsOrderVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     *
     */
    private Long orderId;
    /**
     *
     */
    private Long memberId;
    /**
     *
     */
    private String memberName;
    /**
     *
     */
    private BigDecimal amount;
    /**
     *
     */
    private String payName;
    /**
     *
     */
    private Long card;
    /**
     *
     */
    private Long memberPhone;
    /**
     *
     */
    private Integer orderStatus;
    /**
     *
     */
    private Integer deleted;
}
