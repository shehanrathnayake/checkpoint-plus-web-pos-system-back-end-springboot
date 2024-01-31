package com.shehanrathnayake.service.custom;

import com.shehanrathnayake.service.SuperService;
import com.shehanrathnayake.to.UserTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends SuperService, UserDetailsService {
    UserTO saveUser(UserTO userTo);
    void updateUser(UserTO userTo);
    void deleteUserById(String userId);
    UserTO getUserDetails(String userId);
    List<UserTO> getUserList();
}
