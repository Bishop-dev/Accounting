package com.counter.spendings.entity.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Sashko on 9/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SavingRecordApi {

    private static final String DATETIME_FORMAT = "MM/dd/yyyy";

    private long id;
    private double amount;
    private String currency;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = DATETIME_FORMAT)
    private Date date;
    private String type;
    private long userId;

    public SavingRecordApi() {
    }

    private SavingRecordApi(final long id, final double amount, final String currency,
                            final Date date, final String type, final long userId) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.type = type;
        this.userId = userId;
    }

    public static SavingRecordApi create(final long id, final double amount, final String currency,
                                         final Date date, final String type, final long userId) {
        return new SavingRecordApi(id, amount, currency, date, type, userId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }
}
