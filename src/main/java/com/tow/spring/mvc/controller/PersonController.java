package com.tow.spring.mvc.controller;

import com.google.common.collect.Lists;
import com.tow.spring.mvc.model.Person;
import com.tow.spring.mvc.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/person")
public class PersonController {
private Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/all")
    @ResponseBody
    public List<Person> getAll() {
        return Lists.newArrayList(personRepository.findAll());
    }

    @GetMapping(path = "/create")
    public ModelAndView getCreate(@ModelAttribute Person person) {
        LOG.info("/create : {}",person);
        System.out.println(person);
        personRepository.save(person);
        return new ModelAndView("redirect:" + "/person/all");
    }
}
