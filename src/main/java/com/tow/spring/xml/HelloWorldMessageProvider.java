package com.tow.spring.xml;

import com.tow.spring.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    private String message = "Hello World!";

    @Override
    public String getMessage() {
        return message;
    }
}
