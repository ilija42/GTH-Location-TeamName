package com.globaltravel.globaltravel.controller;

import com.globaltravel.globaltravel.services.DefaultLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private DefaultLoginService defaultLoginService;

    @PostMapping
    public Object login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        return defaultLoginService.login(username, password);
    }




}
