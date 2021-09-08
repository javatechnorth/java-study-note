package com.javannorth.unittest.controller;

import com.javannorth.unittest.aop.AOPTest;
import com.javannorth.unittest.dto.User;
import com.javannorth.unittest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/javanorth/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @AOPTest
    @GetMapping("/{userId}")
    public ResponseEntity<User> retrieveUserByUserId(@PathVariable String userId) throws Exception {
        User user = userService.retrieveUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @AOPTest
    @GetMapping("/normal/{userId}")
    public ResponseEntity<String> normalReturn(@PathVariable String userId)  {
        System.out.println(" get the value ,return soon ...");
        return new ResponseEntity<>("normal return",HttpStatus.OK);
    }
}
