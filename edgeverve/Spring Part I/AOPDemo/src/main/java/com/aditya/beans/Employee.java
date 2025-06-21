package com.aditya.beans;

import com.aditya.services.EmployeeService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;

@Component
@Data // getter, setter, toString(), equals(), contructor
public class Employee {

    @Setter // by using lambok plugin
    @Getter
    private String employeeName = "Aditya";
    @Setter
    @Getter
    private int employeeId = 45;

    @Autowired
    private EmployeeService employeeService;

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
