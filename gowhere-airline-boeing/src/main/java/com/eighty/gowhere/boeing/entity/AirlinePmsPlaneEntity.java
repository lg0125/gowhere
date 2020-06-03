package com.eighty.gowhere.boeing.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:48:45
 */
@Data
@TableName("airline_pms_plane")
public class AirlinePmsPlaneEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String planeId;
	/**
	 * 
	 */
	private String size;
	/**
	 * 
	 */
	private Integer status;

}
