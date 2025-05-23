package com.aditya.Library.main;

import com.aditya.Library.Beans.Book;
import com.aditya.Library.Beans.LibraryService;
import com.aditya.Library.config.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		LibraryService ls = context.getBean(LibraryService.class);
		ls.showLibrary();
		ls.setBook(new Book("SpringBoot Era"));
		ls.showLibrary();
	}

}
