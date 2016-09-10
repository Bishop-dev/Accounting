package com.counter.spendings.entity.dal;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Sashko on 9/10/16.
 */
@Entity
@Table(name = "saving")
public class SavingRecordDal extends AbstractPersistable<Long> {

    private double amount;
    private String currency;
    private Date date;
    private String type;
    private long userId;

    public SavingRecordDal() {
    }

    public SavingRecordDal(final double amount, final String currency, final String type) {
        this.amount = amount;
        this.currency = currency;
        this.type = type;
    }

    private SavingRecordDal(final long id, final double amount, final String currency,
                            final Date date, final String type, final long userId) {
        setId(id);
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.type = type;
        this.userId = userId;
    }

    public static SavingRecordDal create(final long id, final double amount,
                                         final String currency, final Date date,
                                         final String type, final long userId) {
        return new SavingRecordDal(id, amount, currency, date, type, userId);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }
}
