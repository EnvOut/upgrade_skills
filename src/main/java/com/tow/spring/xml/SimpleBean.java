package com.tow.spring.xml;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

import static java.lang.System.out;

public class SimpleBean {
    public static String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age;

    public static void main(String[] args) {
        out.println(Integer.MIN_VALUE + " - " + Integer.MAX_VALUE);

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        SimpleBean simpleBean1 = getBean("simpleBean1", ctx);
        SimpleBean simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBean simpleBean3 = getBean("simpleBean3", ctx);
    }

    public static SimpleBean getBean(String beanName, ApplicationContext ctx) {
        SimpleBean bean = null;
        try {
            bean = ctx.getBean(beanName, SimpleBean.class);
            out.println(bean);
        } catch (BeanCreationException e) {
            out.println("An error occured in bean configuration: " + e.getMessage());
        }
        return bean;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @PostConstruct
    public void init() throws Exception {
        out.println("Initializing bean");
        if (name == null) {
            out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE || age == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("set normal value");
        }
    }
}
