package com.counter.spendings.web.response;

import java.util.List;

/**
 * Created by Sashko on 8/29/16.
 */
public class PagedResult <T> {

    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long total;

    public PagedResult(List<T> content, int pageNumber, int pageSize, long total) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
    }

    public List<T> getContent() {
        return content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getTotal() {
        return total;
    }

}
