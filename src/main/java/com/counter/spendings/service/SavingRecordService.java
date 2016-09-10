package com.counter.spendings.service;

import com.counter.spendings.entity.api.SavingRecordApi;
import com.counter.spendings.web.request.PageableRequest;
import com.counter.spendings.web.response.PagedResult;

import java.util.List;

/**
 * Created by Sashko on 9/10/16.
 */
public interface SavingRecordService {

    List<SavingRecordApi> total();

    void delete(long id);

    PagedResult<SavingRecordApi> list(PageableRequest request, long userId);

    SavingRecordApi save(SavingRecordApi savingRecordApi);

}
