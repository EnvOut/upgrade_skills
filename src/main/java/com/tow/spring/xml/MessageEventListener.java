package com.tow.spring.xml;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent event) {
        MessageEvent messageEvent = event;
        System.out.printf("Received: %s\n", messageEvent.getMsg());
    }
}
