package com.borderfree.library.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Copyright &copy; 2021 by Borderfree, Pitney Bowes.
 * The project is for test assignment only. Distribution of the project is prohibited.
 */

@Document
public class Reader {

    @Id
    private String id;

    private String firstName;

    private String lastName;

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

    @Override
    public String toString() {
        return "Reader{" +
                "id='" + id + '\'' +
                ", fullName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
