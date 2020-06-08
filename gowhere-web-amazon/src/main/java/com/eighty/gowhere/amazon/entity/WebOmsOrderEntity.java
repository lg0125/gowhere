package com.eighty.gowhere.amazon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * order
 * 
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:58:18
 */
@Data
@TableName("web_oms_order")
public class WebOmsOrderEntity implements Serializable {
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

	private String airlineName;

}
