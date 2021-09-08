package com.javannorth.unittest.service;

import com.javannorth.unittest.aop.AOPTest;
import com.javannorth.unittest.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

//    private UserRepository userRepository;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    @Override
    public void saveUser() {

    }

    @Override
    public User retrieveUserById(String userId) throws Exception {
        validateUserInfo(userId);
//        Optional<User> byId = userRepository.findById(userId);
//        return byId.get();
        User user1 = retrieveUser();
        throw new Exception("test exception");
//        return user1;

    }

    @AOPTest
    public User retrieveUser() {
        return new User("javaNorth","100","指北君");
    }

    private void validateUserInfo(String userId) {
//        System.out.println(" validate the use info ");
    }
}
