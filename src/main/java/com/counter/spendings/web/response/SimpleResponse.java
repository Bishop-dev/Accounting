package com.counter.spendings.web.response;

/**
 * Created by Sashko on 8/28/16.
 */
public class SimpleResponse<T> {

    private final T result;

    public SimpleResponse(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public static <T> SimpleResponse<T> create(T result) {
        return new SimpleResponse<>(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleResponse that = (SimpleResponse) o;
        return result == null ? that.result == null : result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return result != null ? result.hashCode() : 0;
    }

}
