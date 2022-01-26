package com.borderfree.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReaderDtoClient {

    private String id;

    private String firstName;

    private String lastName;

    public static ReaderDtoClient from(ReaderEntity readerEntity) {
        return new ReaderDtoClient(readerEntity.getId(), readerEntity.getFirstName(), readerEntity.getLastName());
    }
}
