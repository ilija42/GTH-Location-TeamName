package com.globaltravel.globaltravel.services;

import com.globaltravel.globaltravel.repository.FlightAndUsersRepository;
import com.globaltravel.globaltravel.repository.FlightRepository;
import com.globaltravel.globaltravel.repository.model.Flight;
import com.globaltravel.globaltravel.repository.model.FlightAndUsers;
import com.globaltravel.globaltravel.repository.returnTypes.AllFlightsStatus;
import com.globaltravel.globaltravel.repository.returnTypes.CreateFlightAndUser;
import com.globaltravel.globaltravel.repository.returnTypes.CreateFlightStatus;
import com.globaltravel.globaltravel.repository.returnTypes.FlightStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultFlightService implements BaseFlightService{

    @Autowired
    private FlightAndUsersRepository flightAndUsersRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public AllFlightsStatus getAllFlightsForUser(Long userId) {

        AllFlightsStatus allFlightsStatus = new AllFlightsStatus();



        List<FlightAndUsers> flightAndUsers = flightAndUsersRepository.findAllByUserId(userId);

        if(flightAndUsers.isEmpty()) {
            allFlightsStatus.setStatus(false);
            return allFlightsStatus;
        }


        for(FlightAndUsers fau: flightAndUsers) {
            Optional<Flight> flight = flightRepository.findById(fau.getFlightCode());
            FlightStatus flightStatus = new FlightStatus();

            Flight f = flight.get();

            flightStatus.setFlightCode(f.getFlightCode());
            flightStatus.setFromLocation(f.getFromLocation());
            flightStatus.setToLocation(f.getToLocation());
            flightStatus.setDepartureTime(f.getDepartureTime());
            flightStatus.setArrivalTimve(f.getArrivalTimve());
            flightStatus.setPlane(f.getPlane());
            flightStatus.calculateTimeToArrive();

            allFlightsStatus.getFlights().add(flightStatus);
        }

        allFlightsStatus.setStatus(true);
        return allFlightsStatus;
    }

    @Override
    public CreateFlightStatus createFlight(String fromLocation, String toLocation, String departureTime, String arrivalTime,
                                           String flightCode, String plane) {

        CreateFlightStatus createFlightStatus = new CreateFlightStatus();

        Optional<Flight> existantFlight = flightRepository.findById(flightCode);

        if(existantFlight.isPresent()) {
            createFlightStatus.setStatus(false);
            createFlightStatus.setDescription("Flight already exists");
            return createFlightStatus;
        }

        Flight flight = new Flight();
        flight.setFlightCode(flightCode);
        flight.setFromLocation(fromLocation);
        flight.setToLocation(toLocation);
        flight.setPlane(plane);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");

        try {
            flight.setDepartureTime(simpleDateFormat.parse(departureTime));
            flight.setArrivalTimve(simpleDateFormat.parse(arrivalTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        flightRepository.save(flight);

        createFlightStatus.setStatus(true);

        return createFlightStatus;
    }

    @Override
    public CreateFlightAndUser createFlightAndUser(String flightCode, Long userId) {
        CreateFlightAndUser createFlightAndUser = new CreateFlightAndUser();

        FlightAndUsers flightAndUsers = new FlightAndUsers();
        flightAndUsers.setUserId(userId);
        flightAndUsers.setFlightCode(flightCode);

        flightAndUsersRepository.save(flightAndUsers);

        createFlightAndUser.setStatus(true);

        return createFlightAndUser;
    }
}
