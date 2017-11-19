package com.tow.spring.websocket.model;

import static java.lang.System.out;

public class Greeting {
    private String content;

    public String getContent() {
        return content;
    }

    public Greeting(String content) {
        this.content = content;
    }

    public Greeting setContent(String content) {
        this.content = content;
        return this;

    }

    public Greeting() {

    }
}
