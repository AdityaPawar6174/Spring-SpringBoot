package com.aditya.OnlineCourseManagementSystem;

import com.aditya.OnlineCourseManagementSystem.Beans.Course;
import com.aditya.OnlineCourseManagementSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class OnlineCourseManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCourseManagementSystemApplication.class, args);
	}

	@Autowired
	private CourseService courseService;

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 1: Add Course");
		System.out.println("Enter 2: Show Course By:");
		System.out.println("Enter 3: Update Course Details");
		System.out.println("Enter 4: Delete course");
		System.out.println("Enter 5: Fetch Courses By:");

		int operation = sc.nextInt();
		sc.nextLine();

		switch (operation)
		{
			case 1:
				System.out.println("Enter Course Title");
				String title = sc.nextLine();
				System.out.println("Enter Course Description");
				String desc = sc.nextLine();
				System.out.println("Enter Course Instructor Name");
				String intru = sc.nextLine();
				System.out.println("Enter Course Category");
				String categ = sc.nextLine();
				System.out.println("Enter Course Start Date (yyyy-mm-dd): ");
				LocalDate startDate = LocalDate.parse(sc.nextLine());
				System.out.println("Enter Course End Date (yyyy-mm-dd):");
				LocalDate endDate = LocalDate.parse(sc.nextLine());

				Course course = new Course();
				course.setTitle(title);
				course.setDescription(desc);
				course.setInstructor(intru);
				course.setCategory(categ);
				course.setStartDate(startDate);
				course.setEndDate(endDate);
				courseService.addCourse(course);
				break;

			case 2:
				System.out.println("1: Course ID \n2: List All Course");
				int option = sc.nextInt();

				switch (option) {
					case 1:
						System.out.println("Enter Course ID");
						int id = sc.nextInt();
						sc.nextLine();
						Course c1 =  courseService.getCourseById(id);
						System.out.println(c1.toString());
					    break;

					case 2:
						List<Course> courseList = courseService.getAllCourses();
						courseList.forEach(course1 -> {
							System.out.println(course1);
						});
						break;

					default:
						System.err.println("Enter valid Option!!!");
				}
			break;

			case 3:
				System.out.println("Enter Course ID to Update:");
				int updateId = sc.nextInt();
				sc.nextLine();
				try {
					Course existing = courseService.getCourseById(updateId);
					if (existing != null) {
						System.out.println("New Title:");
						existing.setTitle(sc.nextLine());
						System.out.println("New Description:");
						existing.setDescription(sc.nextLine());
						System.out.println("New Instructor:");
						existing.setInstructor(sc.nextLine());
						System.out.println("New Category:");
						existing.setCategory(sc.nextLine());
						System.out.println("New Start Date:");
						existing.setStartDate(LocalDate.parse(sc.nextLine()));
						System.out.println("New End Date:");
						existing.setEndDate(LocalDate.parse(sc.nextLine()));
						courseService.updateCourse(existing);
					} else {
						System.out.println("Course not found");
					}
				} catch (Exception e) {
					System.err.println("Invalid ID");
				}
				break;

			case 4:
				System.out.println("Enter ID to Delete:");
				courseService.deleteCourse(sc.nextInt());
				break;

			case 5:
				System.out.println("1: Instructor \n2:Category \n3:Date Range ");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {

					case 1:
						System.out.println("Enter Instructor Name:");
						courseService.fetchByInstructor(sc.nextLine()).forEach(System.out::println);
						break;

					case 2:
						System.out.println("Enter Category:");
						courseService.fetchByCategory(sc.nextLine()).forEach(System.out::println);
						break;

					case 3:
						System.out.println("Enter Start Date (yyyy-mm-dd):");
						LocalDate sDate = LocalDate.parse(sc.nextLine());
						System.out.println("Enter End Date (yyyy-mm-dd):");
						LocalDate eDate = LocalDate.parse(sc.nextLine());
						courseService.fetchBySchedule(sDate, eDate).forEach(System.out::println);
						break;

					default:
						System.err.println("Invalid Choice!!!");
				}
				break;

			default:
				System.err.println("Invalid Input...!");
		}
	}
}
