package com.tow.spring.xml;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {
    private ApplicationContext ctx;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context-xml.xml");
        Publisher publisher = ctx.getBean("publisher", Publisher.class);
        publisher.publish("Hello world!");
        publisher.publish("The quick brown for jumped over the lazy dog");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void publish(String msg) {
        ctx.publishEvent(new MessageEvent(this, msg));
    }
}
