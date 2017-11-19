package com.tow.spring.websocket.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        WebSocketConfig.class,
        MvcConfig.class})
@ComponentScan("com.tow.spring.websocket")
public class ApplicationConfig {
}
