package com.counter.spendings.service;

import com.counter.spendings.entity.api.SpendingRecordApi;
import com.counter.spendings.web.request.PageableRequest;
import com.counter.spendings.web.response.PagedResult;

/**
 * Created by Sashko on 8/28/16.
 */
public interface SpendingRecordService {

    PagedResult<SpendingRecordApi> list(PageableRequest request, long userId);

}
