package com.tow.spring.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
    @NotNull
    @Size(min = 2, max = 60)
    private String firstName;

    private String lastName;

    @NotNull
    private CustomerType customerType;
    private Gender gender;

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public Customer setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Customer setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public boolean isIndividualCustomer() {
        return this.customerType.equals(CustomerType.INDIVIDUAL);
    }
}
