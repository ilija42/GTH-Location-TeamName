package com.globaltravel.globaltravel.services;

import com.globaltravel.globaltravel.repository.model.User;
import com.globaltravel.globaltravel.repository.returnTypes.UserCreationStatus;

import java.util.List;

public interface BaseUserService {

    UserCreationStatus createUser(String username, String password, String phone, String eMail, String address, String role);

    List<User> getAllUsers();

}
