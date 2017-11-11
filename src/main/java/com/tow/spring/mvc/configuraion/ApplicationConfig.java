package com.tow.spring.mvc.configuraion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.tow.spring.mvc")
@Import({DatabaseConfig.class,
        MvcConfig.class})
public class ApplicationConfig {
}
