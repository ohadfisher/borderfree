package com.borderfree.library.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */


// todo comment: its feel like the object here is miss the list of books (????)

@Data
@Document("Readers")
public class ReaderEntity {

    @Id //todo need be unique @Column(unique = true)
    private String id;

    private String firstName;

    private String lastName;

}
