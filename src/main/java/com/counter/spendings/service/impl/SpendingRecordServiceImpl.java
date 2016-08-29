package com.counter.spendings.service.impl;

import com.counter.spendings.entity.api.SpendingRecordApi;
import com.counter.spendings.entity.dal.SpendingRecordDal;
import com.counter.spendings.repository.SpendingRecordRepository;
import com.counter.spendings.service.SpendingRecordService;
import com.counter.spendings.transformer.ApiToDalTransformer;
import com.counter.spendings.transformer.DalToApiTransformer;
import com.counter.spendings.transformer.PageableTransformer;
import com.counter.spendings.web.request.PageableRequest;
import com.counter.spendings.web.response.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Sashko on 8/28/16.
 */
@Service
@Transactional(value = Transactional.TxType.REQUIRED)
public class SpendingRecordServiceImpl implements SpendingRecordService {

    @Autowired
    private SpendingRecordRepository spendingRecordRepository;

    @Override
    public PagedResult<SpendingRecordApi> list(PageableRequest request, long userId) {
        PageRequest pageable = new PageRequest(request.getPageNumber(), request.getPageSize());
        Page<SpendingRecordDal> pageableResult = spendingRecordRepository.findAllByUserIdAndDateBetween(pageable, userId,
                request.getStart(), request.getFinish());
        return PageableTransformer.toPagedResult(pageableResult, DalToApiTransformer::toApi);
    }

    @Override
    public SpendingRecordApi save(SpendingRecordApi record) {
        SpendingRecordDal dal = spendingRecordRepository.save(ApiToDalTransformer.toDal(record));
        return DalToApiTransformer.toApi(dal);
    }

    @Override
    public void delete(long recordId) {
        spendingRecordRepository.delete(recordId);
    }

}
