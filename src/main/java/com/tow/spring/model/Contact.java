package com.tow.spring.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;


    public Long getId() {
        return id;
    }

    public Contact setId(Long id) {
        this.id = id;
        return this;
    }


    public int getVersion() {
        return version;
    }

    public Contact setVersion(int version) {
        this.version = version;
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

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = new Date(1L);

//        this.version=0;
    }

    public Contact() {

    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Contact setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}