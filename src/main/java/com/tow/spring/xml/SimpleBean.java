package com.tow.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import static java.lang.System.out;

public class SimpleBean {
    private String name;
    private int age;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        SimpleBean parent = ctx.getBean("parent", SimpleBean.class);
        SimpleBean children = ctx.getBean("child", SimpleBean.class);

        out.println(parent);
        out.println(children);
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
}
