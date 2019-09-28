package com.globaltravel.globaltravel.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "FlightAndUsers")
public class FlightAndUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightAndUsersId;

    private String flightCode;

    private Long userId;

    public FlightAndUsers() {}

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
