package com.infosys.WorkItem_Service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ftr_workitem_terminal")
public class WorkItemTerminal {
    @Id
    private String workItemId;
    private String terminalId;

}