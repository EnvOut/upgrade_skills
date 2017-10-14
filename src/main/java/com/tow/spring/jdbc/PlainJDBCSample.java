package com.tow.spring.jdbc;

import com.tow.spring.jdbc.dao.ContactDAO;
import com.tow.spring.jdbc.dao.PlainContactDao;
import com.tow.spring.jdbc.models.Contact;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static java.lang.System.out;

public class PlainJDBCSample {
    private static ContactDAO contactDAO = new PlainContactDao();

    public static void main(String[] args) {
        out.println("Listiong initial contact data");
        listAllContacts();

        out.println();
        out.println("Insert new contact");
        Contact contact = new Contact();
        contact.setFirstName("Jacky");
        contact.setLastName("Chan");
        contact.setBirthDate(new Date((new GregorianCalendar(2001, 10, 1)).getTime().getTime()));
        contactDAO.insert(contact);
        out.println();
        out.println("List contact data after new contact created");
        listAllContacts();

        out.println("Deleting previous created contact");
        contactDAO.delete(contact.getId());

        out.println("Listing contact data after new contact deleted:");
        listAllContacts();
    }

    private static void listAllContacts() {
        List<Contact> contacts = contactDAO.findAll();

        for (Contact contact : contacts) {
            out.println(contact);
        }
    }
}
