package com.Infosys.Que1_EmployeePerformanceSystem.repos;

import com.Infosys.Que1_EmployeePerformanceSystem.beans.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceReviewRepo extends JpaRepository<PerformanceReview,Integer> {
}
