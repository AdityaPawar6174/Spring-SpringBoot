package com.infosys.Vehicle_Service.repository;

import com.infosys.Vehicle_Service.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, String> {
    List<Vehicle> findByVehicleStatus(String status);
    List<Vehicle> findByVehicleNameContainingIgnoreCase(String name);
    boolean existsByVehicleNumber(String vehicleNumber);
}
