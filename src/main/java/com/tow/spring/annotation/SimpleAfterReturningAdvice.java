package com.tow.spring.annotation;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

import static java.lang.System.out;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        SimpleAfterReturningAdvice advice = new SimpleAfterReturningAdvice();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        MessageWriter proxy = (MessageWriter) factory.getProxy();
        proxy.writeMessage();
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        out.println("After method: " + method.getName());
    }
}
