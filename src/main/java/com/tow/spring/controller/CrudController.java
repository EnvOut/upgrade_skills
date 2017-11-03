package com.tow.spring.controller;

import com.google.common.collect.Lists;
import com.tow.spring.model.Contact;
import com.tow.spring.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import java.util.List;

@RestController
public class CrudController {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @GetMapping(path = "json",
            produces = MediaType.APPLICATION_JSON_VALUE
            )
//            headers = {HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE, MediaType.TEXT_XML_VALUE})
//    @ResponseBody
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }


// @GetMapping(path = {"all", "all.json","all.xml"},consumes = {MediaType.},produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")

    @GetMapping("count")
    @ResponseBody
    public String count() {
        String all = contactRepository.findAll().toString();

        return new Long(contactRepository.count()).toString();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Contact findAll(
            @PathVariable(name = "id")
            @Nullable Long id) {
        return contactRepository.findOne(id);
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
    public String index() {
        return "all";
    }
}
