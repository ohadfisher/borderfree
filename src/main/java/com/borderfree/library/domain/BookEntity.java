package com.borderfree.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */

@Data
@AllArgsConstructor
@Document("books")
public class BookEntity {

    @Id
    private String isbn;

    private String author;

    private String name;

    private Integer available;

    private CatalogEntry catalog;

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
