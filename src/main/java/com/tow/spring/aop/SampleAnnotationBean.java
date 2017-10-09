package com.tow.spring.aop;

import static java.lang.System.out;

public class SampleAnnotationBean {
    @AdviceRequired
    public void foo(int x){out.println("Invoked foo() with: "+x);} public void bar(){out.println("Invoked bar()");}
}
