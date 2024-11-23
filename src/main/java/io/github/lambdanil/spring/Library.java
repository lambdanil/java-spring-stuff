package io.github.lambdanil.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class Library {
    private final static AtomicLong counter = new AtomicLong();
    private static ArrayList<Book> books = new ArrayList<Book>();

    public Library() {
    }

    public Library(ArrayList<Book> books) {
        this.books = (ArrayList<Book>) books.clone();
    }

    public void addBook(Book book) {
        book.setId(counter.incrementAndGet());
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return books.toString();
    }
}
