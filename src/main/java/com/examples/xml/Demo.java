package com.examples.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {


        File xml = new File("input.xml");
        try {
            unmarshaling(xml);

//            marshaling(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void unmarshaling(File file) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(SummaryElement.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();

        SummaryElement sc = (SummaryElement) unmarshaller.unmarshal(file);
        System.out.println(sc);

//        Marshaller marshaller = jc.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "SummaryCart.xsd");
//        marshaller.marshal(sc, System.out);
    }

    public static void marshaling(File file) throws JAXBException {
        List<SummaryElement> list = new ArrayList<>();
        for (Integer i = 0; i < 10; i++) {
            SummaryElement el = new SummaryElement();
            el.setName("Name "+i);
            el.setType("Type"+i);
            list.add(el);
        }

        SummaryElement el = new SummaryElement();
        el.setName("Name ");
        el.setType("Type");

        JAXBContext jaxbContext = JAXBContext.newInstance(SummaryCart.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(el, file);
        jaxbMarshaller.marshal(el, System.out);


    }
}
