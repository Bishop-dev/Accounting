package com.counter.spendings.repository;

import com.counter.spendings.entity.dal.EarningRecordDal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * Created by Sashko on 9/10/16.
 */
public interface EarningRecordRepository extends CrudRepository<EarningRecordDal, Long> {

    Page<EarningRecordDal> findAllByUserIdAndDateBetweenOrderByDateDesc(Pageable pageable,
                                                                        long userId, Date start, Date finish);

}
