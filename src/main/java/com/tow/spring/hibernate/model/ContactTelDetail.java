package com.tow.spring.hibernate.model;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CONTACT_TEL_DETAIL")
public class ContactTelDetail implements Serializable {
    private long id;
    private int version;
    private String tel_type;
    private String tel_number;
    private Contact contact;

    public ContactTelDetail(String tel_type, String tel_number) {
        this.tel_type = tel_type;
        this.tel_number = tel_number;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public ContactTelDetail setId(long id) {
        this.id = id;
        return this;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public ContactTelDetail setVersion(int version) {
        this.version = version;
        return this;
    }

    @Column(name = "TEL_TYPE")
    public String getTel_type() {
        return tel_type;
    }

    public ContactTelDetail setTel_type(String tel_type) {
        this.tel_type = tel_type;
        return this;
    }

    @ManyToMany
    @JoinColumn(name = "CONTACT_ID")
    public Contact getContact() {
        return contact;
    }

    public ContactTelDetail setContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    @Override
    public String toString() {
        return "ContactTelDetail{" +
                "id=" + id +
                ", tel_type='" + tel_type + '\'' +
                ", tel_number='" + tel_number + '\'' +
                ", contact=" + contact +
                '}';
    }

    @Column(name = "TEL_NUMBER")
    public String getTel_number() {
        return tel_number;
    }

    public ContactTelDetail setTel_number(String tel_number) {
        this.tel_number = tel_number;
        return this;
    }
}
