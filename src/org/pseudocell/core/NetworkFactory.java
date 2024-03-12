/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.pseudocell.core.nodes.DefaultNodesBuilder;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.persistence.XMLNetworkReader;
import org.pseudocell.config.Config;
import org.xml.sax.SAXException;

/**
 *
 * @author ViníciusPierdoná
 */
public class NetworkFactory {

    DefaultNodesBuilder defaultNodeBuilder = new DefaultNodesBuilder();
    List<Node> defaultNodes;
    Config configurations;

    public Network createNetwork(Config configurations) {
        this.configurations = configurations;
        this.createNodeList();
        Network network = new Network(defaultNodes, configurations.stimulatedNode, configurations.stimulatedNodeFrequency);
        return network;

    }

    private void createNodeList() {
        defaultNodes = new ArrayList<>();
        switch (configurations.networkSourceInputType) {
            case Config.NETWORK_SOURCE_TYPE_DEFAULT:
                defaultNodes = defaultNodeBuilder.createDefaultNodes();
                break;
            case Config.NETWORK_SOURCE_TYPE_XML:
                try {
                defaultNodes = XMLNetworkReader.importNodeList(configurations.networkSourceFileName);
            } catch (ParserConfigurationException | IOException | SAXException ex) {
                Logger.getLogger(NetworkFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            default:
                defaultNodes = defaultNodeBuilder.createDefaultNodes();
        }
    }
}
