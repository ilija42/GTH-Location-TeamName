package com.globaltravel.globaltravel.controller;


import com.globaltravel.globaltravel.services.DefaultUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private DefaultUserService defaultUserService;

    @PostMapping
    public Object createUser(@RequestParam("username") String username, @RequestParam("password") String password,
                             @RequestParam("phone") String phone, @RequestParam("eMail") String eMail,
                             @RequestParam("address") String address, @RequestParam("role") String role) {
        return defaultUserService.createUser(username, DigestUtils.sha256Hex(password), phone, eMail, address, role);
    }

    @GetMapping
    public Object getUsers() {
        return defaultUserService.getAllUsers();
    }

}
