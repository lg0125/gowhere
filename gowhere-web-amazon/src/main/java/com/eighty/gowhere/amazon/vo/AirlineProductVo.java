package com.eighty.gowhere.amazon.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Data
public class AirlineProductVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
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
    private Date today;
    /**
     *
     */
    private BigDecimal price;
    /**
     *
     */
    private Long num;
    /**
     *
     */
    private String planeId;
    /**
     *
     */
    private Long productId;
    /**
     *
     */
    private Integer deleted;


    private String airlineName;

    private String fromAirportName;

    private String toAirportName;

    private String fromRegion;

    private String toRegion;
}
