package com.adityaaa.jpacurddemo;

import com.adityaaa.jpacurddemo.beans.Batches;
import com.adityaaa.jpacurddemo.services.BatchServices;
import org.springframework.beans.factory.annotation.Autowired;
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

	public static void main(String[] args) {
		SpringApplication.run(JpacurddemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add new Batch");
		System.out.println("Enter 2 to add multiple batches");
		System.out.println("Enter 3 to see all he batches");
		System.out.println("Enter 4 to update batch details");
		System.out.println("Enter 5 to remove the batch");

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

			default:
				System.out.println("Enter Valid number...!");
		}
	}
}
