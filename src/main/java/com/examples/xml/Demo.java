package com.examples.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class Demo {
    //Initialize the employees list
    static Employees employees = new Employees();
    static JAXBContext jaxbContext = null;

    static {
        employees.setEmployees(new ArrayList<Employee>());
        //Create two employees
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setFirstName("Lokesh");
        emp1.setLastName("Gupta");
        emp1.setIncome(100.0);

        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setFirstName("John");
        emp2.setLastName("Mclane");
        emp2.setIncome(200.0);

        //Add the employees in list
        employees.getEmployees().add(emp1);
        employees.getEmployees().add(emp2);
    }

    static {
        try {
            jaxbContext = JAXBContext.newInstance(Employees.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("input.xml");
        try {
            marshalingExample(file);
            unmarshalingExample(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void marshalingExample(File file) throws JAXBException {

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
//        jaxbMarshaller.marshal(employees, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(employees, file);
    }

    private static void unmarshalingExample(File file) throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Employees emlps = (Employees) unmarshaller.unmarshal(file);
        System.out.println(emlps);
    }
}
