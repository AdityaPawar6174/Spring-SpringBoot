package com.aditya.MappingDemo;

import com.aditya.MappingDemo.beans.Courses;
import com.aditya.MappingDemo.beans.Department;
import com.aditya.MappingDemo.beans.Student;
import com.aditya.MappingDemo.services.CourseInterface;
import com.aditya.MappingDemo.services.DepartmentService;
import com.aditya.MappingDemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MappingDemoApplication implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MappingDemoApplication.class, args);
	}

	@Autowired
	DepartmentService departmentService;

	@Autowired
	StudentService studentService;

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add new Department");
		System.out.println("Enter 2 to get all Departments");
		System.out.println("Enter 3 to add student with course");

		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option)
		{
			case 1:
				System.out.println("Enter department name");
				String dname = scanner.next();
				Department department = new Department(dname);
				List<Student> slist = new ArrayList<>();
				System.out.println("Enter no of students to add");
				int n = scanner.nextInt();
				for(int i=0;i<n;i++)
				{
					System.out.println("enter student name");
					String sname =scanner.next();
					System.out.println("enter student email");
					String smail =scanner.next();
					Student s = new Student(sname,smail);
					s.setDepartment(department);
					slist.add(s);
				}

				department.setStudentList(slist);
				departmentService.saveDepartment(department);
				System.out.println("object is saved");
				break;

			case 2:
				break;

			case 3:
				System.out.println("Enter student name");
				String sname = scanner.nextLine();
				System.out.println("enter student email");
				String smail = scanner.nextLine();

				System.out.println("enter dept ID");
				int deptID = scanner.nextInt();
				scanner.nextLine();
				Department department1 = departmentService.findDepartmentOnBasisOfId(deptID);

				List<Courses> coursesList = new ArrayList<>();
				System.out.println("enter the no of courses to add");
				int ncoures = scanner.nextInt();
				scanner.nextLine();
				for (int i=0; i<ncoures; i++){
					System.out.println("Enter courses name");
					String cname = scanner.nextLine();
					Courses courses = new Courses();
					courses.setCourseName(cname);
					coursesList.add(courses);
				}

				Student student = new Student(sname, smail);
				student.setDepartment(department1);
				student.setCoursesList(coursesList);

				studentService.addStudent(student);

				System.out.println("Data saved");
				break;

			default:
				System.out.println("invalid input!!!");
		}
	}
}
