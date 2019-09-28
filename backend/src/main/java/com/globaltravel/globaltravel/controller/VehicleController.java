package com.globaltravel.globaltravel.controller;


import com.globaltravel.globaltravel.services.DefaultVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private DefaultVehicleService defaultVehicleService;

    @PostMapping
    public Object createVehicle(@RequestParam String vehicleRegNumber, @RequestParam String vehicleType,
                                @RequestParam float lon, @RequestParam float lat, @RequestParam int sittingSpace,
                                @RequestParam int packageSize, @RequestParam boolean childSeat) {
        return defaultVehicleService.createVehicle(vehicleRegNumber, vehicleType, lon, lat, sittingSpace, packageSize, childSeat);
    }

}
