package com.tow.spring.hibernate.dao;

import com.tow.spring.hibernate.model.Contact;

import java.util.List;

public interface ContactDao {
    List findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
