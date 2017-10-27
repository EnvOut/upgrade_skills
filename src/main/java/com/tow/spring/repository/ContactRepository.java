package com.tow.spring.repository;

import com.tow.spring.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findFirstName(String firstName);
}
