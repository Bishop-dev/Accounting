package com.counter.spendings.web.request;

import java.util.Date;

/**
 * Created by Sashko on 8/28/16.
 */
public class PageableRequest {

    private int pageSize;
    private int total;
    private int pageNumber;
    private Date start;
    private Date finish;
    private boolean asc;
    private String sortField;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public boolean isAsc() {
        return this.asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

}
