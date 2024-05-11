package com.example.contactslist.controller;


import com.example.contactslist.model.Contact;
import com.example.contactslist.repository.CommandRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping
public class MainController {


    @Autowired
    private CommandRepository commandRepository;


    @GetMapping("/")
    public String index(Model model) {


        model.addAttribute("contacts", commandRepository.getAllContact());

        return "/index";
    }

    @GetMapping("/create")
    public String createForm(Model model, Contact contact) {
        //model.addAttribute(contact);
        return "/create";
    }

    @PostMapping("/create")
    public String createNewContact(@ModelAttribute Contact contact) {


        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editeForm(@PathVariable Long id, Model model) {


        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Contact contact) {


        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteInTable(@PathVariable Long id) {


        return "redirect:/";
    }


}
