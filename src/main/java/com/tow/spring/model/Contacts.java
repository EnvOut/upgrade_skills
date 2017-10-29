package com.tow.spring.model;

import java.io.Serializable;
import java.util.List;

public class Contacts implements Serializable {
    private List<Contact> contacts;

    public Contacts() {
    }

    public Contacts(List<Contact> contacts) {

        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contacts setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        return this;
    }
}
