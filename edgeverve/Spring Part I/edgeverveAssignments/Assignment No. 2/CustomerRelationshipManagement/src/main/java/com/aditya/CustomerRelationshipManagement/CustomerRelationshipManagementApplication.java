package com.aditya.CustomerRelationshipManagement;

import com.aditya.CustomerRelationshipManagement.beans.Customer;
import com.aditya.CustomerRelationshipManagement.beans.Interaction;
import com.aditya.CustomerRelationshipManagement.service.CRMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.spi.DateFormatProvider;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CustomerRelationshipManagementApplication implements CommandLineRunner {

	@Autowired
	CRMService crmService;

	public static void main(String[] args) {
		SpringApplication.run(CustomerRelationshipManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 1 to Add new Customer");
		System.out.println("Enter 2 to View Customer");
		System.out.println("Enter 3 to Update Customer");
		System.out.println("Enter 4 to Delete Customer");
		System.out.println("Enter 5 to Add Interaction");
		System.out.println("Enter 6 to view Feedback by Product");
		System.out.println("Enter 7 to view Feedback by Date Range");
		System.out.println("Enter 8 to view Feedback by Rating");

		int operation = scanner.nextInt();
		scanner.nextLine();

		switch (operation)
		{
			case 1:
				System.out.println("Enter the Customer Details:");
				Customer customer = new Customer();

				System.out.println("Enter Customer Name");
				String name = scanner.nextLine();
				System.out.println("Enter customer email");
				String email = scanner.nextLine();
				System.out.println("Enter Customer Contact Number");
				String phone = scanner.nextLine();
				System.out.println("enter customer address");
				String address = scanner.nextLine();

				customer.setName(name);
				customer.setEmail(email);
				customer.setPhone(phone);
				customer.setAddress(address);
				crmService.addCustomer(customer);
				break;

			case 2:
				System.out.println("View customer:");
				System.out.println("1. Using Customer ID...Enter Id Below");
				System.out.println("2. List All Customers");

				int option = scanner.nextInt();
				scanner.nextLine();

				switch (option) {
					case 1:
					System.out.println("Enter Customer ID");
					int customerId = scanner.nextInt();
					scanner.nextLine();
					try {
						Customer customer1 = crmService.getCustomerById(customerId);
						System.out.println(customer1.toString());
					} catch (Exception e) {
						System.err.println("Id not valid" + e.getMessage());
					}
					break;

					case 2:
						try
						{
							List<Customer> customerList = crmService.getAllCustomer();
							customerList.forEach(customer1 -> System.out.println(customer1));
						} catch (Exception e) {
							System.out.println("error displaying records"+e.getMessage());
						}
						break;

					default:
						System.out.println("choose correct option!!!");
				}
				break;

			case 3:
				System.out.println("Enter Customer Id to be Updated");
				int id = scanner.nextInt();
				scanner.nextLine();

				try
				{
					Customer existingCustomer = crmService.getCustomerById(id);

					if (existingCustomer == null)
					{
						System.out.println("Employee with ID"+id+" Not found");
						break;
					}

					System.out.println("Update Customer Name");
					String newName = scanner.nextLine();
					System.out.println("Update Customer Email");
					String newEmail = scanner.nextLine();
					System.out.println("Update Customer phone");
					String newPhone = scanner.nextLine();
					System.out.println("Update Customer Address");
					String newAddr = scanner.nextLine();

					existingCustomer.setName(newName);
					existingCustomer.setEmail(newEmail);
					existingCustomer.setPhone(newPhone);
					existingCustomer.setAddress(newAddr);
					crmService.updateCustomer(existingCustomer);
					System.out.println("Customer Updated Successfully...");
				} catch (Exception e) {
					System.err.println("Id not valid"+e.getMessage());
				}
				break;

			case 4:
				System.out.println("Enter customer id");
                id = scanner.nextInt();
				scanner.nextLine();
				crmService.deleteCustomer(id);
				System.out.println("Customer "+id+" deleted Successfully...");
				break;

			case 5:
				System.out.print("Enter Customer ID: ");
				int customerId = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter Product: ");
				String product = scanner.nextLine();

				System.out.print("Enter Rating (1-5): ");
				int rating = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter Interaction Notes: ");
				String notes = scanner.nextLine();

				Interaction interaction = new Interaction();
				interaction.setProduct(product);
				interaction.setRating(rating);
				interaction.setNotes(notes);

				try {
					crmService.addInteraction(customerId, interaction);
					System.out.println(" Interaction added successfully.");
				} catch (Exception e) {
					System.out.println(" Failed to add interaction: " + e.getMessage());
				}
				break;

			case 6:
				System.out.println("Enter Product Name:");
				String prod = scanner.nextLine();
				List<Interaction> productFeedback = crmService.getFeedbackByProduct(prod);
				productFeedback.forEach(prod1 -> System.out.println(prod1));
				break;

			case 7:
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

				System.out.println("Enter Start Date (yyyy-MM-ddd): ");
				String startStr = scanner.nextLine();
				LocalDate startDate = LocalDate.parse(startStr, formatter);

				System.out.println("Enter End Date (yyyy-MM-dd): ");
				String endStr = scanner.nextLine();
				LocalDate endDate = LocalDate.parse(endStr, formatter);

				List<Interaction> dateFeedback = crmService.getFeedbackByDateRange(startDate, endDate);
				dateFeedback.forEach(date -> System.out.println(date));
				break;

			case 8:
				System.out.print("Enter Rating (1 to 5): ");
				int rating1 = scanner.nextInt();
				scanner.nextLine();

				List<Interaction> ratingFeedback = crmService.getFeedbackByRating(rating1);
				ratingFeedback.forEach(rate -> System.out.println(rate));
				break;

			default:
				System.out.println("Invalid Input!!!");
		}
	}
}
