package com.example.contactslist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@RequiredArgsConstructor
@FieldNameConstants
public class Contact {

    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
}
