package com.example.contactslist.repository;

import com.example.contactslist.model.Contact;
import com.example.contactslist.repository.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@RequiredArgsConstructor
@Slf4j
public class CommandRepository implements ContactRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Contact addContact() {



        return null;
    }

    @Override
    public Contact findById(long id) {
        String sql="SELECT * FROM contacts-list WHERE id=?";
        jdbcTemplate.query(sql, new ContactMapper());

        return null;
    }
}
