package com.globaltravel.globaltravel.repository.returnTypes;

import java.util.List;

public class RouteStatus {

    private String method = "creatingRoute";

    private String response;

    public RouteStatus() {}

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
