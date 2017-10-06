package com.tow.spring.annotation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import static java.lang.System.out;

public class MessageDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        out.print("Hello ");
        Object retVal = invocation.proceed();
        out.println("!");
        return retVal;
    }
}
