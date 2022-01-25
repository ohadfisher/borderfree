package com.borderfree.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */



    // todo comment: Use lombok @NoArgConstructor


@Data
@AllArgsConstructor //use for test only
@Document("books")
public class BookEntity {

    @Id //todo comment: teed be unique @Column(unique = true)
    private String isbn;

    private String author;

    private String name;

    private Integer numberOfCopyAvailable;

    private Catalog catalog;

}
