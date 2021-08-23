package com.pluralsight.org.abstractFactory;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class AbstractFactoryEverydayDemo {

    public static void main(String[] args) throws Exception {
        String xml = "<document><body><stock>AAPL</stock></body></document>";
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());

        DocumentBuilderFactory abstractFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder factory = abstractFactory.newDocumentBuilder();
        Document document = factory.parse(bais);

        document.getDocumentElement().normalize();

        System.out.println("Root Element : " + document.getDocumentElement().getNodeName());
        System.out.println(abstractFactory.getClass());
        System.out.println(factory.getClass());
    }
}
