package com.tow.spring.mvc.controller;

import com.google.common.collect.Lists;
import com.tow.spring.mvc.model.Person;
import com.tow.spring.mvc.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping(path = "/jsp")
public class JspController {

    private Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/all")
    public ModelAndView getAll() {
        LOG.debug("getAll()");
        ModelAndView mv = new ModelAndView("usersView");
        ArrayList<Person> persons = Lists.newArrayList(personRepository.findAll());
//        LOG.info("persons: {}", persons);
        mv.addObject("persons", persons);
        return mv;
    }

    @GetMapping(path = "/jquery/all")
    public ModelAndView getJQueryAll() {
        LOG.debug("getJQueryAll()");
        ModelAndView mv = new ModelAndView("ajaxPersonsView");
        return mv;
    }
}
