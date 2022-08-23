/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.persistence;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.pseudocell.core.nodes.Metabolite;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.nodes.NodeModification;
import org.pseudocell.config.Config;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author GuilhermeBorges e ViníciusPierdoná
 */
public class XMLNetworkWriter {

    public static void exportNodeList(String fileName, List<Node> nodeList) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // Parse XML file
        DocumentBuilder db = dbf.newDocumentBuilder();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        Document doc = db.newDocument();

        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element elementNodes = doc.createElement("nodes");
        root.appendChild(elementNodes);

        // Add the network nodes and their possible modifications, properties and logical rules
        for (Node n : nodeList) {
            Element node = doc.createElement("node");
            node.setAttribute("name", n.getName());
            node.setAttribute("status", n.getStatus().toString());
            if (n.getName().equals("BCL2")) {
                node.setAttribute("type", Config.NODE_TYPE_BCL2);
            } else if (n.getName().equals("P53")) {
                node.setAttribute("type", Config.NODE_TYPE_P53);
            } else if (n.getName().equals("PP2A")) {
                node.setAttribute("type", Config.NODE_TYPE_PP2A);
            } else if (n.getName().equals("RIPK1")) {
                node.setAttribute("type", Config.NODE_TYPE_RIPK1);
            } else {
                switch (n.getType()) {
                    case 1:
                        node.setAttribute("type", Config.NODE_TYPE_DEFAULT);
                        break;
                    case 2:
                        node.setAttribute("type", Config.NODE_TYPE_METABOLITE);
                        break;
                    case 3:
                        node.setAttribute("type", Config.NODE_TYPE_GENERAL);
                        break;
                    case 4:
                        node.setAttribute("type", Config.NODE_TYPE_MIRNA);
                        break;
                    case 5:
                        node.setAttribute("type", Config.NODE_TYPE_DRUG);
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            node.setAttribute("restingStatus", n.getRestingStatus().toString());
            node.setAttribute("knockdown", Boolean.toString(n.getKnockdown()));
            Element property;
            if (!n.getNodeModifications().isEmpty()) {
                node.setAttribute("hasModifications", null);
                for (NodeModification modification : n.getNodeModifications()) {
                    property = doc.createElement("modification");
                    property.setAttribute("name", modification.getName());
                    property.setAttribute("status", String.valueOf(modification.getModificationStatus()));
                    property.setAttribute("restingStatus", String.valueOf(modification.getRestingStatus()));
                    node.appendChild(property);
                }
            }
            if (n instanceof Metabolite) {
                property = doc.createElement("property");
                property.setAttribute("income", String.valueOf(((Metabolite) n).getIncome()));
                property.setAttribute("minValue", String.valueOf(((Metabolite) n).getMinValue()));
                property.setAttribute("maxValue", String.valueOf(((Metabolite) n).getMaxValue()));
                node.appendChild(property);
            }
            elementNodes.appendChild(node);
        }

        // Write the XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty(OutputKeys.METHOD, "xml");

        DOMSource source = new DOMSource(doc);

        File myFile = new File(fileName);

        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(myFile);

        transf.transform(source, console);
        transf.transform(source, file);
        /*
        BufferedWriter writer = null;
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(myFile, false), "UTF-8"));
        StreamResult result = new StreamResult(writer);
        transf.transform(source, result);*/

    }
}
