package com.javannorth.unittest.repository;

import com.javannorth.unittest.dto.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@DataJpaTest
class UserRepositoryTest {

//    @Autowired
//    UserRepository userRepository;

    @BeforeEach
    void setUp() {    }

    @AfterEach
    void tearDown() {    }

    @Test
    public void findByUserIdReturnUser() {
        User user1 = new User("javaNorth","100","指北君");
//        Optional<User> userOptional = userRepository.findById("100");
//        assertThat(user1).isEqualTo(userOptional.get());
    }

}