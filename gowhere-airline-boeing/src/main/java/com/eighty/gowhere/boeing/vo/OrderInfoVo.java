package com.eighty.gowhere.boeing.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderInfoVo implements Serializable {

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

}
