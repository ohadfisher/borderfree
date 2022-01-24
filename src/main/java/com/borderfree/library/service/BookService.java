package com.borderfree.library.service;

import com.borderfree.library.domain.BookEntity;
import com.borderfree.library.domain.Reader;
import com.borderfree.library.repository.BookRepository;
import com.borderfree.library.repository.ReadersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */

// todo comment: Change the BookService -> LibraryService



@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final ReadersRepository readersRepository;

    // todo comment: the method service.getAllBooks, not need to get any parameter
    public List<BookEntity> getAllBooks(String author) {
        return repository.findAll();
    }

    //todo comment: Change the name of the method: getReaders -> getAllReaders
    public List<Reader> getReaders() {
        return readersRepository.findAll();
    }

    //todo comment: Add missing method that exist at he controller List<BookEntry>getAllBooksAuthor(String author)

}
