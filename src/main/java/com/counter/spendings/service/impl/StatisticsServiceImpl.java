package com.counter.spendings.service.impl;

import com.counter.spendings.entity.api.statistics.DailyChartApi;
import com.counter.spendings.repository.StatisticsRepository;
import com.counter.spendings.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Sashko on 9/1/16.
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public List<DailyChartApi> weekChart() {
        final Date start = calculateMinusOneWeek();
        final Date finish = new Date();
        final List<DailyChartApi> weekChartApis = statisticsRepository.fetchChart(start, finish);
        return weekChartApis;
    }

    private Date calculateMinusOneWeek() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -7);
        return c.getTime();
    }

}
