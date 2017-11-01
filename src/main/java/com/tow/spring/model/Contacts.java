package com.tow.spring.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "contacts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contacts implements Serializable {
    @XmlElement(name = "contact")
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
