package com.Infosys.Que1_EmployeePerformanceSystem;

import com.Infosys.Que1_EmployeePerformanceSystem.beans.Department;
import com.Infosys.Que1_EmployeePerformanceSystem.beans.Employee;
import com.Infosys.Que1_EmployeePerformanceSystem.beans.PerformanceReview;
import com.Infosys.Que1_EmployeePerformanceSystem.beans.Project;
import com.Infosys.Que1_EmployeePerformanceSystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Que1EmployeePerformanceSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Que1EmployeePerformanceSystemApplication.class, args);
	}

	@Autowired
	@Qualifier("standard")
	private StandardBonusService standardBonusService;

	@Autowired
	@Qualifier("executive")
	private ExecutiveBonusService executiveBonusService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private PerformanceReviewService performanceReviewService;

	@Autowired
	private ProjectService projectService;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		boolean running = true;

		while (running) {

			System.out.println("\n======= EMPLOYEE PERFORMANCE SYSTEM =======");
			System.out.println("1. Add Department");
			System.out.println("2. Add Employee");
			System.out.println("3. Assign Projects");
			System.out.println("4. Add Performance Review");
			System.out.println("5. Calculate Bonus");
			System.out.println("6. Exit");
			System.out.println("===========================================\n");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

				case 1:
					System.out.println("Enter Department Name: ");
					String departmentName = scanner.nextLine();

					Department department = new Department();
					department.setName(departmentName);

					departmentService.addDepartment(department);
					System.out.println("Department added successfully..." + departmentName);
					break;

				case 2:
					System.out.println("Enter Employee Name: ");
					String employeeName = scanner.nextLine();
					System.out.println("Enter Employee Salary: ");
					double employeeSalary = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Enter Employee Rating (1-5): ");
					int employeeRating = scanner.nextInt();
					scanner.nextLine();

					System.out.println("Available Departments:");
					List<Department> departments = departmentService.getAllDepartments();
					for (Department dept : departments) {
						System.out.println(dept.getId() + ". " + dept.getName());
					}

					System.out.println("Select Department ID: ");
					int departmentId = scanner.nextInt();
					scanner.nextLine();

					Employee employee = new Employee();
					employee.setName(employeeName);
					employee.setSalary(employeeSalary);
					employee.setRating(employeeRating);

					Department department1 = new Department();
					department1.setId(departmentId);
					employee.setDepartment(department1);

					employeeService.addEmployee(employee);
					System.out.println("Employee added successfully...");
					break;

				case 3:
					System.out.println("Enter Employee ID: ");
					int empId = scanner.nextInt();
					scanner.nextLine();

					System.out.println("Enter Project IDs (comma-separated): ");
					String projectIds = scanner.nextLine();

					List<Integer> projectIdList = Arrays.stream(projectIds.split(","))
							.map(String::trim)
							.map(Integer::parseInt)
							.toList();

					employeeService.assignProjects(empId, projectIdList);
					System.out.println("Projects assigned successfully to Employee ID...");
					break;

				case 4:
					System.out.println("Enter Employee ID for Performance Review: ");
					int empId2 = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Performance Rating (1-5): ");
					int performanceRating = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Review Date (YYYY-MM-DD): ");
					String date = scanner.nextLine();
					System.out.println("Enter Review Remarks: ");
					String remarks = scanner.nextLine();

					try {

						Date reviewDate = dateFormat.parse(date);

						PerformanceReview review =  new PerformanceReview();
						review.setRating(performanceRating);
						review.setReviewDate(reviewDate);
						review.setRemarks(remarks);

						employeeService.addPerformanceReview(empId2, review);
						System.out.println("Performance Review added successfully...");

					} catch (Exception e) {
						System.err.println("Invalid DateFormat (yyyy-mm-dd)..."+e.getMessage());
					}
					break;

				case 5:

					System.out.println("Enter Employee Type (standard/executive): ");
					String type = scanner.nextLine().trim().toLowerCase();

					System.out.println("Enter Employee Rating (1-5): ");
					int rating = scanner.nextInt();
					scanner.nextLine();

					double bonus;
					try {

						if ("standard".equals(type)) {
							bonus = standardBonusService.calculateBonus(rating);
						} else if ("executive".equals(type)) {
							bonus = executiveBonusService.calculateBonus(rating);
						} else {
							System.out.println("Invalid employee type...");
							return;
						}

						System.out.println("Calculated Bonus: " + bonus + " Rs.");
					} catch (Exception e) {
						System.err.println("Invalid input. Please enter a valid employee type and rating..." + e.getMessage());
					}

					break;

				case 6:
					System.out.println("Exiting system...Thank You For Visiting!!!");
					running = false;
					System.exit(0);
					break;

				case 7:
					// assign project
					System.out.println("Enter Project name");
					String title = scanner.nextLine();
					System.out.println("projevt dunrationMoths");
					int durationMonths = scanner.nextInt();
					scanner.nextLine();

					Project project = new Project();
					project.setTitle(title);
					project.setDurationMonths(durationMonths);
					projectService.addProject(project);
					System.out.println("Project added successfully...");

					break;

				default:
					System.err.println("Invalid choice. Please try again.");
					break;

			}
		}
	}
}
