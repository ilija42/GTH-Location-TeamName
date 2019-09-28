package com.globaltravel.globaltravel.repository.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Flight")
public class Flight {

    @Id
    private String flightCode;

    private String fromLocation;
    private String toLocation;

    private Date departureTime;
    private Date arrivalTimve;


    private String plane;

    private int delayTime = 0;

    public Flight() {

    }


    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTimve() {
        return arrivalTimve;
    }

    public void setArrivalTimve(Date arrivalTimve) {
        this.arrivalTimve = arrivalTimve;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public int getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }
}
