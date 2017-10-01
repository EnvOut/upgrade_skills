package com.tow.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    private Map<String, Object> mapFiled;
    private Properties propsFiled;
    private Set setFiled;
    private List listFiled;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        CollectionInjection simple = ctx.getBean("collectionInjection", CollectionInjection.class);

        System.out.println(simple);
    }

    @Override
    public String toString() {
        return "CollectionInjection{" +
                "mapFiled=" + mapFiled +
                ", propsFiled=" + propsFiled +
                ", setFiled=" + setFiled +
                ", listFiled=" + listFiled +
                '}';
    }

    public void setMapFiled(Map<String, Object> mapFiled) {
        this.mapFiled = mapFiled;
    }

    public void setPropsFiled(Properties propsFiled) {
        this.propsFiled = propsFiled;
    }

    public void setSetFiled(Set setFiled) {
        this.setFiled = setFiled;
    }

    public void setListFiled(List listFiled) {
        this.listFiled = listFiled;
    }
}
