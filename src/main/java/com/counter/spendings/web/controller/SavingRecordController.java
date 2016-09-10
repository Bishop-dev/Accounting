package com.counter.spendings.web.controller;

import com.counter.spendings.entity.api.SavingRecordApi;
import com.counter.spendings.service.SavingRecordService;
import com.counter.spendings.web.request.PageableRequest;
import com.counter.spendings.web.response.PagedResult;
import com.counter.spendings.web.response.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * Created by Sashko on 9/10/16.
 */
@Controller
@RequestMapping("/savings")
public class SavingRecordController {

    @Autowired
    private SavingRecordService savingRecordService;

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public SimpleResponse<Collection<SavingRecordApi>> getTotalSavings() {
        final long userId = 1;
        return SimpleResponse.create(savingRecordService.total(userId));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public SimpleResponse<PagedResult<SavingRecordApi>> list(PageableRequest pageRequest) {
        final long userId = 1;
        return SimpleResponse.create(savingRecordService.list(pageRequest, userId));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public SimpleResponse<Boolean> delete(@RequestParam("id") long id) {
        try {
            savingRecordService.delete(id);
            return SimpleResponse.create(true);
        } catch (Exception e) {
            return SimpleResponse.create(false);
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResponse<SavingRecordApi> save(@RequestBody SavingRecordApi api) {
        return SimpleResponse.create(savingRecordService.save(api));
    }

}
