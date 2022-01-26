package com.borderfree.library.service;

import com.borderfree.library.model.BookEntity;
import com.borderfree.library.model.ReaderEntity;
import com.borderfree.library.repository.BookRepository;
import com.borderfree.library.repository.ReadersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.borderfree.library.util.StringUtils.standardizeString;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */


@Service
@RequiredArgsConstructor
public class LibraryService {

    private final BookRepository bookRepository;
    private final ReadersRepository readersRepository;

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<ReaderEntity> getReaders() {
        return readersRepository.findAll();
    }

    public List<BookEntity> getAllBooksByAuthor(String author) {
        return bookRepository.findByAuthorLike(author);
    }

    public ReaderEntity getReaderByFullName(String firstName, String lastName) {
        firstName = standardizeString(firstName);
        lastName = standardizeString(lastName);
        return readersRepository.findByFirstNameAndLastName(firstName, lastName);
    }


    public ReaderEntity createReader(ReaderEntity readerEntity) {
        return readersRepository.save(readerEntity);
    }

    public void removeReaderByFullName(String firstName, String lastName) {
        firstName = standardizeString(firstName);
        lastName = standardizeString(lastName);
        readersRepository.deleteByFirstNameAndLastName(firstName, lastName);
    }

    public void removeReaderById(String id) {
        readersRepository.deleteById(id);
    }

    public ReaderEntity upsertReader(ReaderEntity readerEntityUpdate, String id) {
        return readersRepository.findById(id).map(readerEntityFromDB -> {
            readerEntityFromDB.setFirstName(readerEntityUpdate.getFirstName());
            readerEntityFromDB.setLastName(readerEntityUpdate.getLastName());
            return readersRepository.save(readerEntityFromDB);
        }).orElseGet(() -> {
            readerEntityUpdate.setId(id);
            return readersRepository.save(readerEntityUpdate);
        });
    }
}
