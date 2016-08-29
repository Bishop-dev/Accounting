package com.counter.spendings.entity.api;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Sashko on 8/27/16.
 */
public class SpendingRecordApi {

    private BigDecimal price;
    private Date date;
    private String title;
    private String currency;
    private long userId;

    public SpendingRecordApi() {
    }

    private SpendingRecordApi(BigDecimal price, Date date, String title, String currency,
                              long userId) {
        this.price = price;
        this.date = date;
        this.title = title;
        this.currency = currency;
        this.userId = userId;
    }

    public static SpendingRecordApi create(BigDecimal price, Date date, String title, String currency,
                                           long userId) {
        return new SpendingRecordApi(price, date, title, currency, userId);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
