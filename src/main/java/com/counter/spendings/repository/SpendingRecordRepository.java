package com.counter.spendings.repository;

import com.counter.spendings.entity.dal.SpendingRecordDal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by Sashko on 8/28/16.
 */
@Repository
public interface SpendingRecordRepository extends CrudRepository<SpendingRecordDal, Long> {

    Page<SpendingRecordDal> findAllByUserIdAndByDateBetween(PageRequest page, long userId, Date start, Date end);

}
