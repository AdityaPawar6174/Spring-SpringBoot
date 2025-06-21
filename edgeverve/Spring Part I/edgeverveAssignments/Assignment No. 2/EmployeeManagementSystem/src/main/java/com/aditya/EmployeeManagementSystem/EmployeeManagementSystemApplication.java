package com.aditya.EmployeeManagementSystem;

import com.aditya.EmployeeManagementSystem.beans.Employees;
import com.aditya.EmployeeManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 1 to add new Employee");
		System.out.println("Enter 2 to find Employee by using ID");
		System.out.println("Enter 3 to list all the Employees");
		System.out.println("Enter 4 to updated Employee Details");
		System.out.println("Enter 5 to delete particular Employee");
		System.out.println("Enter 6 to fetch employees by data");

		int operations = sc.nextInt();
		sc.nextLine();

		switch (operations)
		{
			case 1:
				System.out.println("Enter Employee Name");
				String empName = sc.nextLine();

				System.out.println("Enter Employee Role");
				String empRole = sc.nextLine();

				System.out.println("Enter Employee Department");
				String empDept = sc.nextLine();

				System.out.println("Enter Employee Salary");
				double empSalary  = sc.nextDouble();
				sc.nextLine();

				System.out.println("Enter Employee Location");
				String empLoc = sc.nextLine();

				Employees employees = new Employees();
				employees.setName(empName);
				employees.setRole(empRole);
				employees.setDepartment(empDept);
				employees.setSalary(empSalary);
				employees.setLocation(empLoc);
				employeeService.addEmployee(employees);
				break;

			case 2:
				System.out.println("Enter Employee ID");
				int empId = sc.nextInt();
				try {
					Employees employees1 = employeeService.getEmployeeById(empId);
					System.out.println(employees1.toString());
				} catch (Exception e) {
					System.err.println("Id not valid"+e);
				}
				break;

			case 3:
				System.out.println("List of All Employees");
				List<Employees> employeesList = employeeService.getAllEmployees();
				employeesList.forEach(employees2 -> System.out.println(employees2));
				break;

			case 4:
				System.out.println("Enter Employee ID tp be updated");
				empId = sc.nextInt();
				sc.nextLine();
				try {
					Employees existingEmployee = employeeService.getEmployeeById(empId);
					if (existingEmployee == null){
						System.out.println("Employee with ID"+empId+" Not Found!!!");
						break;
					}

					System.out.println("update employee Name");
					String newEmpName = sc.nextLine();
					System.out.println("update employee role");
					String newEmpRole = sc.nextLine();
					System.out.println("update employee department");
					String newEmpDept = sc.nextLine();
					System.out.println("update employee salary");
					double newEmpSalary = sc.nextDouble();
					sc.nextLine();
					System.out.println("update employee location");
					String newEmpLoc = sc.nextLine();


					existingEmployee.setName(newEmpName);
					existingEmployee.setRole(newEmpRole);
					existingEmployee.setDepartment(newEmpDept);
					existingEmployee.setSalary(newEmpSalary);
					existingEmployee.setLocation(newEmpLoc);
					employeeService.updateEmployee(existingEmployee);
					System.out.println("Employee is updated Successfully...");
				} catch (Exception e) {
					System.err.println("ID Not Valid"+e.getMessage());
				}
				break;

			case 5:
				System.out.println("Enter the Employee ID, Who is no longer working with organization");
				empId = sc.nextInt();
				sc.nextLine();
				employeeService.deleteEmploye(empId);
				break;

			case 6:
				System.out.println("Search by:");
				System.out.println("1: Department");
				System.out.println("2: Role");
				System.out.println("3: Location");

				int option = sc.nextInt();
				sc.nextLine();

				try {
					List<Employees> filteredList = new ArrayList<>();

					switch (option) {
						case 1:
							System.out.println("Enter Department");
							String dept = sc.nextLine();
							filteredList = employeeService.filterByDepartment(dept);
							break;
						case 2:
							System.out.println("Enter Role");
							String role = sc.nextLine();
							filteredList = employeeService.filterByRole(role);
							break;
						case 3:
							System.out.println("Enter Location");
							String loc = sc.nextLine();
							filteredList = employeeService.filterByLocation(loc);
							break;
						default:
							System.out.println("Select Proper option...");
					}

					if (!filteredList.isEmpty()) {
						for (Employees e : filteredList) {
							System.out.println(e);
						}
					} else {
						System.out.println("No Matching Record Found!!!");
					}
				} catch (Exception e) {
					System.err.println("Invalid Option"+e.getMessage());
				}
				break;

			default:
				System.out.println("Invalid Operation Input!!!");
		}
	}
}
