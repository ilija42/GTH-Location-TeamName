package com.globaltravel.globaltravel.controller;

import com.globaltravel.globaltravel.services.DefaultFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class FlightsController {

    @Autowired
    private DefaultFlightService defaultFlightService;

    @GetMapping("/{userId}")
    public Object getFlightsForUser(@PathVariable Long userId) {
        return defaultFlightService.getAllFlightsForUser(userId);
    }

    @PostMapping
    public Object createFlight(@RequestParam String fromLocation, @RequestParam String toLocation, @RequestParam String departureTime,
                               @RequestParam String arrivalTime, @RequestParam String flightCode, @RequestParam String plane) {
        return defaultFlightService.createFlight(fromLocation, toLocation, departureTime, arrivalTime, flightCode, plane);
    }

    @PostMapping("/fau")
    public Object createFlightAndUser(@RequestParam String flightCode, @RequestParam Long userId) {
        return defaultFlightService.createFlightAndUser(flightCode, userId);
    }

}
