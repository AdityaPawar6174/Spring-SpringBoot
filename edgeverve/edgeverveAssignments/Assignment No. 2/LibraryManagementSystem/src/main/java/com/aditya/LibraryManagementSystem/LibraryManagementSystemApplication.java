package com.aditya.LibraryManagementSystem;

import com.aditya.LibraryManagementSystem.Beans.Book;
import com.aditya.LibraryManagementSystem.Services.LMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.SimpleTimeZone;

@SpringBootApplication
public class LibraryManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	@Autowired
	private LMSService lmsService;

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 1: Add new Book");
		System.out.println("Enter 2: Get Book ");
		System.out.println("Enter 3: Update Book");
		System.out.println("Enter 4: Delete Book");
		System.out.println("Enter 5: Fetch Books by Data");

		int operation = sc.nextInt();
		sc.nextLine();

		switch (operation)
		{
			case 1:
				System.out.println("Enter Book Title");
				String bookTitle = sc.nextLine();
				System.out.println("Enter Book Author");
				String bookAuthor = sc.nextLine();
				System.out.println("Enter Book Genre");
				String bookGenre = sc.nextLine();
				System.out.println("Enter Book ISBN Number");
				String bookISBN = sc.nextLine();
				System.out.println("Enter Book Publication Year");
				int bookYear = sc.nextInt();
				sc.nextLine();
				System.out.println("Is Book Available? (y/n)");
				String bookAvailability = sc.nextLine().trim().toLowerCase();
				boolean bookAvailable = bookAvailability.equals("y") || bookAvailability.equals("yes");

				Book book = new Book();
				book.setTitle(bookTitle);
				book.setAuthor(bookAuthor);
				book.setGenre(bookGenre);
				book.setIsbn(bookISBN);
				book.setPublicationYear(bookYear);
				book.setAvailable(bookAvailable);

				lmsService.addBook(book);
				break;

			case 2:
				System.out.println("Enter Book ID");
				int bookId = sc.nextInt();
				sc.nextLine();
				Book book1 = lmsService.getBookById(bookId);
				System.out.println(book1.toString());
				break;

			case 3:
				System.out.print("Enter Book ID to update: ");
				int updateId = sc.nextInt();
				sc.nextLine();
				Book updateBook = lmsService.getBookById(updateId);

				if (updateBook != null) {
					System.out.print("Is the book available? (true/false): ");
					boolean avail = sc.nextBoolean();
					updateBook.setAvailable(avail);
					lmsService.updateBook(updateBook);
					System.out.println("Book updated successfully.");
				} else {
					System.out.println("Book not found.");
				}
				break;

			case 4:
				System.out.print("Enter Book ID to delete: ");
				int deleteId = sc.nextInt();
				sc.nextLine();
				lmsService.deleteBook(deleteId);
				System.out.println("Book deleted successfully.");
				break;

			case 5:
				System.out.println("1. By Author\n2. By Genre\n3. After Year");
				int opt = sc.nextInt();
				sc.nextLine();

				if (opt == 1) {
					System.out.print("Enter Author: ");
					String auth = sc.nextLine();
					lmsService.getBooksByAuthor(auth).forEach(System.out::println);
				} else if (opt == 2) {
					System.out.print("Enter Genre: ");
					String gen = sc.nextLine();
					lmsService.getBooksByGenre(gen).forEach(System.out::println);
				} else if (opt == 3) {
					System.out.print("Enter Year: ");
					int yr = sc.nextInt();
					lmsService.getBooksAfterYear(yr).forEach(System.out::println);
				} else {
					System.out.println("Invalid Option");
				}
				break;

			default:
				System.err.println("Invalid Input...!!!");
		}
	}
}
