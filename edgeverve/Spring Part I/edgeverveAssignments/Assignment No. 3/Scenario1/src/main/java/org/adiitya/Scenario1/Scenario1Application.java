package org.adiitya.Scenario1;

import org.adiitya.Scenario1.beans.Author;
import org.adiitya.Scenario1.beans.Book;
import org.adiitya.Scenario1.beans.LibraryBranch;
import org.adiitya.Scenario1.beans.Publisher;
import org.adiitya.Scenario1.services.AuthorService;
import org.adiitya.Scenario1.services.BookService;
import org.adiitya.Scenario1.services.LibraryBranchService;
import org.adiitya.Scenario1.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Scenario1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Scenario1Application.class, args);
	}

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@Autowired
	private LibraryBranchService libraryBranchService;

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 1: Add book along with authors, publisher & branches");
		System.out.println("Enter 2: View All Books and their details");
		System.out.println("Enter 3: Add an Author with Multiple Books");
		System.out.println("Enter 4: Update Book Details");
		System.out.println("Enter 5: Delete Book by ID");
		System.out.println("Enter 6: Exit");

		int option = sc.nextInt();
		sc.nextLine();

		switch (option)
		{
			case 1:

				System.out.println("Enter Book Title:");
				String title = sc.nextLine();

				System.out.println("Enter Publisher Name:");
				String publisherName = sc.nextLine();
				Publisher publisher = new Publisher(publisherName);

				System.out.println("Enter number of Authors:");
				int authorCount = sc.nextInt();
				sc.nextLine();
				List<Author> authors = new ArrayList<>();
				for (int i = 1; i <= authorCount; i++) {
					System.out.println("Enter Author "+i+" Name:");
					String authorName = sc.nextLine();
					Author author = new Author(authorName);
					authors.add(author);
				}

				System.out.println("Enter number of Library Branches:");
				int branchCount = sc.nextInt();
				sc.nextLine();
				List<LibraryBranch> branches = new ArrayList<>();
				for (int i = 1; i <= branchCount; i++) {
					System.out.println("Enter Branch "+i+" Name:");
					String branchName = sc.nextLine();
					System.out.println("Enter Branch "+i+" Address:");
					String branchAddress = sc.nextLine();
					LibraryBranch branch = new LibraryBranch(branchName, branchAddress);
					branches.add(branch);
				}

				Book book = new Book(title);
				book.setPublisher(publisher);
				book.setAuthors(authors);
				book.setLibraryBranches(branches);
				bookService.addBook(book);
				System.out.println("Book added successfully!");
				System.exit(0);
				break;

			case 2:

				List<Book> bookList = bookService.getAllBooks();
				if (bookList.isEmpty()) {
					System.out.println("No books found.");
				} else {
					for (Book b : bookList) {
						System.out.println("-----------------------------");
						System.out.println("Title: " + b.getTitle());
						System.out.println("Publisher: " + b.getPublisher().getName());
						System.out.println("Authors: ");
						for (Author a : b.getAuthors()) {
							System.out.println(" - " + a.getName());
						}
						System.out.println("Branches: ");
						for (LibraryBranch lb : b.getLibraryBranches()) {
							System.out.println(" - " + lb.getName() + " (" + lb.getLocation() + ")");
						}
						System.out.println("-----------------------------");
					}
				}
				System.exit(0);
				break;

			case 3:

				System.out.println("Enter Author Name:");
				String authorName = sc.nextLine();

				System.out.println("Enter number of Books for this Author:");
				int bookCount = sc.nextInt();
				sc.nextLine();

				List<Book> books = new ArrayList<>();
				for (int i = 1; i <= bookCount; i++) {
					System.out.println("Enter Details For the Book:"+i);

					System.out.println("Enter Book Title:");
					String bookTitle = sc.nextLine();

					// Publisher
					System.out.println("Enter Publisher Name of this Book:");
					String bookPublisherName = sc.nextLine();
					Publisher bookPublisher = new Publisher(bookPublisherName);

					// Branches
					System.out.println("Enter number of Library Branches for this Book:");
					int bookBranchCount = sc.nextInt();
					sc.nextLine();
					List<LibraryBranch> bookBranches = new ArrayList<>();
					for (int j=1; j <= bookBranchCount; j++){
						System.out.println("Enter Branch "+j+" Name:");
						String bookBranchName = sc.nextLine();
						System.out.println("Enter Branch "+j+" Address:");
						String bookBranchAddress = sc.nextLine();
						LibraryBranch bookBranch = new LibraryBranch(bookBranchName, bookBranchAddress);
						bookBranches.add(bookBranch);
					}

					// Book object
					Book book1 = new Book(bookTitle);
					book1.setTitle(bookTitle);
					book1.setPublisher(bookPublisher);
					book1.setLibraryBranches(bookBranches);
					books.add(book1);
				}

				Author newAuthor = new Author(authorName);
				newAuthor.setBookList(books);

				authorService.addAuthor(newAuthor);

				System.out.println("Author with books added successfully!");
				System.exit(0);
				break;

			case 4:
				System.out.println("Enter Book ID to update:");
				int bookId = sc.nextInt();
				sc.nextLine();
				Book bookToUpdate = bookService.getBookById(bookId);
				if (bookToUpdate == null) {
					System.out.println("Book not found with ID: " + bookId);
					System.exit(0);
				}
				System.out.println("Current Title: " + bookToUpdate.getTitle());
				System.out.println("Enter new Title (or press Enter to keep current):");
				String newTitle = sc.nextLine();
				if (!newTitle.isEmpty()) {
					bookToUpdate.setTitle(newTitle);
				}
				System.out.println("Current Publisher: " + bookToUpdate.getPublisher().getName());
				System.out.println("Enter new Publisher Name (or press Enter to keep current):");
				String newPublisherName = sc.nextLine();
				if (!newPublisherName.isEmpty()) {
					Publisher newPublisher = new Publisher(newPublisherName);
					bookToUpdate.setPublisher(newPublisher);
				}
				System.out.println("Current Authors: ");
				for (Author author : bookToUpdate.getAuthors()) {
					System.out.println(" - " + author.getName());
				}
				System.out.println("Enter new Authors (comma separated, or press Enter to keep current):");
				String newAuthorsInput = sc.nextLine();

				if (!newAuthorsInput.isEmpty()) {
					String[] newAuthors = newAuthorsInput.split(",");
					List<Author> authorList = new ArrayList<>();
					for (String authorNameInput : newAuthors) {
						Author author = new Author(authorNameInput.trim());
						authorList.add(author);
					}
					bookToUpdate.setAuthors(authorList);
				}
				System.out.println("Current Library Branches: ");
				for (LibraryBranch branch : bookToUpdate.getLibraryBranches()) {
					System.out.println(" - " + branch.getName() + " (" + branch.getLocation() + ")");
				}
				System.out.println("Enter new Library Branches (comma separated, or press Enter to keep current):");
				String newBranchesInput = sc.nextLine();
				if (!newBranchesInput.isEmpty()) {
					String[] newBranches = newBranchesInput.split(",");
					List<LibraryBranch> branchList = new ArrayList<>();
					for (String branchInput : newBranches) {
						String[] branchDetails = branchInput.trim().split(":");
						if (branchDetails.length == 2) {
							LibraryBranch branch = new LibraryBranch(branchDetails[0].trim(), branchDetails[1].trim());
							branchList.add(branch);
						} else {
							System.out.println("Invalid branch format. Use 'Name:Address'.");
						}
					}
					bookToUpdate.setLibraryBranches(branchList);
				}
				bookService.updateBook(bookToUpdate);
				System.out.println("Book updated successfully!");
				System.exit(0);
				break;

			case 5:
				System.out.println("Enter Book ID to delete:");
				int deleteBookId = sc.nextInt();
				sc.nextLine();

				Book bookToDelete = bookService.getBookById(deleteBookId);
				if (bookToDelete == null) {
					System.out.println("Book not found with ID: " + deleteBookId);
					System.exit(0);
				}

				bookService.deleteBook(deleteBookId);
				System.out.println("Book with ID " + deleteBookId + " deleted successfully!");
				System.exit(0);
				break;

			case 6:
				System.out.println("Exiting the application.");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option selected. Please try again.");
				System.exit(0);
				break;
		}
	}
}
