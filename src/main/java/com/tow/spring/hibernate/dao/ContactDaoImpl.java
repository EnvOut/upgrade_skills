package com.tow.spring.hibernate.dao;

import com.tow.spring.hibernate.model.Contact;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository("contactDao")
@javax.transaction.Transactional
public class ContactDaoImpl implements Serializable, ContactDao {
    private static final Log LOG = LogFactory.getLog(ContactDaoImpl.class);

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public ContactDaoImpl setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        return this;
    }

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional(readOnly=true)
    public List<Contact> findAll() {
        List result = getSession().createQuery("select c from com.tow.spring.hibernate.model.Contact c").list();
        return result;
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return null;
    }

    @Override
    public Contact findById(Long id) {
        return null;
    }

    @Override
    public Contact save(Contact contact) {
        return null;
    }

    @Override
    public void delete(Contact contact) {

    }
}
