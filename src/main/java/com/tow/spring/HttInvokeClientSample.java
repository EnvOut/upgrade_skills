package com.tow.spring;

import com.tow.spring.model.Contact;
import com.tow.spring.service.ContactService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class HttInvokeClientSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:client/http-invoker-app-context.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("remoteContextService", ContactService.class);
        System.out.println("Finding all contacts");
        List<Contact> contacts = contactService.findAll();
        contacts.forEach(System.out::println);
    }
}
