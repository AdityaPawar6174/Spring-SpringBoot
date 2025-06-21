package com.aditya.Scenario2;

import com.aditya.Scenario2.beans.*;
import com.aditya.Scenario2.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Scenario2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Scenario2Application.class, args);
	}

	@Autowired
	private UserService userService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private CategoryService categoryService;

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 1: Add User along with Profile");
		System.out.println("Enter 2: View User with Profile and Orders");
		System.out.println("Enter 3: Create Order for User");
		System.out.println("Enter 4: Create Product with Categories");
		System.out.println("Enter 5: View Product with Categories");
		System.out.println("Enter 6: View All Products in a Category");
		System.out.println("Enter 7: View All Orders");

		System.out.println("Enter 0: Exit");

		int option = sc.nextInt();
		sc.nextLine();

		switch (option) {
			case 0:
				System.out.println("Exiting the application.");
				System.exit(0);
				break;

			case 1:
				System.out.println("Enter Username:");
				String username = sc.nextLine();
				System.out.println("Enter Password:");
				String password = sc.nextLine();
				System.out.println("Enter First Name:");
				String firstName = sc.nextLine();
				System.out.println("Enter Last Name:");
				String lastName = sc.nextLine();
				System.out.println("Enter Email:");
				String email = sc.nextLine();
				System.out.println("Enter Address:");
				String address = sc.nextLine();
				System.out.println("Enter Phone Number:");
				long phoneNumber = sc.nextLong();
				sc.nextLine(); // consume newline

				User user = new User(username, password);
				Profile profile = new Profile(firstName, lastName, email, address, phoneNumber);
				user.setProfile(profile);
				profile.setUser(user);

				userService.addUser(user);
				System.out.println("User and Profile created successfully!");
				System.exit(0);
				break;

			case 2:
				System.out.println("Enter User ID to view details:");
				int userId = sc.nextInt();
				sc.nextLine(); // consume newline
				User foundUser = userService.getUserById(userId);
				if (foundUser != null) {
					System.out.println("*********************************************");
					System.out.println("User Details:");
					System.out.println("Username: " + foundUser.getUserName());
					System.out.println("Profile: " + foundUser.getProfile());
					System.out.println("Orders: " + foundUser.getOrders());
					System.out.println("*********************************************");
				} else {
					System.out.println("User not found with ID: " + userId);
				}
				System.exit(0);
				break;

			case 3:
				System.out.println("Enter User ID to create an order:");
				int orderUserId = sc.nextInt();
				sc.nextLine(); // consume newline

				User orderUser = userService.getUserById(orderUserId);
				if (orderUser == null) {
					System.out.println("User not found with ID: " + orderUserId);
					System.exit(0);
				}

				System.out.println("Enter number of Products to add:");
				int productCount = sc.nextInt();
				sc.nextLine();

				List<Product> products = new ArrayList<>();

				for (int i = 1; i <= productCount; i++) {
					System.out.println("Enter Product Name for Product " + i + ":");
					String productName = sc.nextLine();

					System.out.println("Enter Product Price for Product " + i + ":");
					double productPrice = sc.nextDouble();
					sc.nextLine(); // consume leftover newline

					Product product = new Product(productName, productPrice);
					Product savedProduct = productService.returnProduct(product);

					products.add(savedProduct);
				}
				sc.nextLine();

				System.out.println("Enter Order Date (YYYY-MM-DD):");
				String orderDateStr = sc.nextLine();
				java.util.Date orderDate = java.sql.Date.valueOf(orderDateStr);

				// Create Order
				Order order = new Order(orderDate);
				order.setUser(orderUser);
				products = new ArrayList<>();
				for (Product product : products) {
					products.add(productService.returnProduct(product));
				}
				order.setProducts(products);

				orderService.addOrder(order);
				System.out.println("Order created successfully for User ID: " + orderUserId);
				break;

			case 4:
				System.out.println("Enter Product Name:");
				String productName = sc.nextLine();
				System.out.println("Enter Product Price:");
				double productPrice = sc.nextDouble();
				sc.nextLine(); // consume newline
				System.out.println("Enter number of Categories:");
				int categoryCount = sc.nextInt();
				sc.nextLine(); // consume newline

				List<String> categories = new ArrayList<>();
				for (int i = 1; i <= categoryCount; i++) {
					System.out.println("Enter Category Name for Category " + i + ":");
					String categoryName = sc.nextLine();
					categories.add(categoryName);
				}
				Product product = new Product(productName, productPrice);
				List<Category> categoryList = new ArrayList<>();
				for (String categoryName : categories) {
					Category category = new Category(categoryName);
					categoryList.add(category);
				}
				product.setCategories(categoryList);
				productService.addProduct(product);
				System.out.println("Product created successfully with ID: " + product.getId());
				System.exit(0);
				break;

			case 5:
				System.out.println("Enter Product ID to view details:");
				int productId = sc.nextInt();
				sc.nextLine(); // consume newline
				Product foundProduct = productService.getProductById(productId);
				if (foundProduct != null) {
					System.out.println("*********************************************");
					System.out.println("Product Details:");
					System.out.println("Name: " + foundProduct.getName());
					System.out.println("Price: " + foundProduct.getPrice());
					System.out.println("Categories: " + foundProduct.getCategories());
					System.out.println("*********************************************");
				} else {
					System.out.println("Product not found with ID: " + productId);
				}
				System.exit(0);
				break;

			case 6:
				System.out.println("Enter Category ID:");
				int cid = sc.nextInt();
				sc.nextLine(); // consume newline

				List<Product> products1 = categoryService.getProductsInCategory(cid);
				if (products1.isEmpty()) {
					System.out.println(" No products found in this category.");
				} else {
					System.out.println(" Products in category:");
					for (Product p : products1) {
						System.out.println(p);
					}
				}
				System.exit(0);
				break;

			case 7:
				List<Order> orders = orderService.getAllOrders();
				if (orders.isEmpty()) {
					System.out.println("No orders found.");
				} else {
					System.out.println("*********************************************");
					System.out.println("List of all Orders:");
					for (Order o : orders) {
						System.out.println("Order ID: " + o.getId() + ", User: " + o.getUser().getUserName() + ", Date: " + o.getOrderDate());
						System.out.println("Products in Order:");
						for (Product p : o.getProducts()) {
							System.out.println("- " + p.getName() + " ($" + p.getPrice() + ")");
						}
					}
					System.out.println("*********************************************");
				}
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option. Please try again.");
				break;
		}
	}
}
