package com.tow.spring.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("collectionInjection")
public class CollectionInjection {
    @Resource(name = "mapField")
    private Map<String, Object> mapFiled;
    @Resource(name = "propsField")
    private Properties propsFiled;
    @Resource(name = "setField")
    private Set setFiled;
    @Resource(name = "listField")
    private List listFiled;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
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
