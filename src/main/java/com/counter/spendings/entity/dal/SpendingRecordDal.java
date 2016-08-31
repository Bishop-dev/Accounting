package com.counter.spendings.entity.dal;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Sashko on 8/27/16.
 */
@Entity
@Table(name = "spending")
public class SpendingRecordDal extends AbstractPersistable<Long> {

    private double price;
    private Date date;
    private String title;
    private String currency;
    private long userId;

    public SpendingRecordDal() {
    }

    private SpendingRecordDal(long id, double price, Date date, String title, String currency,
                              long userId) {
        setId(id);
        this.price = price;
        this.date = date;
        this.title = title;
        this.currency = currency;
        this.userId = userId;
    }

    public static SpendingRecordDal create(long id, double price, Date date, String title, String currency,
                                    long userId) {
        return new SpendingRecordDal(id, price, date, title, currency, userId);
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
