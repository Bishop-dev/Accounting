package com.counter.spendings.repository;

import com.counter.spendings.entity.dal.SpendingRecordDal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * Created by Sashko on 8/28/16.
 */
public interface SpendingRecordRepository extends CrudRepository<SpendingRecordDal, Long> {

    Page<SpendingRecordDal> findAllByUserIdAndDateBetweenOrderByDateDesc(Pageable page, long userId, Date start, Date end);

}
