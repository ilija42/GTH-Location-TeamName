package com.globaltravel.globaltravel.repository;

import com.globaltravel.globaltravel.repository.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
