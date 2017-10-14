package com.tow.spring.jdbc.dao;

import com.tow.spring.jdbc.models.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(Contact contact);
    void update(Contact contact);
    void delete(Long contactId);
}
