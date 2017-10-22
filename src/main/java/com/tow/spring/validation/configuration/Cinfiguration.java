package com.tow.spring.validation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.tow.spring.validation")
public class Cinfiguration {
    @Bean(name = "validator")
    public LocalValidatorFactoryBean getValidator() {
        return new LocalValidatorFactoryBean();
    }
}
