package com.counter.spendings.repository;

import com.counter.spendings.entity.dal.UserDal;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sashko on 8/31/16.
 */
public interface UserRepository extends CrudRepository<UserDal, Long> {

    UserDal getByLogin(String login);

}
