package com.eighty.gowhere.alibaba.controller;


import com.eighty.gowhere.alibaba.dto.CardDto;
import com.eighty.gowhere.alibaba.entity.CardEntity;
import com.eighty.gowhere.alibaba.entity.CardOrderLogEntity;
import com.eighty.gowhere.alibaba.service.CardOrderLogService;
import com.eighty.gowhere.alibaba.service.CardService;

import com.eighty.gowhere.alibaba.utils.PageUtils;
import com.eighty.gowhere.alibaba.utils.R;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;



/**
 * 
 *
 * @author ChrisRiemann
 * @email z1737783319@outlook.com
 * @date 2020-06-02 09:35:21
 */
@RestController
@RequestMapping("alibaba/card")
@CrossOrigin
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private CardOrderLogService cardOrderLogService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    //TODO
    @PutMapping("/entity/update")
    public R entityUpdate(@RequestBody CardDto cardDto){
        String result = "";

        Long orderId = cardDto.getOrderId();
        Long cardId = cardDto.getCardId();
        String airlineName = cardDto.getAirlineName();
        BigDecimal amount = cardDto.getAmountPay();

        CardEntity cardEntity = cardService.queryByCardId(cardId);
        BigDecimal cardAmount = cardEntity.getAmount();
        BigDecimal subtractResult = cardAmount.subtract(amount);

        if(subtractResult.compareTo(BigDecimal.ZERO) < 0){
            result = "error";
        }else{
            cardEntity.setAmount(subtractResult);
            cardService.saveOrUpdate(cardEntity);

            CardOrderLogEntity cardOrderLogEntity = cardOrderLogService.getByOrderId(orderId);

            Integer OK = 1;
            cardOrderLogEntity.setAmount(amount);
            cardOrderLogEntity.setPayStatus(OK);
            cardOrderLogEntity.setConfirmTime(new Date());
            cardOrderLogService.saveOrUpdate(cardOrderLogEntity);

            result = "success";

            //TODO pay发送给airline
            if(airlineName.equals("airbus")){
                rabbitTemplate.convertAndSend("gowhere-exchange","airbus",orderId);
            }else{
                rabbitTemplate.convertAndSend("gowhere-exchange","boeing",orderId);
            }
        }

        return R.ok().put("result",result);
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("alibaba:card:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cardService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    //@RequiresPermissions("alibaba:card:info")
    public R info(@PathVariable("id") Long id){
		CardEntity card = cardService.getById(id);

        return R.ok().put("card", card);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("alibaba:card:save")
    public R save(@RequestBody CardEntity card){
		cardService.save(card);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    //@RequiresPermissions("alibaba:card:update")
    public R update(@RequestBody CardEntity card){
		cardService.updateById(card);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    //@RequiresPermissions("alibaba:card:delete")
    public R delete(@RequestBody Long[] ids){
		cardService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
