package com.tow.spring.groovy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyBeansFromJava {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericGroovyApplicationContext("classpath:beans.groovy");
        Contact contact = ctx.getBean("contact", Contact.class);
        System.out.println(contact);
    }
}
