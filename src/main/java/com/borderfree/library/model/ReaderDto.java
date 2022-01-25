package com.borderfree.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReaderDto {

    private String id;

    private String firstName;

    private String lastName;

    public static ReaderDto from(ReaderEntity readerEntity) {
        return new ReaderDto(readerEntity.getId(), readerEntity.getFirstName(), readerEntity.getLastName());
    }
}
