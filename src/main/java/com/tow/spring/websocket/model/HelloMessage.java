package com.tow.spring.websocket.model;

public class HelloMessage {
    private String name;

    public HelloMessage(String name) {
        this.name = name;
    }

    public HelloMessage() {
    }

    public String getName() {
        return name;
    }

    public HelloMessage setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HelloMessage{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
