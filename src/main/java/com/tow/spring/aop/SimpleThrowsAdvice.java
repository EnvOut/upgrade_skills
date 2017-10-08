package com.tow.spring.aop;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

import static java.lang.System.out;

public class SimpleThrowsAdvice implements ThrowsAdvice {
    public static void main(String[] args) {
        ErrorBean errorBean = new ErrorBean();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(errorBean);
        factory.addAdvice(new SimpleThrowsAdvice());
        ErrorBean proxy = (ErrorBean) factory.getProxy();

        try {
            proxy.errorProneMethod();
        } catch (Exception e) {
        }
        try {
            proxy.otherErrorProneMethod();
        } catch (Exception e) {
        }
    }

    public void afterThrowing(Exception ex) throws Throwable {
        out.printf("***\nGeneric Exception Capture\nCaught: %s\n***\n", ex.getClass().getName());
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) throws Throwable {
        out.printf("***\nIllegalArgumentException Capture\nCaught: %s\nMethod: %s\n***\n", ex.getClass().getName(), method.getName());
    }

}
