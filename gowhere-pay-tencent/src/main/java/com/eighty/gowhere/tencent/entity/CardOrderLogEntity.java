package com.eighty.gowhere.tencent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @date 2020-06-02 10:40:56
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

}
