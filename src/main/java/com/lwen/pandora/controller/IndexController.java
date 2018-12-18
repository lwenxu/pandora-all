package com.lwen.pandora.controller;

import com.lwen.pandora.dao.UserRepository;
import com.lwen.pandora.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> user() {
        return userRepository.findAll();
    }
}
