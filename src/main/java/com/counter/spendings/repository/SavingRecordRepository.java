package com.counter.spendings.repository;

import com.counter.spendings.entity.dal.SavingRecordDal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Sashko on 9/10/16.
 */
public interface SavingRecordRepository extends CrudRepository<SavingRecordDal, Long> {

    Page<SavingRecordDal> findAllByUserIdAndDateBetweenOrderByDateDesc(Pageable pageable, long userId, Date start,
                                                                       Date finish);

    @Query("SELECT new com.counter.spendings.entity.dal.SavingRecordDal(s.currency, s.type, SUM(s.amount)) " +
            "FROM com.counter.spendings.entity.dal.SavingRecordDal s WHERE s.userId = :userId GROUP BY s.currency, s.type")
    List<SavingRecordDal> total(@Param("userId") long userId);

}
