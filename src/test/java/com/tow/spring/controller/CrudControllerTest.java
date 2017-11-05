package com.tow.spring.controller;

import com.tow.spring.model.Contact;
import com.tow.spring.model.Contacts;
import com.tow.spring.repositories.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrudControllerTest {
    private final List<Contact> contacts = new ArrayList<Contact>();

    @Before
    public void initialContacts() {
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("Chris");
        contact.setLastName("Schaefer");
        contacts.add(contact);
    }

    @Test
    public void findAll() throws Exception {
        ContactService contactService = mock(ContactService.class);
        when(contactService.findAll()).thenReturn(contacts);

        ContactController contactController = new ContactController();
        ReflectionTestUtils.setField(contactController, "contactService", contactService);
        ExtendedModelMap uiModel = new ExtendedModelMap();
        uiModel.addAttribute("contacts", contactController.findAll());

        Contacts modelContacts = (Contacts) uiModel.get("contacts");
        assertEquals(1, modelContacts.getContacts().size());
    }
}