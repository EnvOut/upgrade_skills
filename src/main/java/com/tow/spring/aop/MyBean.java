package com.tow.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {
    private MyDependency myDependency;

    @Autowired
    public void setMyDependency(MyDependency myDependency) {
        this.myDependency = myDependency;
    }

    public void execute() {
        myDependency.foo(100);
        myDependency.foo(101);
        myDependency.bar();

    }
}
