package com.tow.spring.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Hobby implements Serializable {
    private long hobbyId;

    private Contact contact;

    @ManyToMany
    @JoinTable(name = "CONTACT_HOBBY_DETAIL",
            joinColumns = @JoinColumn(name = "HOBBY_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
    public Contact getContact() {
        return contact;
    }

    public Hobby setContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    @Id
    @Column(name = "HOBBY_ID")
    public long getHobbyId() {
        return hobbyId;
    }

    public Hobby setHobbyId(long hobbyId) {
        this.hobbyId = hobbyId;
        return this;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyId=" + hobbyId +
                '}';
    }
}
