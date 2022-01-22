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

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final ReadersRepository readersRepository;

    public List<BookEntity> getAllBooks(String author) {
        return repository.findAll();
    }

    public List<Reader> getReaders() {
        return readersRepository.findAll();
    }
}
