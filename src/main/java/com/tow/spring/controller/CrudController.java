package com.tow.spring.controller;

import com.google.common.collect.Lists;
import com.tow.spring.model.Contact;
import com.tow.spring.model.Contacts;
import com.tow.spring.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

@RestController
public class CrudController {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("jaxContext")
    private JAXBContext jaxbContext;

    @GetMapping(path = "json",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
//            headers = {HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE, MediaType.TEXT_XML_VALUE})
//    @ResponseBody
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @GetMapping(path = "xml",
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String getXml() throws JAXBException {
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(new Contacts(Lists.newArrayList(contactRepository.findAll())), System.out);
        StringWriter result = new StringWriter();
        jaxbMarshaller.marshal(new Contacts(Lists.newArrayList(contactRepository.findAll())), result);
        return result.toString();
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
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            Model model) {
        String results = null;
        if (firstName != null || lastName != null) {
            Contact contact = new Contact(firstName, lastName);
            contactRepository.save(contact);
            results = contact.toString();
        }
        return results;
    }

    @GetMapping("remove/{id}")
    @ResponseBody
    public String remove(
            @PathVariable(name = "id", required = false) Long id) {
        String results = "redirect:/all";
        contactRepository.delete(id);
        return results;
    }

    @GetMapping("index2")
    public String index() {
        return "all";
    }
}
