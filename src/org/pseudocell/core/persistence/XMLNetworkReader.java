/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.pseudocell.core.nodes.NodeFactory;
import org.pseudocell.core.nodes.NodeModification;
import org.pseudocell.config.Config;
import org.pseudocell.core.rules.Rule;
import org.pseudocell.core.rules.RuleFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author GuilhermeBorges e ViníciusPierdoná
 */
public class XMLNetworkReader {

    public static List<org.pseudocell.core.nodes.Node> importNodeList(String fileName) throws ParserConfigurationException, IOException, SAXException {
        NodeFactory nodeFactory = new NodeFactory();
        RuleFactory ruleFactory = new RuleFactory();
        List<org.pseudocell.core.nodes.Node> nodeList = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Parse XML file        
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        Document doc = db.parse(new File(fileName));
        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("node"), properties;
        System.out.println("  Number of nodes found in the XML file: : " + list.getLength());
        for (int temp = 0; temp < list.getLength(); temp++) {
            org.w3c.dom.Node xmlNode = list.item(temp);

            if (xmlNode.getNodeType() == Node.ELEMENT_NODE) {
                org.pseudocell.core.nodes.Node node = null;
                Element element = (Element) xmlNode;

                String name = element.getAttribute("name");
                String type = element.getAttribute("type");
                Double status = 0.0;
                Double restingStatus = 0.0;
                Double income = 0.0;
                Double minValue = 0.0;
                Double maxValue = 0.0;
                Boolean knockdown = false;
                // Retrieving optional variables
                if (element.hasAttribute("knockdown")) {
                    knockdown = Boolean.valueOf(element.getAttribute("knockdown"));
                }
                if (element.hasAttribute("status")) {
                    status = Double.valueOf(element.getAttribute("status"));
                }
                if (element.hasAttribute("restingStatus")) {
                    restingStatus = Double.valueOf(element.getAttribute("restingStatus"));
                }

                switch (type) {
                    case Config.NODE_TYPE_DEFAULT:
                        node = nodeFactory.createNode(name, status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_GENERAL:
                        node = nodeFactory.createGeneralNode(name, status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_MIRNA:
                        node = nodeFactory.createMiRNA(name);
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_BCL2:
                        node = nodeFactory.createBCL2();
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_PP2A:
                        node = nodeFactory.createPP2A();
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_P53:
                        node = nodeFactory.createP53();
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_DRUG:
                        node = nodeFactory.createDrug(name);
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_RIPK1:
                        node = nodeFactory.createRIPK1();
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;

                    case Config.NODE_TYPE_METABOLITE:
                        // Recovering the specific properties of metabolites
                        properties = element.getElementsByTagName("property");
                        for (int i = 0; i < properties.getLength(); i++) {
                            Node xmlProperty = properties.item(i);
                            if (xmlProperty.getNodeType() == Node.ELEMENT_NODE) {
                                Element elementProperty = (Element) xmlProperty;
                                income = Double.valueOf(elementProperty.getAttribute("income"));
                                minValue = Double.valueOf(elementProperty.getAttribute("minValue"));
                                maxValue = Double.valueOf(elementProperty.getAttribute("maxValue"));
                            }
                        }
                        node = nodeFactory.createMetabolite(name, status, income, minValue, maxValue);
                        node.setKnockdown(knockdown);
                        break;
                    default:
                        break;
                }
                // Retrieves, if any, the modifications of that node. (eg phosphorylations or acetylations)
                if (element.getAttribute("hasModifications").equals("true")) {
                    properties = element.getElementsByTagName("modification");
                    List<NodeModification> nodeModifications = new ArrayList<>();
                    for (int i = 0; i < properties.getLength(); i++) {
                        Node xmlProperty = properties.item(i);
                        if (xmlProperty.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementProperty = (Element) xmlProperty;
                            String modName = elementProperty.getAttribute("name");
                            Double modStatus = Double.valueOf(elementProperty.getAttribute("status"));
                            Double modRestingStatus = Double.valueOf(elementProperty.getAttribute("restingStatus"));
                            nodeModifications.add(new NodeModification(modName, modStatus, modRestingStatus));
                        }
                    }
                    if (node != null) {
                        node.setNodeModifications(nodeModifications);
                    }
                }
                // Retrieves, if any, the rules of that node.
                if (element.getAttribute("hasRules").equals("true")) {
                    properties = element.getElementsByTagName("rule");
                    List<Rule> rules = new ArrayList<>();
                    for (int i = 0; i < properties.getLength(); i++) {
                        Node xmlProperty = properties.item(i);
                        if (xmlProperty.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementProperty = (Element) xmlProperty;
                            String ruleType = elementProperty.getAttribute("ruleType");
                            String ruleString = elementProperty.getAttribute("ruleString");
                            if (ruleType.equals("metabolic")) {
                                String inputNode = elementProperty.getAttribute("inputNode");
                                String outputNode = elementProperty.getAttribute("outputNode");
                                Double conversionValue = Double.valueOf(elementProperty.getAttribute("conversionValue"));
                                rules.add(ruleFactory.createMetabolicRule(ruleString, inputNode, outputNode, conversionValue));
                            } else if (ruleType.equals("modification")) {
                                String modification = elementProperty.getAttribute("modification");
                                Double modificationStatus = Double.valueOf(elementProperty.getAttribute("modificationStatus"));
                                rules.add(ruleFactory.createModificationRule(ruleString, modification, modificationStatus));
                            } else {
                                Double nodeStatus = Double.valueOf(elementProperty.getAttribute("nodeStatus"));
                                rules.add(ruleFactory.createRule(ruleString, nodeStatus));
                            }
                        }
                    }
                    if (node != null) {
                        node.setRules(rules);
                    }
                }
                if (node != null) {
                    nodeList.add(node);
                }
            }
        }
        return nodeList;
    }

    public static List<org.pseudocell.core.nodes.Node> importNodeList(File file) throws ParserConfigurationException, IOException, SAXException {
        NodeFactory nodeFactory = new NodeFactory();
        RuleFactory ruleFactory = new RuleFactory();
        List<org.pseudocell.core.nodes.Node> nodeList = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Parse XML file        
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("node"), properties;
        System.out.println("  Number of nodes found in the XML file: : " + list.getLength());
        for (int temp = 0; temp < list.getLength(); temp++) {
            org.w3c.dom.Node xmlNode = list.item(temp);

            if (xmlNode.getNodeType() == Node.ELEMENT_NODE) {
                org.pseudocell.core.nodes.Node node = null;
                Element element = (Element) xmlNode;

                String name = element.getAttribute("name");
                String type = element.getAttribute("type");
                Double status = 0.0;
                Double restingStatus = 0.0;
                Double income = 0.0;
                Double minValue = 0.0;
                Double maxValue = 0.0;
                Boolean knockdown = false;
                // Retrieving optional variables
                if (element.hasAttribute("knockdown")) {
                    knockdown = Boolean.valueOf(element.getAttribute("knockdown"));
                }
                if (element.hasAttribute("status")) {
                    status = Double.valueOf(element.getAttribute("status"));
                }
                if (element.hasAttribute("restingStatus")) {
                    restingStatus = Double.valueOf(element.getAttribute("restingStatus"));
                }

                switch (type) {
                    case Config.NODE_TYPE_DEFAULT:
                        node = nodeFactory.createNode(name, status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_GENERAL:
                        node = nodeFactory.createGeneralNode(name, status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_MIRNA:
                        node = nodeFactory.createMiRNA(name);
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_BCL2:
                        node = nodeFactory.createBCL2();
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_PP2A:
                        node = nodeFactory.createPP2A();
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_P53:
                        node = nodeFactory.createP53();
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_DRUG:
                        node = nodeFactory.createDrug(name);
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;
                    case Config.NODE_TYPE_RIPK1:
                        node = nodeFactory.createRIPK1();
                        node.setStatus(status);
                        node.setRestingStatus(restingStatus);
                        node.setKnockdown(knockdown);
                        break;

                    case Config.NODE_TYPE_METABOLITE:
                        // Recovering the specific properties of metabolites
                        properties = element.getElementsByTagName("property");
                        for (int i = 0; i < properties.getLength(); i++) {
                            Node xmlProperty = properties.item(i);
                            if (xmlProperty.getNodeType() == Node.ELEMENT_NODE) {
                                Element elementProperty = (Element) xmlProperty;
                                String propertyName = elementProperty.getAttribute("name");
                                // atributos esperados
                                switch (propertyName) {
                                    case "income":
                                        income = Double.valueOf(elementProperty.getAttribute("value"));
                                        break;
                                    case "minValue":
                                        minValue = Double.valueOf(elementProperty.getAttribute("value"));
                                        break;
                                    case "maxValue":
                                        maxValue = Double.valueOf(elementProperty.getAttribute("value"));
                                        break;
                                }
                            }
                        }
                        node = nodeFactory.createMetabolite(name, status, income, minValue, maxValue);
                        node.setKnockdown(knockdown);
                        break;
                    default:
                        break;
                }
                // Retrieves, if any, the modifications of that node. (eg phosphorylations or acetylations)
                if (element.getAttribute("hasModifications").equals("true")) {
                    properties = element.getElementsByTagName("modification");
                    List<NodeModification> nodeModifications = new ArrayList<>();
                    for (int i = 0; i < properties.getLength(); i++) {
                        Node xmlProperty = properties.item(i);
                        if (xmlProperty.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementProperty = (Element) xmlProperty;
                            String modName = elementProperty.getAttribute("name");
                            Double modStatus = Double.valueOf(elementProperty.getAttribute("status"));
                            Double modRestingStatus = Double.valueOf(elementProperty.getAttribute("restingStatus"));
                            nodeModifications.add(new NodeModification(modName, modStatus, modRestingStatus));
                        }
                    }
                    if (node != null) {
                        node.setNodeModifications(nodeModifications);
                    }
                }
                // Retrieves, if any, the rules of that node.
                if (element.getAttribute("hasRules").equals("true")) {
                    properties = element.getElementsByTagName("rule");
                    List<Rule> rules = new ArrayList<>();
                    for (int i = 0; i < properties.getLength(); i++) {
                        Node xmlProperty = properties.item(i);
                        if (xmlProperty.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementProperty = (Element) xmlProperty;
                            String ruleType = elementProperty.getAttribute("ruleType");
                            String ruleString = elementProperty.getAttribute("ruleString");
                            if (ruleType.equals("metabolic")) {
                                String inputNode = elementProperty.getAttribute("inputNode");
                                String outputNode = elementProperty.getAttribute("outputNode");
                                Double conversionValue = Double.valueOf(elementProperty.getAttribute("conversionValue"));
                                rules.add(ruleFactory.createMetabolicRule(ruleString, inputNode, outputNode, conversionValue));
                            } else if (ruleType.equals("modification")) {
                                String modification = elementProperty.getAttribute("modification");
                                Double modificationStatus = Double.valueOf(elementProperty.getAttribute("modificationStatus"));
                                rules.add(ruleFactory.createModificationRule(ruleString, modification, modificationStatus));
                            } else {
                                Double nodeStatus = Double.valueOf(elementProperty.getAttribute("nodeStatus"));
                                rules.add(ruleFactory.createRule(ruleString, nodeStatus));
                            }
                        }
                    }
                    if (node != null) {
                        node.setRules(rules);
                    }
                }
                if (node != null) {
                    nodeList.add(node);
                }
            }
        }
        return nodeList;
    }
}
