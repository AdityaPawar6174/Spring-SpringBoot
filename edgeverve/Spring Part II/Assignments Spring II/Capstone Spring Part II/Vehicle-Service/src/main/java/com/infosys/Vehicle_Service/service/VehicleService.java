package com.infosys.Vehicle_Service.service;

import com.infosys.Vehicle_Service.model.Vehicle;
import com.infosys.Vehicle_Service.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepo vehicleRepo;


    public Vehicle addVehicle(Vehicle vehicle) {
        if (vehicleRepo.existsById(vehicle.getVehicleNumber())) {
            throw new IllegalArgumentException("Vehicle already exists");
        }
        return vehicleRepo.save(vehicle);
    }

    public List<Vehicle> getAllAvailableVehicles() {
        return vehicleRepo.findAll();
    }

    public Vehicle getVehicleByNumber(String vehicleNumber) {
        return vehicleRepo.findById(vehicleNumber)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    public List<Vehicle> getVehiclesByName(String name) {
        return vehicleRepo.findByVehicleNameContainingIgnoreCase(name);
    }

    public void updateVehicleStatus(String vehicleNumber, String status) {
        Vehicle vehicle = getVehicleByNumber(vehicleNumber);
        vehicle.setVehicleStatus(status);
        vehicleRepo.save(vehicle);
    }

    public String deleteVehicle(String number) {
        vehicleRepo.deleteById(number);
        return "deleted";
    }
}
