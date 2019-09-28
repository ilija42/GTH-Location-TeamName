package com.globaltravel.globaltravel.repository;

import com.globaltravel.globaltravel.repository.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, String> {

}
