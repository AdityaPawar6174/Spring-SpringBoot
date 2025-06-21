package com.aditya.Library.config;

import com.aditya.Library.Beans.Book;
import com.aditya.Library.Beans.LibraryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.aditya")
public class AppConfig {

    @Bean
    public LibraryService libraryService(){
        return new LibraryService();
    }

    @Bean
    public Book book(){
        return new Book();
    }
}

