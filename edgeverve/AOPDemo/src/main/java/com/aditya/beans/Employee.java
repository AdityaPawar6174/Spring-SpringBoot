package com.aditya.beans;

import com.aditya.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;

@Component
public class Employee {

    private String employeeName = "Aditya";
    private int employeeId = 45;

    @Autowired
    private EmployeeService employeeService;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void showDetails(){
        System.out.println("Employee Name: "+employeeName);
        System.out.println("Employee ID: "+employeeId);
    }

    public void joiningDate(){
        employeeService.joiningDate();
    }

    public void endDate(){
        employeeService.endDate();
    }

    public void promotionDate(String promotiondate){
        System.out.println("Congrats, you got promoted...your promotion date will be: "+promotiondate);
    }

    public void deniedOffer(){
        throw new RuntimeException("Offer Letter is not accepted by the Candidate");
    }
}
