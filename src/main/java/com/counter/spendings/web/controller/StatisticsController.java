package com.counter.spendings.web.controller;

import com.counter.spendings.entity.api.statistics.WeekChartApi;
import com.counter.spendings.service.StatisticsService;
import com.counter.spendings.web.response.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Sashko on 9/1/16.
 */
@Controller
@RequestMapping("/statistics")
@ResponseBody
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping(value = "/week", method = RequestMethod.GET)
    public SimpleResponse<List<WeekChartApi>> weekChart() {
        return new SimpleResponse<>(statisticsService.weekChart());
    }

}
