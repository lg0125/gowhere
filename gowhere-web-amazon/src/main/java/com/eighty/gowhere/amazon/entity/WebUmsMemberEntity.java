package com.eighty.gowhere.amazon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * ums_member
 * 
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 10:58:18
 */

@Data
@TableName("web_ums_member")
public class WebUmsMemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
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
	private String memberPassword;
	/**
	 * 
	 */
	private Long cardId;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Integer deleted;

}
