package com.counter.spendings.web.controller;

import com.counter.spendings.entity.api.SpendingRecordApi;
import com.counter.spendings.service.SpendingRecordService;
import com.counter.spendings.web.request.PageableRequest;
import com.counter.spendings.web.response.PagedResult;
import com.counter.spendings.web.response.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Sashko on 8/27/16.
 */
@Controller
@RequestMapping("/spending")
@ResponseBody
public class SpendingRecordController {

    @Autowired
    private SpendingRecordService spendingRecordService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public SimpleResponse<PagedResult<SpendingRecordApi>> list(PageableRequest pageRequest) {
        long userId = 1;
        return new SimpleResponse<>(spendingRecordService.list(pageRequest, userId));
    }

}
