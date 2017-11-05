package com.tow.spring.repositories;

import com.google.common.collect.Lists;
import com.tow.spring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public class ContactService {
    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    public Long count() {
        return contactRepository.count();
    }

    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    public void delete(Long id) {
        contactRepository.delete(id);
    }

    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    public void delete(Iterable<Contact> contacts) {
        contactRepository.delete(contacts);
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Iterable<Contact> save(Iterable<Contact> contact) {
        return contactRepository.save(contact);
    }
}
