package com.tow.spring.websocket.controller;

import com.tow.spring.websocket.model.Greeting;
import com.tow.spring.websocket.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage name) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + name.getName() + "!");
    }
}
