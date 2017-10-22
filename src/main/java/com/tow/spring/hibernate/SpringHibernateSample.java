package com.tow.spring.hibernate;

import com.tow.spring.hibernate.configuration.HibernateConfiguration;
import com.tow.spring.hibernate.dao.ContactDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringHibernateSample {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConfiguration.class);

        ContactDaoImpl contactDao = ctx.getBean("contactDao", ContactDaoImpl.class);
        System.out.println(contactDao.getSessionFactory().getCurrentSession().isDirty());
    }
}
