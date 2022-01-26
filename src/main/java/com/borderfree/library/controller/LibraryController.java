package com.borderfree.library.controller;

import com.borderfree.library.model.BookDtoClient;
import com.borderfree.library.model.BookEntity;
import com.borderfree.library.model.ReaderDtoClient;
import com.borderfree.library.model.ReaderEntity;
import com.borderfree.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private Function<List<BookEntity>, List<BookDtoClient>> convertListOfBookEntityToBookDto =
            bookEntityList -> bookEntityList.stream().map(BookDtoClient::from)
                    .collect(Collectors.toList());
    private Function<List<ReaderEntity>, List<ReaderDtoClient>> convertListOfReaderEntityToReaderDto =
            readerEntityList -> readerEntityList.stream().map(ReaderDtoClient::from)
                    .collect(Collectors.toList());

    @GetMapping("/books")
    public ResponseEntity<List<BookDtoClient>> getAllBooks() {
        return ResponseEntity.ok(convertListOfBookEntityToBookDto.apply(service.getAllBooks()));
    }

    @GetMapping("/books-author")
    public ResponseEntity<List<BookDtoClient>> getAllBooksAuthor(@RequestParam String author) {
        if (author.isEmpty()) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        return ResponseEntity.ok(convertListOfBookEntityToBookDto.apply(service.getAllBooksByAuthor(author)));
    }


    @GetMapping("/readers")
    public ResponseEntity<List<ReaderDtoClient>> getReaders() {
        return ResponseEntity.ok(convertListOfReaderEntityToReaderDto.apply(service.getReaders()));
    }


    @GetMapping("/reader-by-full-name")
    public ResponseEntity<ReaderDtoClient> getReaderByFullName(@RequestParam String firstName, @RequestParam String lastName) {
        return ResponseEntity.ok(ReaderDtoClient.from(service.getReaderByFullName(firstName, lastName)));
    }


    @PostMapping("/reader")
    public ResponseEntity<ReaderDtoClient> createReader(@RequestBody ReaderDtoClient readerDtoClient) {
        return ResponseEntity.ok(ReaderDtoClient.from(service.createReader(ReaderEntity.from(readerDtoClient))));
    }

    @PutMapping("/reader/{id}")
    public ResponseEntity<ReaderDtoClient> updateReader(@RequestBody ReaderDtoClient readerDtoClient, @PathVariable String id) {
        return ResponseEntity.ok(ReaderDtoClient.from(service.upsertReader(ReaderEntity.from(readerDtoClient), id)));
    }

    @DeleteMapping("/reader/{id}")
    public ResponseEntity<Void> removeReaderById(@PathVariable String id) {
        service.removeReaderById(id);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/reader-by-full-name")
    public ResponseEntity<Void> removeReaderByFullName(@RequestParam String firstName, @RequestParam String lastName) {
        service.removeReaderByFullName(firstName, lastName);
        return ResponseEntity.ok().build();
    }

}
