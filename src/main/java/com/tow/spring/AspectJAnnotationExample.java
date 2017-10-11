package com.tow.spring;

import com.tow.spring.aop.MyBean;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.support.GenericXmlApplicationContext;

import static java.lang.System.out;

public class AspectJAnnotationExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/xml-config.xml");
        ctx.refresh();

        MyBean bean = ctx.getBean("myBean", MyBean.class);
        bean.execute();
    }
}
