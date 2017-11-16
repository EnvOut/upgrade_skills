package com.tow.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MvcConfig.class,
        WebSocketConfig.class})
public class ApplicationConfig {
}
