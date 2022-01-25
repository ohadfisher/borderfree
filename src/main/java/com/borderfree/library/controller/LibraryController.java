package com.borderfree.library.controller;

import com.borderfree.library.model.BookDto;
import com.borderfree.library.model.BookEntity;
import com.borderfree.library.model.ReaderDto;
import com.borderfree.library.model.ReaderEntity;
import com.borderfree.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */


@RestController
@RequestMapping("/borderfree/lLibrary/")
public class LibraryController {

    @Autowired
    private LibraryService service;


    @GetMapping("/get-all-books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(convertListOfBookEntityToBookDto.apply(service.getAllBooks()));
    }

    @GetMapping("/get-all-books-author")
    public ResponseEntity<List<BookDto>> getAllBooksAuthor(@RequestParam String author) {
        if (author.isEmpty()) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        return ResponseEntity.ok(convertListOfBookEntityToBookDto.apply(service.getAllBooksAuthor(author)));
    }

    @GetMapping("/readers")
    public ResponseEntity<List<ReaderDto>> getReaders() {
        return ResponseEntity.ok(convertListOfReaderEntityToReaderDto.apply(service.getReaders()));
    }


    // todo comment:  Add controllerAdvise OR @ExceptionHandler of spring that will catch the exceptions and  inform the client
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The request failed:(")
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException(IllegalArgumentException ex) {
        return ex.getMessage();
    }

    private Function<List<BookEntity>, List<BookDto>> convertListOfBookEntityToBookDto =
            bookEntityList -> bookEntityList.stream().map(BookDto::from)
                    .collect(Collectors.toList());
    private Function<List<ReaderEntity>, List<ReaderDto>> convertListOfReaderEntityToReaderDto =
            readerEntityList -> readerEntityList.stream().map(ReaderDto::from)
                    .collect(Collectors.toList());

}
