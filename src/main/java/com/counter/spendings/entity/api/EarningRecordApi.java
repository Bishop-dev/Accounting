package com.counter.spendings.entity.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Sashko on 9/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EarningRecordApi {

    private static final String DATETIME_FORMAT = "MM/dd/yyyy";

    private long id;
    private String currency;
    private double amount;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = DATETIME_FORMAT)
    private Date date;
    private long userId;

    public EarningRecordApi() {
    }

    private EarningRecordApi(final long id, final String currency, final double amount,
                             final Date date, final long userId) {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
        this.date = date;
        this.userId = userId;
    }

    public static EarningRecordApi create(final long id, final String currency,
                                          final double amount, final Date date, final long userId) {
        return new EarningRecordApi(id, currency, amount, date, userId);
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }
}
