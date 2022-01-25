package com.borderfree.library.repository;

import com.borderfree.library.model.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */

public interface BookRepository extends MongoRepository<BookEntity, String> {
    List<BookEntity> findByAuthorLike(String author);
}
