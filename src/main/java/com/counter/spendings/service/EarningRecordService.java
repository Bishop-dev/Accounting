package com.counter.spendings.service;

import com.counter.spendings.entity.api.EarningRecordApi;
import com.counter.spendings.web.request.PageableRequest;
import com.counter.spendings.web.response.PagedResult;

/**
 * Created by Sashko on 9/10/16.
 */
public interface EarningRecordService {

    PagedResult<EarningRecordApi> list(final PageableRequest request, final long userId);

    void delete(final long id);

    EarningRecordApi save(final EarningRecordApi recordApi);

}
