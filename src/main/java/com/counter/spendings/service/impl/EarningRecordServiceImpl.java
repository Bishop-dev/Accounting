package com.counter.spendings.service.impl;

import com.counter.spendings.entity.api.EarningRecordApi;
import com.counter.spendings.entity.dal.EarningRecordDal;
import com.counter.spendings.entity.dal.SavingRecordDal;
import com.counter.spendings.repository.EarningRecordRepository;
import com.counter.spendings.service.EarningRecordService;
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
 * Created by Sashko on 9/10/16.
 */
@Service
@Transactional(value = Transactional.TxType.REQUIRED)
public class EarningRecordServiceImpl implements EarningRecordService {

    @Autowired
    private EarningRecordRepository earningRecordRepository;

    @Override
    public PagedResult<EarningRecordApi> list(final PageableRequest request, final long userId) {
        final PageRequest pageable = new PageRequest(request.getPageNumber(), request.getPageSize());
        final Page<EarningRecordDal> pageableResult =
                earningRecordRepository.findAllByUserIdAndDateBetweenOrderByDateDesc(pageable, userId,
                        request.getStart(), request.getFinish());
        return PageableTransformer.toPagedResult(pageableResult, DalToApiTransformer::toApi);
    }

    @Override
    public void delete(final long id) {
        earningRecordRepository.delete(id);
    }

    @Override
    public EarningRecordApi save(final EarningRecordApi recordApi) {
        final EarningRecordDal dal = earningRecordRepository.save(ApiToDalTransformer.toDal(recordApi));
        return DalToApiTransformer.toApi(dal);
    }


}
