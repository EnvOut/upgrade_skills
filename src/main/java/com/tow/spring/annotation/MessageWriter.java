package com.tow.spring.annotation;

import static java.lang.System.out;

public class MessageWriter {
    private static int countInstance;

    public MessageWriter() {
        countInstance++;
    }

    public void writeMessage() {
        out.print(countInstance + ": World");
    }
}
