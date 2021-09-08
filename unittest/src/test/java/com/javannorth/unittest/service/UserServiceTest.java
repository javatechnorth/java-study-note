package com.javannorth.unittest.service;

import com.javannorth.unittest.dto.User;
//import com.javannorth.unittest.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith({MockitoExtension.class})
class UserServiceTest {

    UserService userService;

//    @Mock
//    UserRepository userRepository;

//    @BeforeEach
//    void setUp() {
//        userService = new UserServiceImpl(userRepository);
//    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveUser() {
    }

//    @Test
    void retrieveUserById() throws Exception {
        User user1 = new User("javaNorth","100","指北君");
//        when(userRepository.findById(anyString())).thenReturn(Optional.of(user1));
        User user = userService.retrieveUserById("100");
        assertThat(user1).isEqualTo(user);
    }
}