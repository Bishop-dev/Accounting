package com.counter.spendings.entity.dal;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Sashko on 8/27/16.
 */
@Entity
@Table(name = "currency")
public class CurrencyDal extends AbstractPersistable<Long> {

    private String acronim;
    private String country;
    private String name;

    public String getAcronim() {
        return acronim;
    }

    public void setAcronim(String acronim) {
        this.acronim = acronim;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
