package com.counter.spendings.service;

import com.counter.spendings.entity.api.statistics.WeekChartApi;

import java.util.List;

/**
 * Created by Sashko on 9/1/16.
 */
public interface StatisticsService {

    List<WeekChartApi> weekChart();

}
