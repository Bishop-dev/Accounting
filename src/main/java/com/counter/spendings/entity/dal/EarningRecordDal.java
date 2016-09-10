package com.counter.spendings.entity.dal;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Sashko on 9/10/16.
 */
@Entity
@Table(name = "earning")
public class EarningRecordDal extends AbstractPersistable<Long> {

    private double amount;
    private String currency;
    private long userId;
    private Date date;

    private EarningRecordDal(final long id, final double amount, final String currency,
                            final long userId, final Date date) {
        setId(id);
        this.amount = amount;
        this.currency = currency;
        this.userId = userId;
        this.date = date;
    }

    public EarningRecordDal() {
    }

    public static EarningRecordDal create(final long id, final double amount, final String currency,
                                          final long userId, final Date date) {
        return new EarningRecordDal(id, amount, currency, userId, date);
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

}
