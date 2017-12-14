package com.tow.spring.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import static java.lang.System.out;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myFirstHandler(), "/myHandler1").withSockJS();
        registry.addHandler(mySecondHandler(), "/myHandler2").withSockJS();
    }

    @Bean
    public WebSocketHandler myFirstHandler() {
        return new MyFirstHandler();
    }

    @Bean
    public WebSocketHandler mySecondHandler() {
        return new MySecondHandler();
    }

}