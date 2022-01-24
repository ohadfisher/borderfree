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


// todo comment:  Name of the class need to be *LibraryController*


// todo comment:  Change the BookService -> LibraryService

// todo comment:  Not suppose to be any logic at the controller

// todo comment:  We not suppose to get and send any Entity(like BookEntity) from the controller,
//  we need to create requestBook & responseBook


        // todo comment:  Change the @RequestMapping("/borderfree/lLibrary/")
@RestController
@RequestMapping("/api")
public class BookController {

        // todo comment:   change the convention of name all_books -> allBooks
    private List<BookEntity> all_books;

        // todo comment:  change the name of the class BookService -> LibraryService
    @Autowired
    private BookService service;


        // todo comment:  not suppose to hold the repository at controller,
        //  because logic not suppose to be at controller at all.
    @Autowired
    private BookRepository bookRepository;





        //todo comment: @ResponseStatus with ACCEPTED is mean the request *just been accepted* and the OK mean its *Pass*,
        // so its wrong to return it instead the real response status that can be change biased on the success of the process
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/get-all-books")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        // todo comment: all_book need to be inside the method and not outside at the class section,
        //  Unless we like to manage cache

        // todo comment: the method service.getAllBooks not need to get any parameter (and for shor not to send null)

        // todo comment: can manage cache,
        //  by saving when was last update and if its "soon" get  "all_books" with out the getting from DB

        all_books = service.getAllBooks(null);
        // todo comment:  return ResponseEntity base on the result ok/badRequest...
        return ResponseEntity.ok(all_books);
    }









    // todo comment:  validate author parameter and pass to the method below with filtering



        // todo comment:  controller not suppose to deal with logic

        //todo comment: @ResponseStatus with ACCEPTED is mean the request *just been accepted* and the OK mean its *Pass*,
        // so its wrong to return it instead the real response status that can be change biased on the success of the process
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/get-all-books-author")
        //todo comment: @RequestBody-> RequestParam OR PathVariable
    public ResponseEntity<List<BookEntity>> getAllBooksAuthor(@RequestBody String author) {
            //todo comment: validate param (=author)

            //todo comment: not need to be here logic, any way better to filter by author and not get all

            // todo comment: call the getAllBooks method that can manage cache
        all_books = bookRepository.findAll();

        List<BookEntity> books = new LinkedList<>();
            //todo comment: for-> forItch OR stream with filtering
        for (int i = 0; i < all_books.size(); i++) {
            BookEntity b1 = all_books.get(i);

            // and then only find for author
            if (b1.getAuthor().equals(author)) books.add(b1);
        }
        // todo comment:  return ResponseEntity base on the result ok/badRequest...
        return ResponseEntity.ok(books);
    }



        //todo comment: @ResponseStatus with ACCEPTED is mean the request *just been accepted* and the OK mean its *Pass*,
        // so its wrong to return it instead the real response status that can be change biased on the success of the process
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/readers")
    public ResponseEntity<List<Reader>> getReaders() {
        // todo comment:  return ResponseEntity base on the result ok/badRequest...
        return ResponseEntity.ok(service.getReaders());


    }

    // todo comment:  Add controllerAdvise OR  @ExceptionHandler of spring that will catch the exceptions and  inform the client



}
