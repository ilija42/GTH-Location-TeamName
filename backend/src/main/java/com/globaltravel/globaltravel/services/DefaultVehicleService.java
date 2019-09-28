package com.globaltravel.globaltravel.services;

import com.globaltravel.globaltravel.repository.VehicleRepository;
import com.globaltravel.globaltravel.repository.model.Vehicle;
import com.globaltravel.globaltravel.repository.returnTypes.VehicleCreationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultVehicleService implements BaseVehicleService {


    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public VehicleCreationStatus createVehicle(String vehicleRegNumber, String vehicleType, float lon, float lat,
                                               int sittingSpace, int packageSize, boolean childSeat) {

        VehicleCreationStatus vehicleCreationStatus = new VehicleCreationStatus();

        Optional<Vehicle> existingVehicle = vehicleRepository.findById(vehicleRegNumber);

        if(existingVehicle.isPresent()) {
            vehicleCreationStatus.setVehicleCreated(false);
            vehicleCreationStatus.setDescription("Vehicle already registered");
            return vehicleCreationStatus;
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleRegNumber(vehicleRegNumber);
        vehicle.setVehicleType(vehicleType);
        vehicle.setLon(lon);
        vehicle.setLat(lat);
        vehicle.setSittingSpace(sittingSpace);
        vehicle.setPackageSize(packageSize);
        vehicle.setChildSeat(childSeat);

        vehicleRepository.save(vehicle);

        vehicleCreationStatus.setVehicleCreated(true);
        return vehicleCreationStatus;
    }
}
