package com.infosys.Vehicle_Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "ftr_vehicle")
public class Vehicle {
    @Id
    private String vehicleNumber;
    private String vehicleName;
    private Integer maxLiftingCapacity;
    private Date retireDate;
    private String vehicleStatus;
    private String country;
    private String harborLocation;
}
