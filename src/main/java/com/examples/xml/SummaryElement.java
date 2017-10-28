package com.examples.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class SummaryElement {
    @XmlAttribute
    private String type;
    private String name;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SummaryElement{");
        sb.append("type='").append(type).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getType() {
        return type;
    }

    public SummaryElement setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public SummaryElement setName(String name) {
        this.name = name;
        return this;
    }
}