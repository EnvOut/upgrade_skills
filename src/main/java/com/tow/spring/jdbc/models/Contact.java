package com.tow.spring.jdbc.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Contact implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<ContactTelDetail> contactTelDetail;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", contactTelDetail=" + contactTelDetail +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Contact setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Contact setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public List<ContactTelDetail> getContactTelDetail() {
        return contactTelDetail;
    }

    public Contact setContactTelDetail(List<ContactTelDetail> contactTelDetail) {
        this.contactTelDetail = contactTelDetail;
        return this;
    }

}
