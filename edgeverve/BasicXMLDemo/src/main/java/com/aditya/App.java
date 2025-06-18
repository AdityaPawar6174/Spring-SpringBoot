package com.aditya;

import com.aditya.beans.Clients;
import com.aditya.beans.Department;
import com.aditya.beans.Employee;
import com.aditya.beans.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Employee emp = context.getBean("emp",Employee.class);
        Employee emp2 = context.getBean("emp2",Employee.class);


        System.out.println("Employee Name: "+emp.getEmpName());
        System.out.println("Employee Id: "+emp.getEmpId());


        // Department department = context.getBean(Department.class);
        Department department = (Department) context.getBean("dept");
        System.out.println(department.toString());

        Project project = context.getBean(Project.class);
        System.out.println(project.toString());

        Clients clients = context.getBean("client", Clients.class);
        System.out.println(clients.toString());
        clients.showEmployees();
        clients.showResourses();
    }
}
