package com.javannorth.unittest.service;

import com.javannorth.unittest.aop.AOPTest;
import com.javannorth.unittest.dto.User;

public interface UserService {
    public void saveUser ();


    public User retrieveUserById(String userId) throws Exception;
}
