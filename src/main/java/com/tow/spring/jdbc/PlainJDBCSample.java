package com.tow.spring.jdbc;

import com.tow.spring.jdbc.configuration.JdbcConfiguration;
import com.tow.spring.jdbc.dao.ContactDAO;
import com.tow.spring.jdbc.dao.PlainContactDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlainJDBCSample {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfiguration.class);
        ContactDAO jdbcDao = ctx.getBean(PlainContactDao.class);

        jdbcDao.findAll().parallelStream().forEach(System.out::println);

        jdbcDao.findAll().parallelStream().forEach(contact -> {
            contact.setLastName(contact.getLastName()+"1");
            jdbcDao.update(contact);
        });
        jdbcDao.findAll().parallelStream().forEach(System.out::println);
    }
}
