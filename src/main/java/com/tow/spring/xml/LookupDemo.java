package com.tow.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

import java.util.logging.Logger;

import static java.lang.System.out;


public class LookupDemo {
    private static Logger log = Logger.getLogger(LookupDemo.class.getName());

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
        DemoBean standartBean = ctx.getBean("standartLookupBean", DemoBean.class);

        displayInfo(abstractBean);
        displayInfo(standartBean);
    }

    public static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();

        out.println("Helpers Instances the Same?: " + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int i = 0; i < 100000; i++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }
        stopWatch.stop();
        out.println("100000 gets tock " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
