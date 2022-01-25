package com.borderfree.library.service;

import com.borderfree.library.model.BookEntity;
import com.borderfree.library.model.ReaderEntity;
import com.borderfree.library.repository.BookRepository;
import com.borderfree.library.repository.ReadersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */


@Service
@RequiredArgsConstructor
public class LibraryService {

    private final BookRepository bookRepository;
    private final ReadersRepository readersRepository;

    // todo comment: the method service.getAllBooks, not need to get any parameter
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    //todo comment: Change the name of the method: getReaders -> getAllReaders
    public List<ReaderEntity> getReaders() {
        return readersRepository.findAll();
    }

    public List<BookEntity> getAllBooksAuthor(String author) {
        return bookRepository.findByAuthorLike(author);
    }
}
