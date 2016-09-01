package com.counter.spendings.entity.api.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Sashko on 9/1/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeekChartApi {

    private Date date;
    private double amount;

    public WeekChartApi(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
