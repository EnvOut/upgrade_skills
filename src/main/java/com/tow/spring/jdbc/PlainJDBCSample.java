package com.tow.spring.jdbc;

import com.tow.spring.jdbc.configuration.JdbcConfiguration;
import com.tow.spring.jdbc.dao.ContactDAO;
import com.tow.spring.jdbc.dao.PlainContactDao;
import com.tow.spring.jdbc.models.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlainJDBCSample {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfiguration.class);
        ContactDAO jdbcDao = ctx.getBean(PlainContactDao.class);

        jdbcDao.findAll().parallelStream().forEach(System.out::println);

        Contact contact = jdbcDao.findAll().parallelStream().findFirst().get();
        contact.setLastName("Copy!");
        contact.setId(null);

        jdbcDao.insert(contact);
        jdbcDao.findAll().parallelStream().forEach(System.out::println);
    }
}
