package com.example.contactslist.repository;

import com.example.contactslist.model.Contact;
import com.example.contactslist.repository.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
@Slf4j
public class CommandRepository implements ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    private ContactMapper mapper;

    @Override
    public Contact addContact() {


        return null;
    }

    @Override
    public Contact findById(long id) {
        String sql = "SELECT * FROM contacts-list WHERE id=?";
        jdbcTemplate.query(sql, new ContactMapper());

        return null;
    }

    @Override
    public List<Contact> getAllContact() {
        String sql = "SELECT * FROM Contacts";


        return jdbcTemplate.query(sql, new ContactMapper());
    }


//    @EventListener(ApplicationReadyEvent.class)
//    public void initList() {
//
//        String sql = "INSERT INTO Contacts (id, firstname, lastname, email, phone) VALUES (1, 'KONSTANTIN','NEMUDROV','NKI-12@BK.RU','89059775517')";
//        jdbcTemplate.query(sql, new ContactMapper());
//
//    }


}
