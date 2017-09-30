package com.tow.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationConfigWithBeanFactory {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context-annotation.xml");

        MessageProvider messageRenderer = ctx.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageRenderer.getMessage());
    }
}
