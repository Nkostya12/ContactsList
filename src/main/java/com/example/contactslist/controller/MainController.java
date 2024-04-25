package com.example.contactslist.controller;


import com.example.contactslist.model.Contact;
import com.example.contactslist.repository.CommandRepository;

import com.example.contactslist.repository.ListRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;


@Controller
@RequestMapping
public class MainController {
    private CommandRepository commandRepository;

    @Autowired
    private ListRepositiry listRepositiry;


    @GetMapping("/")
    public String index(Model model) {

        List<Contact> contacts = listRepositiry.getList();
        model.addAttribute("contacts", contacts);

        return "/index";
    }

    @GetMapping("/create")
    public String createForm(Model model, Contact contact) {
        model.addAttribute(contact);
        return "/create";
    }

    @PostMapping("/create")
    public String createNewContact(@ModelAttribute Contact contact) {
        System.out.println(contact.toString());

        contact.setId(new Random().nextLong(1000));
        listRepositiry.getList().add(contact);

        return "redirect:/";
    }

    @GetMapping("/edit{id}")
    public String editeForm(@PathVariable Long id, Model model) {

        model.addAttribute("contact", listRepositiry.getList().stream().filter(c -> c.getId() == id).findFirst().get());

        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Contact contact) {

        Contact oldContact = listRepositiry.getList().stream().filter(c -> c.getId() == contact.getId()).findFirst().get();

        oldContact.setFirstname(contact.getFirstname());
        oldContact.setLastname(contact.getLastname());
        oldContact.setEmail(contact.getEmail());
        oldContact.setPhone(contact.getPhone());

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteInTable(@PathVariable Long id) {
        listRepositiry.getList().remove(listRepositiry.getList().stream().filter(s -> s.getId() == id).findAny().get());
        return "redirect:/";
    }

    @GetMapping("/create/{id}")
    public String create(@PathVariable Long id, Model model) {
        model.addAttribute(listRepositiry.getList().stream().filter(c -> c.getId() == id).findAny().get());
        return "/create";
    }


}
