package com.borderfree.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */


    // todo comment:  Change package domain -> model

    // todo comment: Use lombok @NoArgConstructor


@Data
@AllArgsConstructor //use for test only
@Document("books")
public class BookEntity {

    @Id //todo comment: teed be unique @Column(unique = true)
    private String isbn;

    private String author;

    private String name;

    // todo comment:  Change name to numberOfCopyAvailable
    private Integer available;

    // todo comment change CatalogEntry to Enum
    private CatalogEntry catalog;


    // todo comment: Duplicate- already create by lombok data
    @Override
    public String toString() {
        return "BookEntity{" +
                "isbn=" + isbn +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }

}
