package com.tow.spring.scheduling;

import com.tow.spring.scheduling.configuration.NewCarConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduleTaskAnnotationSample {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(NewCarConfiguration.class);
        System.out.println("OK");

        while (true) {

        }
    }
}
