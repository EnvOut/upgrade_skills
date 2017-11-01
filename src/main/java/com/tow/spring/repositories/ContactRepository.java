package com.tow.spring.repositories;

import com.tow.spring.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("contactRepository")
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
