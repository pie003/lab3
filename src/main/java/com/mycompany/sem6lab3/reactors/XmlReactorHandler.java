/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sem6lab3.reactors;

/**
 *
 * @author User
 */

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XmlReactorHandler extends BaseReactorHandler {

    @Override
    public ArrayList<Reactor> handleFile(String filePath) throws Exception {
        if (filePath.endsWith(".xml")) {
            ArrayList<Reactor> reactors = new ArrayList<>();
            try {
                File file = new File(filePath);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();
                
                NodeList nList = doc.getElementsByTagName("Reactor");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;

                        Reactor reactor = new Reactor(
                            eElement.getElementsByTagName("reactorClass").item(0).getTextContent(),
                            Double.parseDouble(eElement.getElementsByTagName("burnup").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("kpd").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("enrichment").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("termal_capacity").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("electrical_capacity").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("life_time").item(0).getTextContent()),
                            Double.parseDouble(eElement.getElementsByTagName("first_load").item(0).getTextContent()),
                            insertType.XML
                        );

                        reactors.add(reactor);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return reactors;
        } else if (nextHandler != null) {
            return nextHandler.handleFile(filePath);
        } else {
            throw new UnsupportedOperationException("Unsupported file format");
        }
    }
}




