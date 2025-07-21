package com.infosys.Terminal_Service.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ftr_terminals")
public class Terminal {
    @Id
    private String terminalId;
    private String terminalName;
    private String country;
    private String itemType;
    private String terminalDescription;
    private Integer capacity;
    private Integer availableCapacity;
    private String status;
    private String harborLocation;
}
