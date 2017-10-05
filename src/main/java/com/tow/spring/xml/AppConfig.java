package com.tow.spring.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MessageRenderer messageRenderer(@Autowired MessageProvider messageProvider) {
        MessageRenderer messageRenderer = new StandartOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        return messageRenderer;
    }

    @Bean
    public MessageProvider messageProvider() {
        ConfigurableMessageProvider messageProvider = new ConfigurableMessageProvider();
        messageProvider.setMessage("This is a configurable message");
        return messageProvider;
    }
}
