package com.eighty.gowhere.airbus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * airport_region
 * 
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:54:24
 */
@Data
@TableName("airline_pms_airport_region")
public class AirlinePmsAirportRegionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long airportId;
	/**
	 * 
	 */
	private Long regionId;
	/**
	 * 
	 */
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	/**
	 * 
	 */
	private Integer deleted;
	/**
	 * 
	 */
	private String airportName;
	/**
	 * 
	 */
	private String regionName;

}
