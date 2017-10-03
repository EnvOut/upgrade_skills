package com.tow.spring.xml;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.support.GenericXmlApplicationContext;

import static java.lang.System.out;

public class BeanNamePrinter implements BeanNameAware {
    private String beanName;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.registerShutdownHook();
        ctx.refresh();

        BeanNamePrinter bean = ctx.getBean("destructiveBean", BeanNamePrinter.class);
        bean.someOtherOperation();
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void someOtherOperation() {
        out.printf("Bean [ %s ] - some operation()", beanName);
    }
}
