package com.borderfree.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class BookDto {

    private String isbn;

    private String author;

    private String name;


    public static BookDto from(BookEntity bookEntity) {
        return new BookDto(bookEntity.getIsbn(), bookEntity.getAuthor(), bookEntity.getName());
    }
}
