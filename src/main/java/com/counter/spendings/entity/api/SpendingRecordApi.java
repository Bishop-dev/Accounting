package com.counter.spendings.entity.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Sashko on 8/27/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpendingRecordApi {

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss Z";

    private double price;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = DATETIME_FORMAT)
    private Date date;
    private String title;
    private String currency;
    private long userId;

    public SpendingRecordApi() {
    }

    private SpendingRecordApi(double price, Date date, String title, String currency,
                              long userId) {
        this.price = price;
        this.date = date;
        this.title = title;
        this.currency = currency;
        this.userId = userId;
    }

    public static SpendingRecordApi create(double price, Date date, String title, String currency,
                                           long userId) {
        return new SpendingRecordApi(price, date, title, currency, userId);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
