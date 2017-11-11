package com.tow.spring.mvc.repository;

import com.tow.spring.mvc.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    public Person findByFirstName(String firstName);

    public List<Person> findByLastName(String lastName);
}
