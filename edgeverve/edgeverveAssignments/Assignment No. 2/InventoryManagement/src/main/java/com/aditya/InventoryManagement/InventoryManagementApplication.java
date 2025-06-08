package com.aditya.InventoryManagement;

import com.aditya.InventoryManagement.beans.Inventory;
import com.aditya.InventoryManagement.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class InventoryManagementApplication implements CommandLineRunner {

	@Autowired
	InventoryServices inventoryServices;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add new product");
		System.out.println("Enter 2 to read Product information by using product ID");
		System.out.println("Enter 3 to update product details");
		System.out.println("Enter 4 to delete the products");
		System.out.println("Enter 5 to Fetch products");

		int operation = scanner.nextInt();

		switch (operation)
		{
			case 1:
				System.out.println("Enter Product Name");
				String productName = scanner.next();
				System.out.println("Enter product price");
				int price = scanner.nextInt();
				System.out.println("Enter stack Quantity");
				int stackQuantity = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Product Description");
				String description = scanner.nextLine();

				Inventory inventory1 = new Inventory();
				inventory1.setProductName(productName);
				inventory1.setDescription(description);
				inventory1.setPrice(price);
				inventory1.setStockQuantity(stackQuantity);
				inventoryServices.addProduct(inventory1);
				break;

			case 2:
				System.out.println("Enter Product Id");
				int productId = scanner.nextInt();
				try{
					Optional<Inventory> optional = inventoryServices.findProductById(productId);
					Inventory inventory2 = optional.get();
					System.out.println(inventory2.toString());
				}
				catch (Exception e){
					System.err.println("Id not Found"+e);
				}
				break;

			case 3:
				System.out.println("Enter product Id to be updated");
				productId = scanner.nextInt();
				inventoryServices.updateInventory(productId);
				break;

			case 4:
				System.out.println("Enter product Id to be deleted");
				productId = scanner.nextInt();
				inventoryServices.deleteProduct(productId);
				break;

			case 5:
				System.out.println("Fetching all products information");
				List<Inventory> productlist = inventoryServices.getAllProducts();
				productlist.forEach(inventory -> System.out.println(inventory));
				break;

			default:
				System.out.println("Please enter the Valid Operation... Thank You!!!");
		}
	}
}
