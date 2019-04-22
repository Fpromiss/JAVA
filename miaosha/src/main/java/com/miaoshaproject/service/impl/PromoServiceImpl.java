package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.PromoDOMapper;
import com.miaoshaproject.dataobject.PromoDO;
import com.miaoshaproject.service.PromoService;
import com.miaoshaproject.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoDOMapper promoDOMapper;

    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        // 获取对应商品的秒杀信息
        PromoDO promoDO = promoDOMapper.selectByItemId(itemId);

        // dataobject -> model
        PromoModel promoModel = this.convertFromDataObject(promoDO);
        if(promoModel == null){
            return null;
        }

        // 判断当前时间，秒杀活动即将开始或正在进行
        DateTime now = new DateTime();
        // 还未开始
        if(promoModel.getStartDate().isAfterNow()){
            promoModel.setStatues(1);
        }
        // 已经结束
        else if(promoModel.getEndDate().isBeforeNow()){
            promoModel.setStatues(3);
        }
        else{
            promoModel.setStatues(2);
        }

        return null;
    }


    /**
     * promoDO -> promo model
     *
     * @param promoDO
     * @return
     */
    private PromoModel convertFromDataObject(PromoDO promoDO){
        if(promoDO == null){
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO, promoModel);
        promoModel.setPromoItemPrice(new BigDecimal(promoDO.getPromoItemPrice()));
        promoModel.setStartDate(new DateTime(promoDO.getStartDate()));
        promoModel.setEndDate(new DateTime(promoDO.getEndDate()));
        return promoModel;
    }
}
