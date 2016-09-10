package com.counter.spendings.transformer;

import com.counter.spendings.entity.api.EarningRecordApi;
import com.counter.spendings.entity.api.SavingRecordApi;
import com.counter.spendings.entity.api.SpendingRecordApi;
import com.counter.spendings.entity.dal.EarningRecordDal;
import com.counter.spendings.entity.dal.SavingRecordDal;
import com.counter.spendings.entity.dal.SpendingRecordDal;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * Created by Sashko on 8/28/16.
 */
public class DalToApiTransformer {

    public static SpendingRecordApi toApi(final SpendingRecordDal dal) {
        if (dal == null) {
            return null;
        }
        return SpendingRecordApi.create(
                dal.getId(),
                dal.getPrice(),
                dal.getDate(),
                dal.getTitle(),
                dal.getCurrency(),
                dal.getUserId()
        );
    }

    public static SavingRecordApi toApi(final SavingRecordDal dal) {
        if (dal == null) {
            return null;
        }
        return SavingRecordApi.create(dal.getId(), dal.getAmount(), dal.getCurrency(),
                dal.getDate(), dal.getType(), dal.getUserId());
    }

    public static <T> List toApi(final Collection<T> dalCollection,
                                 final Function<? super T, ?> function) {
        if (CollectionUtils.isEmpty(dalCollection)) {
            return Collections.emptyList();
        }
        return dalCollection.stream().map(function).collect(toList());
    }

    public static EarningRecordApi toApi(final EarningRecordDal dal) {
        if (dal == null) {
            return null;
        }
        return EarningRecordApi.create(dal.getId(), dal.getCurrency(), dal.getAmount(),
                dal.getDate(), dal.getUserId());
    }

}
