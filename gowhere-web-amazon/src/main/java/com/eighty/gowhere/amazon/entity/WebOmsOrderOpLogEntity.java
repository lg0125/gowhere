package com.eighty.gowhere.amazon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * order_op_log
 * 
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:58:18
 */
@Data
@TableName("web_oms_order_op_log")
public class WebOmsOrderOpLogEntity implements Serializable {
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
	private String opRole;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Integer orderStatus;
	/**
	 * 
	 */
	private String note;
	/**
	 * 
	 */
	private Integer deleted;

}
