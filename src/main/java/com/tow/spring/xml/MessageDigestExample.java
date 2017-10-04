package com.tow.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        MessageDigester messageDigester = ctx.getBean("digester", MessageDigester.class);
        messageDigester.digest("Hello world");
        System.out.println("END");
    }
}
