package com.counter.spendings.repository;

import com.counter.spendings.entity.api.statistics.DailyChartApi;
import com.counter.spendings.entity.dal.SpendingRecordDal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Sashko on 9/1/16.
 */
public interface StatisticsRepository extends CrudRepository<SpendingRecordDal, Long> {

    @Query("select new com.counter.spendings.entity.api.statistics.DailyChartApi(s.date, SUM(s.price)) from " +
            "com.counter.spendings.entity.dal.SpendingRecordDal s WHERE s.date BETWEEN :start AND :finish GROUP BY date " +
            "ORDER BY date DESC")
    List<DailyChartApi> fetchChart(@Param("start") Date start, @Param("finish") Date finish);

}
