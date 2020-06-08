package com.eighty.gowhere.boeing.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Data
public class WebOmsOrderItemVo implements Serializable {


    private Long id;
    /**
     *
     */
    private Long orderId;
    /**
     *
     */
    private Long productId;
    /**
     *
     */
    private Long fromAirportId;
    /**
     *
     */
    private Time fromTime;
    /**
     *
     */
    private Long toAirportId;
    /**
     *
     */
    private Time toTime;
    /**
     *
     */
    private Date todayTime;
    /**
     *
     */
    private BigDecimal price;
    /**
     *
     */
    private String planeId;
    /**
     *
     */
    private String info;
    /**
     *
     */
    private String airlineName;
    /**
     *
     */
    private Integer status;
    /**
     *
     */
    private Integer num;

}