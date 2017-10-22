package com.tow.spring.validation;

public enum Gender {
    MALE("M"), FAMALE("F");

    private String code;

    Gender(String code) {
        this.code = code;
    }
}
