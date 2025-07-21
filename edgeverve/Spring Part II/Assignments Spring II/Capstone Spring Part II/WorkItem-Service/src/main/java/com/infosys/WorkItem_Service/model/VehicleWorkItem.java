package com.infosys.WorkItem_Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ftr_vehicle_workitem")
public class VehicleWorkItem {
    @Id
    private String vehicleNumber;
    private String workItemId;
    private String assignedWorkItemStatus;
}