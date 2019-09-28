package com.globaltravel.globaltravel.repository.returnTypes;

import com.globaltravel.globaltravel.repository.model.Flight;

import java.util.ArrayList;

public class AllFlightsStatus {

    private String method = "allFlights";

    private ArrayList<Flight> flights;

    private boolean status;

    public AllFlightsStatus() {flights = new ArrayList<>();}

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
