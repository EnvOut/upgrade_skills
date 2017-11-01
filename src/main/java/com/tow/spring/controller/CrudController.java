package com.tow.spring.controller;

import com.sun.istack.internal.Nullable;
import com.tow.spring.model.Contact;
import com.tow.spring.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrudController {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @GetMapping("all")
    @ResponseBody
    public String findAll() {
        return contactRepository.findAll().toString();
    }

    @GetMapping("count")
    @ResponseBody
    public String count() {
        String all = contactRepository.findAll().toString();

        return new Long(contactRepository.count()).toString();
    }

    @GetMapping("{id}")
    @ResponseBody
    public String findAll(
            @PathVariable(name = "id")
            @Nullable Long id) {
        return contactRepository.findOne(id).toString();
    }

    @GetMapping("create")
    public String create(
            @RequestParam("firstName") @Nullable String firstName,
            @RequestParam("lastName") @Nullable String lastName,
            Model model
    ) {
        String results = null;
        if (firstName != null || lastName != null) {
            Contact contact = new Contact(firstName, lastName);
            contactRepository.save(contact);
            results = contact.toString();
        }
        return results;
    }

    @GetMapping("remove/{id}")
    public String remove(
            @PathVariable(name = "id")
            @Nullable Long id
    ) {
        String results = "redirect:/all";
        if (id != null) {
            contactRepository.delete(id);
        }
        return results;
    }
    @GetMapping("index2")
    public String index(){
        return "all";
    }
}
