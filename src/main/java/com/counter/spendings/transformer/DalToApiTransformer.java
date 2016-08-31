package com.counter.spendings.transformer;

import com.counter.spendings.entity.api.SpendingRecordApi;
import com.counter.spendings.entity.dal.SpendingRecordDal;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Sashko on 8/28/16.
 */
public class DalToApiTransformer {

    public static SpendingRecordApi toApi(SpendingRecordDal dal) {
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

    public static List<SpendingRecordApi> toApi(Collection<SpendingRecordDal> dalCollection) {
        if (CollectionUtils.isEmpty(dalCollection)) {
            return Collections.emptyList();
        }
        return dalCollection.stream().map(DalToApiTransformer::toApi).collect(toList());
    }

}
