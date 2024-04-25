package com.example.contactslist.repository;


import com.example.contactslist.model.Contact;

public interface ContactRepository {

    Contact addContact();

    Contact findById(long id);


}
