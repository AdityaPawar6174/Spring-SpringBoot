package com.Infosys.Que1_EmployeePerformanceSystem.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("executive")
public class ExecutiveBonusService implements BonusServiceInterface{

    @Value("${executive.multiplier}")
    private double multiplier;

    @Override
    public double calculateBonus(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        return rating * multiplier;
    }
}
