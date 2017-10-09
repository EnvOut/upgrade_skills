package com.tow.spring.aop;

import static java.lang.System.out;

public class SampleBean {
    public void foo(int x) {
        out.printf("Invoked foo(%s)", x);
    }

    public void bar() {
        out.println("Invoked bar()");
    }
}
