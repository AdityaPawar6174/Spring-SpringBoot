package com.infosys.Vehicle_Service.controller;

import com.infosys.Vehicle_Service.model.Vehicle;
import com.infosys.Vehicle_Service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    
    @Autowired
    VehicleService vehicleService;
    
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.addVehicle(vehicle));
    }
    
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllAvailableVehicles() {
        return ResponseEntity.ok(vehicleService.getAllAvailableVehicles());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Vehicle>> getVehiclesByName(@RequestParam String name) {
        return ResponseEntity.ok(vehicleService.getVehiclesByName(name));
    }
    
    @GetMapping("/{vehicleNumber}")
    public ResponseEntity<Vehicle> getVehicleByNumber(@PathVariable String vehicleNumber) {
        return ResponseEntity.ok(vehicleService.getVehicleByNumber(vehicleNumber));
    }

    @PutMapping("/{vehicleNumber}/status")
    public ResponseEntity<Void> updateStatus(
            @PathVariable String vehicleNumber,
            @RequestParam String status) {
        vehicleService.updateVehicleStatus(vehicleNumber, status);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> deleteVehicle(@PathVariable String number){
        String result = vehicleService.deleteVehicle(number);
        return ResponseEntity.ok(result);
    }
}