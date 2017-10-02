package com.tow.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

import static java.lang.System.out;

public class DestructiveBean {
    private File file;
    private String filePath;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.registerShutdownHook();
        ctx.refresh();

        DestructiveBean bean = ctx.getBean("destructiveBean", DestructiveBean.class);
        out.println("Calling destroy");
        out.println("Called destroy");
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @PostConstruct
    public void init() throws Exception {
        out.println("Init bean");
        if (filePath == null) {
            throw new IllegalArgumentException("You must specify file!");
        }
        this.file = new File(filePath);
        this.file.createNewFile();

        out.println("File created! " + file.getAbsolutePath());
    }

    @PreDestroy
    public void destroy() {
        out.println("Destroy bean");

        if (!file.delete()) {
            out.println("ERROR: failed to delete file.");
        }

        out.println("File exists: " + file.exists());
    }
}
