package com.tow.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;

import static java.lang.System.out;

public class ResourceDemo {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();

        File file = File.createTempFile("test", "xtx");
        file.deleteOnExit();

        out.println(file.getPath());
        Resource res1 = ctx.getResource("file://" + file.getPath());
        displayInfo(res1);

        Resource res2 = ctx.getResource("classpath:test.txt");
        displayInfo(res2);

        Resource res3 = ctx.getResource("http://www.google.com");
        displayInfo(res3);
    }

    public static void displayInfo(Resource res) throws Exception {
        out.println(res.getClass());
        out.println(res.getURL());
        out.println("");
    }
}
