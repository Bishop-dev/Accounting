package com.counter.spendings.transformer;

import com.counter.spendings.entity.api.EarningRecordApi;
import com.counter.spendings.entity.api.SavingRecordApi;
import com.counter.spendings.entity.api.SpendingRecordApi;
import com.counter.spendings.entity.dal.EarningRecordDal;
import com.counter.spendings.entity.dal.SavingRecordDal;
import com.counter.spendings.entity.dal.SpendingRecordDal;

/**
 * Created by Sashko on 8/29/16.
 */
public class ApiToDalTransformer {

    public static SpendingRecordDal toDal(final SpendingRecordApi api) {
        if (api == null) {
            return null;
        }
        return SpendingRecordDal.create(api.getId(), api.getPrice(), api.getDate(), api.getTitle(),
                api.getCurrency(), api.getUserId());
    }

    public static SavingRecordDal toDal(final SavingRecordApi api) {
        if (api == null) {
            return null;
        }
        return SavingRecordDal.create(api.getId(), api.getAmount(), api.getCurrency(),
                api.getDate(), api.getType(), api.getUserId());
    }

    public static EarningRecordDal toDal(final EarningRecordApi api) {
        if (api == null) {
            return null;
        }
        return EarningRecordDal.create(api.getId(), api.getAmount(), api.getCurrency(),
                api.getUserId(), api.getDate());
    }
}
