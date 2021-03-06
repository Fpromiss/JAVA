package com.miaoshaproject.service.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Date;

public class PromoModel {

    private Integer id;

    // 秒杀活动名称
    private String promoName;

    // 秒杀活动的开始时间
    private DateTime startDate;

    // 秒杀活动结束时间
    private DateTime endDate;

    // 秒杀活动适用商品
    private Integer itemId;

    // 秒杀活动的商品价格
    private BigDecimal promoItemPrice;

    // 秒杀活动状态，为1表示还未开始，为2表示进行中，为3表示已经结束
    private Integer statues;

    public Integer getStatues() {
        return statues;
    }

    public void setStatues(Integer statues) {
        this.statues = statues;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPromoItemPrice() {
        return promoItemPrice;
    }

    public void setPromoItemPrice(BigDecimal promoItemPrice) {
        this.promoItemPrice = promoItemPrice;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }
}
