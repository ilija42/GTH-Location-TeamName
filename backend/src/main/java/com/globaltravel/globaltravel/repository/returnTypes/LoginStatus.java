package com.globaltravel.globaltravel.repository.returnTypes;

public class LoginStatus {

    private String method = "login";
    private boolean loginStatus;
    private String token;

    public LoginStatus() {
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
