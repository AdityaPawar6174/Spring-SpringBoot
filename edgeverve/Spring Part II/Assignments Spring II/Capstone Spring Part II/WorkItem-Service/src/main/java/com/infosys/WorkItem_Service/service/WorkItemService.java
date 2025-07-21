package com.infosys.WorkItem_Service.service;

import com.infosys.WorkItem_Service.feign.TerminalServiceClient;
import com.infosys.WorkItem_Service.feign.UserServiceClient;
import com.infosys.WorkItem_Service.feign.VehicleServiceClient;
import com.infosys.WorkItem_Service.model.WorkItem;
import com.infosys.WorkItem_Service.repository.WorkItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkItemService {

    @Autowired
    WorkItemRepo workItemRepo;

    @Autowired
    UserServiceClient userClient;
    @Autowired
    private TerminalServiceClient terminalClient;

    @Autowired
    private VehicleServiceClient vehicleClient;

    public WorkItem createWorkItem(WorkItem workItem) {

        if (!userClient.validateUser(workItem.getUserId())) {
            throw new IllegalArgumentException("Invalid User ID");
        }
        return workItemRepo.save(workItem);
    }

    public WorkItem getWorkItemById(String workItemId) {
        return workItemRepo.findById(workItemId)
                .orElseThrow(() -> new RuntimeException("WorkItem not found"));
    }

    public void assignTerminal(String workItemId, String terminalId) {
        WorkItem workItem = getWorkItemById(workItemId);

        // Validate terminal via Feign
        if (!terminalClient.validateTerminal(terminalId)) {
            throw new IllegalArgumentException("Invalid Terminal ID");
        }

        workItem.setAssignedTerminalId(terminalId);
        workItemRepo.save(workItem);
    }


    public void allocateVehicle(String workItemId, String vehicleNumber) {
        WorkItem workItem = getWorkItemById(workItemId);

        if (!vehicleClient.validateVehicle(vehicleNumber)) {
            throw new IllegalArgumentException("Invalid Vehicle Number");
        }

        workItem.setAssignedVehicleNumber(vehicleNumber);
        workItemRepo.save(workItem);
    }


    public List<WorkItem> getWorkItemsByUser(int userId) {
        return workItemRepo.findByUserId(userId) ;
    }


    public List<WorkItem> getWorkItemsByVehicle(String vehicleNumber) {
        return workItemRepo.findByAssignedVehicleNumber(vehicleNumber);
    }

    public List<WorkItem> geAllWorkItems() {
        return workItemRepo.findAll();
    }
}
