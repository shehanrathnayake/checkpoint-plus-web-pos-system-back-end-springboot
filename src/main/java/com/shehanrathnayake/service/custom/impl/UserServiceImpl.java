package com.shehanrathnayake.service.custom.impl;

import com.shehanrathnayake.converter.IdConverter;
import com.shehanrathnayake.entity.User;
import com.shehanrathnayake.exception.AppException;
import com.shehanrathnayake.repository.UserRepository;
import com.shehanrathnayake.service.custom.UserService;
import com.shehanrathnayake.service.util.UserTransformer;
import com.shehanrathnayake.to.UserTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserTransformer userTransformer;
    private IdConverter idConverter;
    private UserRepository userRepository;

    public UserServiceImpl(UserTransformer userTransformer, IdConverter idConverter, UserRepository userRepository) {
        this.userTransformer = userTransformer;
        this.idConverter = idConverter;
        this.userRepository = userRepository;
    }

    @Override
    public UserTO saveUser(UserTO userTo) {
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
}
