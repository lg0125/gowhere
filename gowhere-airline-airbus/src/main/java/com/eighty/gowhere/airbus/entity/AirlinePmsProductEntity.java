package com.eighty.gowhere.airbus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:54:24
 */
@Data
@TableName("airline_pms_product")
public class AirlinePmsProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.ASSIGN_ID)
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

	@TableField(exist = false)
	private String airlineName = "airbus";

	private String fromAirportName;

	private String toAirportName;


	private String fromRegion;

	private String toRegion;

}
