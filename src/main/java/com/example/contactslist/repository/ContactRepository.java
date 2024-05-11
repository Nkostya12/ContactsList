package com.example.contactslist.repository;


import com.example.contactslist.model.Contact;

import java.util.List;

public interface ContactRepository {

    Contact addContact();

    Contact findById(long id);

    List<Contact> getAllContact();


}
