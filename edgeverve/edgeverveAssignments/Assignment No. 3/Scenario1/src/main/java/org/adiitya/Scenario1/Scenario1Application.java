package org.adiitya.Scenario1;

import org.adiitya.Scenario1.beans.Publisher;
import org.adiitya.Scenario1.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Scenario1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Scenario1Application.class, args);
	}

	@Autowired
	private PublisherService publisherService;

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 1: ");

		int option = sc.nextInt();
		sc.nextLine();



		switch (option)
		{
			case 1:
				break;

			case 2:
				break;

			default:
		}
	}
}
