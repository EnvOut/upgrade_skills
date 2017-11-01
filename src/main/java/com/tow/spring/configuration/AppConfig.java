package com.tow.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        PostgresConfiguration.class,
        WebConfig.class
})
@Configuration
@ComponentScan(basePackages = "com.tow.spring")
public class AppConfig {
}
