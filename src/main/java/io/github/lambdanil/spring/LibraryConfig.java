package io.github.lambdanil.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class LibraryConfig {
    @Bean(name="library")
    public Library getLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("1984", "Orwell", 1999));
        return new Library(books);
    }
}
