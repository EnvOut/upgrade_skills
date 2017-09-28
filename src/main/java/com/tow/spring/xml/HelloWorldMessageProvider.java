package com.tow.spring.xml;

import com.tow.spring.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    private String message = "Hello World!";

    public HelloWorldMessageProvider() {
    }

    public HelloWorldMessageProvider(String... strings) {
        this.message = String.join(" ", strings);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
