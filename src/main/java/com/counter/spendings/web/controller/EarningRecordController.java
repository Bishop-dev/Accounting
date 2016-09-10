package com.counter.spendings.web.controller;

import com.counter.spendings.entity.api.EarningRecordApi;
import com.counter.spendings.service.EarningRecordService;
import com.counter.spendings.web.request.PageableRequest;
import com.counter.spendings.web.response.PagedResult;
import com.counter.spendings.web.response.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Sashko on 9/10/16.
 */
@Controller
@RequestMapping("/earning")
public class EarningRecordController {

    @Autowired
    private EarningRecordService earningRecordService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public SimpleResponse<PagedResult<EarningRecordApi>> list(PageableRequest pageRequest) {
        final long userId = 1L;
        return SimpleResponse.create(earningRecordService.list(pageRequest, userId));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public SimpleResponse<Boolean> delete(@RequestParam("id") long id) {
        try {
            earningRecordService.delete(id);
            return SimpleResponse.create(true);
        } catch (Exception e) {
            return SimpleResponse.create(false);
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public SimpleResponse<EarningRecordApi> save(@RequestBody EarningRecordApi recordApi) {
        return SimpleResponse.create(earningRecordService.save(recordApi));
    }

}
