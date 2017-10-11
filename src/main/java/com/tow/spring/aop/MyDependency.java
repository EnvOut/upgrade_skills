package com.tow.spring.aop;

import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Component("myDependency")
public class MyDependency {
    public void foo(int intValue) {
        out.printf("foo(int %s)\n", intValue);
    }
    public void bar(){
        out.println("bar()");
    }
}
