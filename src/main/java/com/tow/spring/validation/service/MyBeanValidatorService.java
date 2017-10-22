package com.tow.spring.validation.service;

import com.tow.spring.validation.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.validation.ConstraintViolation;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.util.Set;

@Service("myBeanValidatorService")
public class MyBeanValidatorService {
    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<Customer>> validateCustomer(Customer customer) {
        Set<ConstraintViolation<Customer>> result = null;
        try {
            validator.validate((Source) customer);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
