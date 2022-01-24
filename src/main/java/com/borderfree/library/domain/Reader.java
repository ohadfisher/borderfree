package com.borderfree.library.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */

// todo comment: Change the name Reader -> ReaderEntry


// todo comment: Use lombok Data + noArgsConstructor



// todo comment: its feel like the object here is miss the list of books (????)



//todo comment: @Document -> @Document("Readers")
//todo comment: readr-> readerEntity
@Document
public class Reader {

    @Id //todo need be unique @Column(unique = true)
    private String id;

    private String firstName;

    private String lastName;


    // todo comment use lombok data all under this line need to be removed

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }




    public void setFirstName(String firstName) {
        this.firstName =firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    //not need
    @Override
    public String toString() {
        return "Reader{" +
                "id='" + id + '\'' +
                ", fullName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
