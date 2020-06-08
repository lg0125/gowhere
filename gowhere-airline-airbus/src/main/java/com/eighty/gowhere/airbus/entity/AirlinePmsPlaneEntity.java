package com.eighty.gowhere.airbus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @date 2020-06-02 10:54:24
 */
@Data
@TableName("airline_pms_plane")
public class AirlinePmsPlaneEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.ASSIGN_ID)
	private String planeId;
	/**
	 * 
	 */
	private String size;
	/**
	 * 
	 */
	private Integer deleted;

}
