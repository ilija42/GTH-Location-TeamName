package com.globaltravel.globaltravel.repository.returnTypes;

public class CreateFlightStatus {

    private String method = "createFlight";

    private boolean status;

    private String description;

    public CreateFlightStatus() {}

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
