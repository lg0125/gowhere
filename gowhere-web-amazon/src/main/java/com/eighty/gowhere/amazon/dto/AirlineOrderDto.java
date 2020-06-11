package com.eighty.gowhere.amazon.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AirlineOrderDto implements Serializable {
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
    private Integer ticketStatus;
    /**
     *
     */
    private Integer deleted;

    private String payName;

    private Long productId;
}
