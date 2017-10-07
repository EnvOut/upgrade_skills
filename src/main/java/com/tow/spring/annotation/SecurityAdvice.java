package com.tow.spring.annotation;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

import static java.lang.System.out;

public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();
        if (user == null) {
            out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
        } else if ("chris".equals(user.getUserName())) {
            out.println("Logged in user is chris - OKAY!");
        } else {
            out.println("Logged in user is " + user.getUserName() + " NOT GOOD:(");
            throw new SecurityException("User " + user.getUserName() + " is not allowed access to method " + method.getName());
        }

    }
}
