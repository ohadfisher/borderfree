package com.borderfree.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.borderfree.library.util.StringUtils.standardizeString;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */


// todo comment: its feel like the object here is miss the list of books (????)

@Data
@NoArgsConstructor
@Document("Readers")
public class ReaderEntity {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    public ReaderEntity(String firstName, String lastName) {
        this.firstName = standardizeString(firstName);
        this.lastName = standardizeString(lastName);
    }

    public static ReaderEntity from(ReaderDtoClient readerDtoClient) {
        return new ReaderEntity(readerDtoClient.getFirstName(), readerDtoClient.getLastName());
    }
}
