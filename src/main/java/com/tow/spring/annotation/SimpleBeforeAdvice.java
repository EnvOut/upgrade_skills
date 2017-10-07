package com.tow.spring.annotation;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

import static java.lang.System.out;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    public static void main(String[] args) {
        MessageWriter ms = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(ms);
        proxyFactory.addAdvice(new SimpleBeforeAdvice());

        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();
        proxy.writeMessage();

        proxy.setMessage("Lol");

        proxy.writeMessage();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        out.printf("--Aop before: %s.%s(%s)\n", target.getClass().getSimpleName(), method.getName(), args.length != 0 ? Arrays.toString(args) : "");
    }
}
