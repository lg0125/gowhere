package com.eighty.gowhere.boeing.vo;

import com.eighty.gowhere.boeing.entity.AirlinePmsOrderInfoEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDrawVo implements Serializable {

    private static final long serialVersionUID = 1L;

    WebOmsOrderVo webOmsOrderVo;

    WebOmsOrderItemVo webOmsOrderItemVo;

    AirlinePmsOrderInfoEntity airlinePmsOrderInfoEntity;

}
