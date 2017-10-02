package com.tow.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import static java.lang.System.out;

public class Target {
    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {
    }

    public Target(Foo foo) {
        out.println("Target (Foo) called");
    }
    public Target(Foo foo, Bar bar) {
        out.println("Target (Foo, Bar) called");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        Target t = null;
        out.println("\nUsing byName:");
        t = ctx.getBean("targetByName", Target.class);
        out.println("\nUsing ByType:");
        t = ctx.getBean("targetByType", Target.class);
        out.println("\nUsing constructor:");
        t = ctx.getBean("targetByConstructor", Target.class);
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
        out.println("Target (Foo) set");
    }

    public void setFoo2(Foo foo2) {
        this.foo2 = foo2;
        out.println("Target (Foo2) set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        out.println("Target (Bar) set");
    }

}
