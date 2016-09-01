package com.counter.spendings.service.impl;

import com.counter.spendings.entity.api.statistics.WeekChartApi;
import com.counter.spendings.repository.StatisticsRepository;
import com.counter.spendings.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<WeekChartApi> weekChart() {
        Date start = calculateMinusOneWeek();
        Date finish = new Date();
        List<WeekChartApi> weekChartApis = statisticsRepository.fetchChart(start, finish);
        if (weekChartApis.size() > 7) {
            throw new RuntimeException("THE SIZE OF WEEK CHART IS " + weekChartApis.size());
        }
        return weekChartApis;
    }

    private Date calculateMinusOneWeek() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -7);
        return c.getTime();
    }

}
