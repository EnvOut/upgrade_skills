package com.tow.spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
    @Value("#{injectSimpleAnnotation.name}")
    private String name;
    @Value("#{injectSimpleAnnotation.age}")
    private int age;
    @Value("#{injectSimpleAnnotation.height}")
    private float height;
    @Value("#{injectSimpleAnnotation.programmer}")
    private boolean programmer;
    @Value("#{injectSimpleAnnotation.ageInSeconds}")
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        InjectSimple simple = ctx.getBean("injectSimple", InjectSimple.class);

        System.out.println(simple);
    }

    @Override
    public String toString() {
        return "InjectSimple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
