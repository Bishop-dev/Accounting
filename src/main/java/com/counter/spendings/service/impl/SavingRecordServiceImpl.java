package com.counter.spendings.service.impl;

import com.counter.spendings.entity.api.SavingRecordApi;
import com.counter.spendings.entity.dal.SavingRecordDal;
import com.counter.spendings.repository.SavingRecordRepository;
import com.counter.spendings.service.SavingRecordService;
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
import java.util.List;

/**
 * Created by Sashko on 9/10/16.
 */
@Service
@Transactional(value = Transactional.TxType.REQUIRED)
public class SavingRecordServiceImpl implements SavingRecordService {

    @Autowired
    private SavingRecordRepository savingRecordRepository;

    @Override
    public List<SavingRecordApi> total(final long userId) {
        final List<SavingRecordDal> dalList = savingRecordRepository.total(userId);
        return DalToApiTransformer.toApi(dalList, DalToApiTransformer::toApi);
    }

    @Override
    public void delete(final long id) {
        savingRecordRepository.delete(id);
    }

    @Override
    public PagedResult<SavingRecordApi> list(final PageableRequest request, final long userId) {
        final PageRequest pageable = new PageRequest(request.getPageNumber(), request.getPageSize());
        final Page<SavingRecordDal> pageableResult =
                savingRecordRepository.findAllByUserIdAndDateBetweenOrderByDateDesc(pageable, userId,
                        request.getStart(), request.getFinish());
        return PageableTransformer.toPagedResult(pageableResult, DalToApiTransformer::toApi);
    }

    @Override
    public SavingRecordApi save(final SavingRecordApi savingRecordApi) {
        final SavingRecordDal dal = ApiToDalTransformer.toDal(savingRecordApi);
        final SavingRecordDal savedDal = savingRecordRepository.save(dal);
        return DalToApiTransformer.toApi(savedDal);
    }

}
