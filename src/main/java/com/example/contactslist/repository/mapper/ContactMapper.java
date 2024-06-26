package com.example.contactslist.repository.mapper;

import com.example.contactslist.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getLong(Contact.Fields.id));
        contact.setFirstname((rs.getString(Contact.Fields.firstname)));
        contact.setLastname(rs.getString(Contact.Fields.lastname));
        contact.setEmail(rs.getString(Contact.Fields.email));
        contact.setPhone(rs.getString(Contact.Fields.phone));

        return contact;
    }
}
