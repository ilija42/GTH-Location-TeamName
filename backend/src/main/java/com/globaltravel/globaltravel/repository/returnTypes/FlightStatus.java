package com.globaltravel.globaltravel.repository.returnTypes;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FlightStatus {

    private String flightCode;

    private String fromLocation;
    private String toLocation;

    private Date departureTime;
    private Date arrivalTimve;


    private String plane;

    private String timeToArriveHours;
    private String timeToArriveMinutes;

    public FlightStatus() {
    }

    public void calculateTimeToArrive() {

        long diffInMillies = Math.abs(arrivalTimve.getTime() - departureTime.getTime());

        long hours = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        long minutes = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS) % hours;

        timeToArriveHours = Long.toString(hours);
        timeToArriveMinutes = Long.toString(minutes);


    }


    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
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

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getTimeToArriveHours() {
        return timeToArriveHours;
    }

    public void setTimeToArriveHours(String timeToArriveHours) {
        this.timeToArriveHours = timeToArriveHours;
    }

    public String getTimeToArriveMinutes() {
        return timeToArriveMinutes;
    }

    public void setTimeToArriveMinutes(String timeToArriveMinutes) {
        this.timeToArriveMinutes = timeToArriveMinutes;
    }
}
