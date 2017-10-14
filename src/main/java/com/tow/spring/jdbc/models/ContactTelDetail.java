package com.tow.spring.jdbc.models;

import java.io.Serializable;

public class ContactTelDetail implements Serializable{
    private Long id;
    private Long contactId;
    private String telType;
    private String telNumber;

    @Override
    public String toString() {
        return "ContactTelDetail{" +
                "id=" + id +
                ", contactId=" + contactId +
                ", telType='" + telType + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public ContactTelDetail setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getContactId() {
        return contactId;
    }

    public ContactTelDetail setContactId(Long contactId) {
        this.contactId = contactId;
        return this;
    }

    public String getTelType() {
        return telType;
    }

    public ContactTelDetail setTelType(String telType) {
        this.telType = telType;
        return this;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public ContactTelDetail setTelNumber(String telNumber) {
        this.telNumber = telNumber;
        return this;
    }
}
