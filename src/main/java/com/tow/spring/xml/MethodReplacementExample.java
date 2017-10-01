package com.tow.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

import static java.lang.System.out;

public class MethodReplacementExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        ReplacementTarget replacementTarget = ctx.getBean("replacementTarget", ReplacementTarget.class);
        ReplacementTarget standartTarget = ctx.getBean("standartTarget", ReplacementTarget.class);

        displayInfo(replacementTarget);
        displayInfo(standartTarget);
    }

    public static void displayInfo(ReplacementTarget target) {

        out.println(target.formatMessage("Hello world"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        Long maxIter = 1_000_000L;

        for (int i = 0; i < maxIter; i++) {
            target.formatMessage("foo");
        }
        stopWatch.stop();
        out.println(maxIter + " gets tock " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
