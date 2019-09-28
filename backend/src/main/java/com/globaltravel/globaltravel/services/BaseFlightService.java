package com.globaltravel.globaltravel.services;

import com.globaltravel.globaltravel.repository.model.Flight;
import com.globaltravel.globaltravel.repository.returnTypes.AllFlightsStatus;
import com.globaltravel.globaltravel.repository.returnTypes.CreateFlightAndUser;
import com.globaltravel.globaltravel.repository.returnTypes.CreateFlightStatus;

import java.util.List;

public interface BaseFlightService {

    AllFlightsStatus getAllFlightsForUser(Long userId);

    CreateFlightStatus createFlight(String fromLocatio, String toLocation, String departureTime, String arrivalTime,
                                    String flightCode, String plane);

    CreateFlightAndUser createFlightAndUser(String flightCode, Long userId);

}
