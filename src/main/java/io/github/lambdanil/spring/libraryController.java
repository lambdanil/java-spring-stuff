package io.github.lambdanil.spring;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.http.*;

@RestController
public class libraryController {
    private Environment env;
    private final AtomicLong counter = new AtomicLong();

    private static Library library;

    @Autowired
    public void setLibrary(Library mylibrary) {
        library = mylibrary;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") String id) {
        long real_id = Long.parseLong(id);
        Book b = findById(real_id);
        if (b.getName() != null) {
            return new ResponseEntity<>(b, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/books")
    public ResponseEntity<Library> getLibrary() {
        return new ResponseEntity<>(library, HttpStatus.OK);
    }

    @PostMapping("/book/add")
    public ResponseEntity<String> addBook(@RequestBody String response) {
        Gson gson = new Gson();
        Book b = null;
        b = (Book)gson.fromJson(response, Book.class);
        if (b.getName() != null) {
            library.addBook(b);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> delBook(@PathVariable("id") String id) {
        Iterator<Book> itr = library.getBooks().iterator();
        long real_id = Long.parseLong(id);
        while (itr.hasNext()) {
            long bookID = itr.next().getId();
            if (real_id == bookID) {
                itr.remove();
                return new ResponseEntity<>("OK", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("404 Not Found", HttpStatus.NOT_FOUND);
    }

    private Book findById(long id) {
        Book f = new Book();
        for (Book b : library.getBooks()) {
            if (id == b.getId()) {
                f = b;
                break;
            }
        }
        return f;
    }
}
