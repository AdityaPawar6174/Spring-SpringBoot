package com.infosys.WorkItem_Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "ftr_workitem")
public class WorkItem {
    @Id
    private String workItemId;
    private Long userId;
    private String itemName;
    private String itemType;
    private String itemDescription;
    private String messageToRecipient;
    private String quantity;
    private String collectionCountry;
    private String destinationCountry;
    private String originHarborLocation;
    private String selectedHarborLocations;
    private Date shippingDate;
    private Integer amount;
    private String status;
    private String assignedTerminalId;
    private String assignedVehicleNumber;
}
