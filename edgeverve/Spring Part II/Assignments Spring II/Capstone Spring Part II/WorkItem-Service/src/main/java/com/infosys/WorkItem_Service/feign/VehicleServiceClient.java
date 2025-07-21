package com.infosys.WorkItem_Service.feign;

import com.infosys.WorkItem_Service.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "vehicle-service",
    configuration = FeignConfig.class,
    fallback = VehicleServiceFallback.class
)
public interface VehicleServiceClient {
    @GetMapping("/api/vehicles/{vehicleNumber}/validate")
    boolean validateVehicle(@PathVariable String vehicleNumber);
}

// Fallback
@Component
class VehicleServiceFallback implements VehicleServiceClient {
    @Override
    public boolean validateVehicle(String vehicleNumber) {
        return true;
    }
}