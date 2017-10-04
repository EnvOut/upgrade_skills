package com.tow.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

import static java.lang.System.out;

public class MessageSoourceDemo {
    public static void
    main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cs", "CZ");

        out.println(ctx.getMessage("msg", null, english));
        out.println(ctx.getMessage("msg", null, czech));

        out.println(ctx.getMessage("nameMsg", new Object[]{"Chris", "Schaefer"}, english));
    }
}
