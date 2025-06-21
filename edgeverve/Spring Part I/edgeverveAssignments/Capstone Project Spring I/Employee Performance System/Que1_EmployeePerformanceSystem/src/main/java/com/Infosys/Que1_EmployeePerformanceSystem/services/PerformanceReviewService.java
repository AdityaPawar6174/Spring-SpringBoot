package com.Infosys.Que1_EmployeePerformanceSystem.services;

import com.Infosys.Que1_EmployeePerformanceSystem.beans.PerformanceReview;
import com.Infosys.Que1_EmployeePerformanceSystem.repos.PerformanceReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceReviewService {

    @Autowired
    private PerformanceReviewRepo performanceReviewRepo;

    public void addPerformanceReview(PerformanceReview performanceReview) {
        performanceReviewRepo.save(performanceReview);
    }

    public PerformanceReview getPerformanceReviewById(int id) {
        return performanceReviewRepo.findById(id).orElse(null);
    }

}
