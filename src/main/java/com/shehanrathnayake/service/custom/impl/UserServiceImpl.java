package com.shehanrathnayake.service.custom.impl;

import com.shehanrathnayake.converter.IdConverter;
import com.shehanrathnayake.entity.User;
import com.shehanrathnayake.exception.AppException;
import com.shehanrathnayake.repository.UserRepository;
import com.shehanrathnayake.service.custom.UserService;
import com.shehanrathnayake.service.util.UserTransformer;
import com.shehanrathnayake.to.UserTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserTransformer userTransformer;
    private final IdConverter idConverter;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserTransformer userTransformer, IdConverter idConverter, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userTransformer = userTransformer;
        this.idConverter = idConverter;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserTO saveUser(UserTO userTo) {
        userTo.setPassword(passwordEncoder.encode(userTo.getPassword()));
        User savedUser = userRepository.save(userTransformer.fromUserTO(userTo));
        return userTransformer.toUserTO(savedUser);
    }

    @Override
    public void updateUser(UserTO userTo) {
        userRepository.findById(idConverter.convertUserIdToInt(userTo.getId())).orElseThrow(()-> new AppException(404, "User not registered"));
        userRepository.save(userTransformer.fromUserTO(userTo));
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.findById(idConverter.convertUserIdToInt(userId)).orElseThrow(()-> new AppException(404, "User not registered"));
        userRepository.deleteById(idConverter.convertUserIdToInt(userId));
    }

    @Override
    public UserTO getUserDetails(String userId) {
        User targetUser = userRepository.findById(idConverter.convertUserIdToInt(userId)).orElseThrow(() -> new AppException(404, "User not registered"));
        return userTransformer.toUserTO(targetUser);
    }

    @Override
    public List<UserTO> getUserList() {
        return userTransformer.toUserTOList(userRepository.findAll());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User loggedUser = userRepository.findById(idConverter.convertUserIdToInt(username)).orElseThrow(() -> new AppException(404, "User not found"));
        return userTransformer.FromUserToUserDetails(loggedUser);
    }
}
