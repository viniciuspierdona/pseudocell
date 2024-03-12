/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import org.pseudocell.core.Network;
import org.pseudocell.core.NetworkFactory;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.gui.components.JTabbedPaneMenu;
import org.pseudocell.config.Config;
import org.pseudocell.gui.panels.JPanelGeneralConfigurations;
import org.pseudocell.gui.panels.JPanelNetworkEditor;
import org.pseudocell.gui.panels.JPanelNewProject;
import org.pseudocell.gui.panels.JPanelNodeConfigurations;

/**
 *
 * @author ViníciusPierdoná
 */
public class Main extends JFrame {

    private JPanelNewProject jPanel_NewProject;
    private JPanelGeneralConfigurations jPanel_GeneralConfiguration;
    private JPanelNodeConfigurations jPanel_NodeConfiguartion;
    private JPanelNetworkEditor jPanel_RulesConfiguration;
    private JTabbedPaneMenu jTabbedPane_Menu;

    private Config configurations;
    private NetworkFactory networkFactory;
    private Network network;
    private List<Node> nodeList;

    public Main() {
        setTitle("Pseudocell - A Multi-Valued Logical Regulatory Network to Investigate Premature Senescence Dynamics and Heterogeneity");

        this.configurations = new Config();
        this.networkFactory = new NetworkFactory();
        this.network = networkFactory.createNetwork(configurations);
        this.nodeList = network.getDefaultNodes();

        setComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 680);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setComponents() {
        jTabbedPane_Menu = new JTabbedPaneMenu();
        jPanel_NewProject = new JPanelNewProject(configurations, nodeList);
        jPanel_GeneralConfiguration = new JPanelGeneralConfigurations(configurations, nodeList);
        jPanel_NodeConfiguartion = new JPanelNodeConfigurations(configurations, nodeList);
        jPanel_RulesConfiguration = new JPanelNetworkEditor(configurations, nodeList);
        this.add(jTabbedPane_Menu);
        jTabbedPane_Menu.setTabPlacement(JTabbedPane.LEFT);
        jTabbedPane_Menu.setMaximumSize(new Dimension(1200, 680));
        jTabbedPane_Menu.setMinimumSize(new Dimension(148, 100));

        jTabbedPane_Menu.addTab("New Project", jPanel_NewProject);
        jTabbedPane_Menu.addTab("General Configuration", jPanel_GeneralConfiguration);
        jTabbedPane_Menu.addTab("Node Configuartion", jPanel_NodeConfiguartion);
        jTabbedPane_Menu.addTab("Rules Configuration", jPanel_RulesConfiguration);
    }
    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

}
