package com.examples.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Employee
{
    @XmlElement(name = "myId")
    private Integer id;
    private String firstName;
    private String lastName;
    private double income;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", income=").append(income);
        sb.append('}');
        return sb.toString();
    }

    public Employee(Integer id, String firstName, String lastName, double income) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Employee() {
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Employee setIncome(double income) {
        this.income = income;
        return this;
    }

    //Getters and Setters
}