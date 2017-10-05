package com.tow.spring.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource(value = "classpath:META-INF/spring/app-context-xml.xml")
@PropertySource("classpath:message.properties")
@ComponentScan(basePackages = {"com.tow.spring"})
@EnableTransactionManagement
public class AppConfig {
    @Autowired
    Environment env;

    @Bean
    @Scope(value = "prototype")
    public MessageRenderer messageRenderer(@Autowired MessageProvider messageProvider) {
        MessageRenderer messageRenderer = new StandartOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        return messageRenderer;
    }

    @Bean
    @Lazy(value = true)
    public MessageProvider messageProvider() {
        ConfigurableMessageProvider messageProvider = new ConfigurableMessageProvider();
        messageProvider.setMessage(env.getProperty("message"));
        return messageProvider;
    }
}
