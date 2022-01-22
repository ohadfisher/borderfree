package com.borderfree.library.repository;

import com.borderfree.library.domain.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */

public interface ReadersRepository extends MongoRepository<Reader, String> {
}
