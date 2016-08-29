package com.counter.spendings.transformer;

import com.counter.spendings.entity.api.SpendingRecordApi;
import com.counter.spendings.entity.dal.SpendingRecordDal;

/**
 * Created by Sashko on 8/29/16.
 */
public class ApiToDalTransformer {

    public static SpendingRecordDal toDal(SpendingRecordApi api) {
        if (api == null) {
            return null;
        }
        return SpendingRecordDal.create(api.getPrice(), api.getDate(), api.getTitle(),
                api.getCurrency(), api.getUserId());
    }

}
