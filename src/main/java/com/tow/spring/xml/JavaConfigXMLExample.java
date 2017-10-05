package com.tow.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigXMLExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context-xml.xml");
        MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
