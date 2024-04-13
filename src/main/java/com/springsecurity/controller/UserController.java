package com.springsecurity.controller;

import com.springsecurity.entity.UserInfo;
import com.springsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProductService productService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/createUser")
    public String saveUserInfo(@RequestBody UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return productService.saveUserDetail(userInfo);
    }
}
