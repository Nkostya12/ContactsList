package com.example.contactslist.repository;

import com.example.contactslist.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@RequiredArgsConstructor
public class ListRepositiry {

   private    final List<Contact> list = new ArrayList<>();


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Contact contact = new Contact();

        contact.setFirstname("ivan");
        contact.setLastname("jopovicj");
        contact.setPhone("88005553535");
        contact.setEmail("nki-12@bk.ru");


        for (int i = 0; i < 5; i++) {
            list.add(contact);
            list.get(i).setId(new Random().nextLong(1000));
        }



    }

    public List<Contact> getList(){
        return list;
    }

}
