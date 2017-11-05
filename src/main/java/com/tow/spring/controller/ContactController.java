package com.tow.spring.controller;

import com.tow.spring.model.Contact;
import com.tow.spring.model.Contacts;
import com.tow.spring.repositories.ContactService;
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
public class ContactController {

    @Autowired
    @Qualifier("contactService")
    private ContactService contactService;

    @Autowired
    @Qualifier("jaxContext")
    private JAXBContext jaxbContext;

    @GetMapping(path = "json",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
//            headers = {HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE, MediaType.TEXT_XML_VALUE})
//    @ResponseBody
    public Contacts findAll() {
        return new Contacts(contactService.findAll());
    }

    @GetMapping(path = "xml",
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String getXml() throws JAXBException {
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(new Contacts(contactService.findAll()), System.out);
        StringWriter result = new StringWriter();
        jaxbMarshaller.marshal(new Contacts(contactService.findAll()), result);
        return result.toString();
    }
// @GetMapping(path = {"all", "all.json","all.xml"},consumes = {MediaType.},produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")

    @GetMapping("count")
    @ResponseBody
    public String count() {
        return contactService.count().toString();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Contact findAll(
            @PathVariable(name = "id")
            @Nullable Long id) {
        return contactService.findById(id);
    }

    @GetMapping("create")
    public String create(
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            Model model) {
        String results = null;
        if (firstName != null || lastName != null) {
            Contact contact = new Contact(firstName, lastName);
            contactService.save(contact);
            results = contact.toString();
        }
        return results;
    }

    @GetMapping("remove/{id}")
    @ResponseBody
    public String remove(
            @PathVariable(name = "id", required = false) Long id) {
        String results = "redirect:/all";
        contactService.delete(id);
        return results;
    }

    @GetMapping("index2")
    public String index() {
        return "all";
    }
}
