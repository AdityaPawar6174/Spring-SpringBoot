package com.adityaaa.jpacurddemo;

import com.adityaaa.jpacurddemo.beans.Batches;
import com.adityaaa.jpacurddemo.beans.Student;
import com.adityaaa.jpacurddemo.services.BatchServices;
import com.adityaaa.jpacurddemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class JpacurddemoApplication implements CommandLineRunner {

	@Autowired
	BatchServices batchService;

	@Autowired
	StudentService studentService;

	@Value("${spring.application.name}")
	private String appName;

	public static void main(String[] args) {
		SpringApplication.run(JpacurddemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println(appName);
		System.out.println("Enter 1 to add new Batch");
		System.out.println("Enter 2 to add multiple batches");
		System.out.println("Enter 3 to find the batch on basis of id");
		System.out.println("Enter 4 to update batch details");
		System.out.println("Enter 5 to fetch all the records from the database");
		System.out.println("Enter 6 to remove the batch");
		System.out.println("Enter 7 to find all batches by Name");

		System.out.println("Enter 8 to find All students");
		System.out.println("Enter 9 to find student by emailId");

		int operation = scanner.nextInt();
		switch (operation)
		{
			case 1:
				System.out.println("Enter Batch Name");
				String batchName = scanner.next();
				System.out.println("Enter Batch Start Date");
				String startDate = scanner.next();
				System.out.println("Enter Batch End Date");
				String endDate = scanner.next();

				Batches batch1 = new Batches();
				batch1.setBatchName(batchName);
				batch1.setBatchStartDate(startDate);
				batch1.setBatchEndDate(endDate);
				batchService.addBatch(batch1);
				break;

			case 2:
				System.out.println("Enter the number of Batches to be Added: ");
				int noofbatches = scanner.nextInt();
				List<Batches>  batchesList = new ArrayList<Batches>();
				for (int i =0;i<noofbatches;i++)
				{
					System.out.println("Enter Batch Name");
					String batchName1 = scanner.next();
					System.out.println("Enter Batch Start Date");
					String startDate1 = scanner.next();
					System.out.println("Enter Batch End Date");
					String endDate1 = scanner.next();
					Batches batch2 = new Batches();
					batch2.setBatchName(batchName1);
					batch2.setBatchStartDate(startDate1);
					batch2.setBatchEndDate(endDate1);
					batchesList.add(batch2);
				}
			batchService.addMultipleBatches(batchesList);
			break;

			case 3:
				System.out.println("Enter batchId to see batch details");
				int batchId= scanner.nextInt();
				try {
					Optional<Batches> optional = batchService.findBatchById(batchId);
					Batches batch = optional.get();
					System.out.println(batch.toString());
				} catch (Exception e) {
					System.err.println("Id not found");
				}
			break;

			case  4:
				System.out.println("Enter Batch Id");
				int batchID = scanner.nextInt();
				batchService.updateBatchesOnbasisOfId(batchID);
				break;

			case 5:
				System.out.println("All the records are given below...");
				List<Batches> batchesList1 = batchService.showAllBatches();
				batchesList1.forEach(batch -> System.out.println(batch));
				break;

			case 6:
				System.out.println("Enter Batch Id");
				batchID = scanner.nextInt();
				batchService.removeBatchById(batchID);
				System.out.println("Batch deleted"+batchID);
				break;

			case 7:
				System.out.println("Enter Batch Name");
				String fbatchName = scanner.next();
				List<Batches> batchesList2 = batchService.findOnBasisOfBatchName(fbatchName);
				batchesList2.forEach(batch -> System.out.println(batch));
				break;

			case 8:
				List<Student> studentList = studentService.showAllStudents();
				System.out.println(studentList);
				break;

			case 9:
				System.out.println("Enter Student Email");
				String email = scanner.next();
				Student s = studentService.showByEmail(email);

				if (s != null)
				{
					System.out.println(s);
				}
				else {
					System.err.println("Email not found!!!");
				}
				break;

			default:
				System.out.println("Enter Valid number...!");
		}
	}
}
