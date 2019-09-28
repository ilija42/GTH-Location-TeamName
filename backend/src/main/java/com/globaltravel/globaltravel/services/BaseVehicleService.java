package com.globaltravel.globaltravel.services;

import com.globaltravel.globaltravel.repository.returnTypes.VehicleCreationStatus;

public interface BaseVehicleService {

    VehicleCreationStatus createVehicle(String vehicleRegNumber, String vehicleType, float lon, float lan,
                                        int sittingSpace, int packageSize, boolean childSeat);

}
