package com.infosys.WorkItem_Service.controler;

import com.infosys.WorkItem_Service.model.WorkItem;
import com.infosys.WorkItem_Service.service.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workitems")
public class WorkItemController {
    
    @Autowired
    WorkItemService workItemService;

    @PostMapping
    public ResponseEntity<WorkItem> createWorkItem(@RequestBody WorkItem workItem) {
        return ResponseEntity.ok(workItemService.createWorkItem(workItem));
    }

    @PostMapping("/{workItemId}/assign-terminal/{terminalId}")
    public ResponseEntity<Void> assignTerminal(
            @PathVariable String workItemId,
            @PathVariable String terminalId) {
        workItemService.assignTerminal(workItemId, terminalId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{workItemId}/allocate-vehicle/{vehicleNumber}")
    public ResponseEntity<Void> allocateVehicle(
            @PathVariable String workItemId,
            @PathVariable String vehicleNumber) {
        workItemService.allocateVehicle(workItemId, vehicleNumber);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkItem>> getWorkItemsByUser(@PathVariable int userId) {
        return ResponseEntity.ok(workItemService.getWorkItemsByUser(userId));
    }

    @GetMapping
    public List<WorkItem> getAllworkItems(){
        return workItemService.geAllWorkItems();
    }

    @GetMapping("/vehicle/{vehicleNumber}")
    public ResponseEntity<List<WorkItem>> getWorkItemsByVehicle(
            @PathVariable String vehicleNumber) {
        return ResponseEntity.ok(workItemService.getWorkItemsByVehicle(vehicleNumber));
    }
}