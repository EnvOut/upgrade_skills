package com.tow.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.Arrays;

import static java.lang.System.out;

public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(invocation.getMethod().getName());

        Object returnValue = invocation.proceed();

        stopWatch.stop();
        dumpInfo(invocation, stopWatch.getTotalTimeMillis());
        return returnValue;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method method = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        out.printf("Executed method: %s\nOn object of type: %s\nWith arguments: %s\nTook: %s\n", method.getName(), target.getClass().getName(), Arrays.toString(args), ms);
    }
}
