package com.tow.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomerEditorExample {
    private Name name;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        CustomerEditorExample bean = ctx.getBean("exampleBean", CustomerEditorExample.class);
        System.out.println(bean.getName());
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
