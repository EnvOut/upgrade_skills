package com.tow.spring.service;

import com.tow.spring.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    List<Contact> getByFirstName(String firstName);

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);
}
