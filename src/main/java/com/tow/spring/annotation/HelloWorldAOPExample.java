package com.tow.spring.annotation;

import org.springframework.aop.framework.ProxyFactory;

import static java.lang.System.out;

public class HelloWorldAOPExample {
    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);

        MessageWriter proxy = (MessageWriter) pf.getProxy();

        target.writeMessage();
        out.println("");
        proxy.writeMessage();
    }
}
