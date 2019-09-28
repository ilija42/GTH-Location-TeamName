package com.globaltravel.globaltravel.repository.returnTypes;

public class VehicleCreationStatus {

    private String method = "vehicleCreation";

    private boolean vehicleCreated;
    private String description;

    public VehicleCreationStatus() {
    }

    public boolean isVehicleCreated() {
        return vehicleCreated;
    }

    public void setVehicleCreated(boolean vehicleCreated) {
        this.vehicleCreated = vehicleCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
