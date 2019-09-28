package com.globaltravel.globaltravel.services;

import com.globaltravel.globaltravel.repository.returnTypes.LoginStatus;

public interface BaseLoginService {

    LoginStatus login(String username, String password);

}
