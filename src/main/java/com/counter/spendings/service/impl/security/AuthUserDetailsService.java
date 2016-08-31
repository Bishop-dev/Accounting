package com.counter.spendings.service.impl.security;

import com.counter.spendings.entity.dal.UserDal;
import com.counter.spendings.entity.security.SecurityUser;
import com.counter.spendings.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Sashko on 8/31/16.
 */
@Service(value = "userDetailsService")
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDal userDal = userRepository.getByLogin(login);
        return convert(userDal);
    }

    private UserDetails convert(UserDal userDal) {
        SecurityUser user = new SecurityUser();
        user.setLogin(userDal.getLogin());
        user.setPassword(userDal.getPassword());
        user.setRoles(Arrays.asList(new SimpleGrantedAuthority("USER")));
        return user;
    }

}
