package com.infosys.WorkItem_Service.repository;

import com.infosys.WorkItem_Service.model.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkItemRepo extends JpaRepository<WorkItem, String> {
    List<WorkItem> findByUserId(int userId);
    List<WorkItem> findByAssignedVehicleNumber(String vehicleNumber);
    boolean existsByWorkItemId(String workItemId);
}
