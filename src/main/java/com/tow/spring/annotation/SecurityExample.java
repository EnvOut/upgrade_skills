package com.tow.spring.annotation;

import org.springframework.aop.framework.ProxyFactory;

import static java.lang.System.out;

public class SecurityExample {
    public static void main(String[] args) {
        SecurityManager mgr = new SecurityManager();

        SecureBean bean = getSecureBean();

        mgr.login("chris", "pwd");
        bean.writeSecureMessage();
        mgr.logout();

        try {
            mgr.login("invalid_user", "pwd");
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            out.println("Exception Caught: " + ex.getMessage());
        } finally {
            mgr.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            out.println("Exception Caught " + ex.getMessage());
        }
    }

    public static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();

        SecurityAdvice advice = new SecurityAdvice();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        SecureBean proxy = (SecureBean) factory.getProxy();

        return proxy;
    }

}
