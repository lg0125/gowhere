package com.eighty.gowhere.amazon.entity;

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
 * @author chris
 * @email 1737783319@qq.com
 * @date 2020-06-04 09:29:50
 */
@Data
@TableName("web_oms_order_item")
public class WebOmsOrderItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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
