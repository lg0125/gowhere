package com.eighty.gowhere.alibaba.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * card_order_log
 * 
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 09:35:20
 */
@Data
@TableName("pay_cms_card_order_log")
public class CardOrderLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String orderId;
	/**
	 * 
	 */
	private String payStatus;
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
	private Long payId;

	private String airlineName;

}
