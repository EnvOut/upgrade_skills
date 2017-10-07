package com.tow.spring.annotation;

import static java.lang.System.out;

public class MessageWriter {
    private static int countInstance;
    private String message = "World";

    public MessageWriter() {
        countInstance++;
    }

    public void writeMessage() {
        out.println(countInstance + " " + message);
    }
}