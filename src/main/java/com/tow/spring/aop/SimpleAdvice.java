package com.tow.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import static java.lang.System.out;

public class SimpleAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        out.println(">> Invoking " + invocation.getMethod().getName());
        Object retVal = invocation.proceed();
        out.println(">> Done");
        return retVal;
    }
} 