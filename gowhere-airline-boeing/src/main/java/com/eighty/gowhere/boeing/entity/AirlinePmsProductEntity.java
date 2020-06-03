package com.eighty.gowhere.boeing.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import lombok.Data;

/**
 * product
 * 
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:48:45
 */
@Data
@TableName("airline_pms_product")
public class AirlinePmsProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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

}
