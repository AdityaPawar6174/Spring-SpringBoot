package com.aditya.main;

import com.aditya.beans.Employee;
import com.aditya.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee employee = context.getBean(Employee.class);
        employee.joiningDate();
        employee.promotionDate("21-12-2025");
        employee.endDate();
        employee.deniedOffer();
    }
}
