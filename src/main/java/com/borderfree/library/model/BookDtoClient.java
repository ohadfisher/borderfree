package com.borderfree.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class BookDtoClient {

    private String isbn;

    private String author;

    private String name;


    public static BookDtoClient from(BookEntity bookEntity) {
        return new BookDtoClient(bookEntity.getIsbn(), bookEntity.getAuthor(), bookEntity.getName());
    }
}
