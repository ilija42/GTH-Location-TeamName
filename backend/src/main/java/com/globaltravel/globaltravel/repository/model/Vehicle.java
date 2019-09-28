package com.globaltravel.globaltravel.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    private String vehicleRegNumber;

    private String vehicleType;

    private float lon;

    private float lat;

    private int sittingSpace;

    private int packageSize; //Velicina gepeka

    private boolean childSeat;

    public Vehicle() {}

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public int getSittingSpace() {
        return sittingSpace;
    }

    public void setSittingSpace(int sittingSpace) {
        this.sittingSpace = sittingSpace;
    }

    public int getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(int packageSize) {
        this.packageSize = packageSize;
    }

    public boolean isChildSeat() {
        return childSeat;
    }

    public void setChildSeat(boolean childSeat) {
        this.childSeat = childSeat;
    }
}
