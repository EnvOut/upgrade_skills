package com.tow.spring.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {
    private Long id;
    private int version;
    private String firstname;
    private String lastName;
    private Date birthDate;

    private Set<ContactTelDetail> contactTelDetails = new HashSet<>();
    private Set<Hobby> hobbies = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "CONTACT_HOBBY_DETAIL",
            joinColumns = @JoinColumn(name = "CONTACT_ID"),
            inverseJoinColumns = @JoinColumn(name = "HOBBY_ID")
    )
    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public Contact setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
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
        return this.version;
    }

    public Contact setVersion(int version) {
        this.version = version;
        return this;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstname() {
        return firstname;
    }

    public Contact setFirstname(String firstname) {
        this.firstname = firstname;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public Contact setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ContactTelDetail> getContactTelDetails() {
        return contactTelDetails;
    }

    public Contact setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
        return this;
    }

    public void addContactTelDetail(ContactTelDetail contactTelDetail) {
        contactTelDetail.setContact(this);
        getContactTelDetails().add(contactTelDetail);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
