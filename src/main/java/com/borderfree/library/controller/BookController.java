package com.borderfree.library.controller;

import com.borderfree.library.domain.BookEntity;
import com.borderfree.library.domain.Reader;
import com.borderfree.library.repository.BookRepository;
import com.borderfree.library.service.BookService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */

@RestController
@RequestMapping("/api")
public class BookController {

    private List<BookEntity> all_books;

    @Autowired
    private BookService service;

    @Autowired
    private BookRepository bookRepository;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/get-all-books")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        all_books = service.getAllBooks(null);
        return ResponseEntity.ok(all_books);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/get-all-books-author")
    public ResponseEntity<List<BookEntity>> getAllBooksAuthor(@RequestBody String author) {
        // let's first take all
        all_books = bookRepository.findAll();

        List<BookEntity> books = new LinkedList<>();
        for (int i = 0; i < all_books.size(); i++) {
            BookEntity b1 =all_books.get(i);

            // and then only find for author
            if (b1.getAuthor().equals(author)) books.add(b1);
        }
        return ResponseEntity.ok(books);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/readers")
    public ResponseEntity<List<Reader>> getReaders() {
        return ResponseEntity.ok(service.getReaders());


    }


}
