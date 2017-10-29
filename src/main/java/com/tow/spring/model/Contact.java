package com.tow.spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

public class Contact implements Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public Contact setId(Long id) {
        this.id = id;
        return this;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public Contact setVersion(int version) {
        this.version = version;
        return this;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Contact setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}