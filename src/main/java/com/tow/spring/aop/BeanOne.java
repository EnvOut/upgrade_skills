package com.tow.spring.aop;

import static java.lang.System.out;

public class BeanOne {
    public static int countInvokes = 0;

    public void foo() {
        countInvokes++;
        out.println("foo");
    }

    public void bar() {
        countInvokes++;
        out.println("bar");
    }
}
