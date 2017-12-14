package com.tow.spring.websocket.model;

public class ParametresModel {
    private String firstName;
    private String lastName;

    public ParametresModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ParametresModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
