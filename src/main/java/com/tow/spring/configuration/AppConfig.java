package com.tow.spring.configuration;

import com.tow.spring.model.Contacts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Import({
        PostgresConfiguration.class,
        WebConfig.class
})
@Configuration
@ComponentScan(basePackages = "com.tow.spring")
public class AppConfig {
    @Bean(name = "jaxContext")
    public JAXBContext jaxbContext() throws JAXBException {
        return JAXBContext.newInstance(Contacts.class);
    }
}
