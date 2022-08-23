/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Dimension;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import org.pseudocell.core.Network;
import org.pseudocell.core.NetworkFactory;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.gui.components.JTabbedPaneMenu;
import org.pseudocell.config.Config;
import org.pseudocell.config.ConfigNodeStimulation;
import org.pseudocell.gui.panels.JPanelGeneralConfigurations;
import org.pseudocell.gui.panels.JPanelNetworkEditor;
import org.pseudocell.gui.panels.JPanelNewProject;
import org.pseudocell.gui.panels.JPanelNodeConfigurations;
import org.pseudocell.gui.panels.JPanelNodeStimulation;

/**
 *
 * @author ViníciusPierdoná
 */
public class Main extends JFrame {

    private JPanelNewProject jPanel_NewProject;
    private JPanelGeneralConfigurations jPanel_GeneralConfiguration;
    private JPanelNodeConfigurations jPanel_NodeConfiguartion;
    private JPanelNetworkEditor jPanel_RulesConfiguration;
    private JPanelNodeStimulation jPanel_NetworkStimulation;
    private JTabbedPaneMenu jTabbedPane_Menu;

    private Config configurations;
    private ConfigNodeStimulation configNodeStimulation;
    private NetworkFactory networkFactory;
    private Network network;
    private List<Node> nodeList;

    public Main() {
        setTitle("Pseudocell - Collaborative network for in silico prediction of regulatory pathways");

        this.configurations = new Config();
        this.configNodeStimulation = new ConfigNodeStimulation();
        this.networkFactory = new NetworkFactory();
        this.network = networkFactory.createNetwork(configurations);
        this.nodeList = network.getDefaultNodes();

        setComponents();
        setLayoutDesign();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 680);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setComponents() {
        jTabbedPane_Menu = new JTabbedPaneMenu();
        jPanel_NewProject = new JPanelNewProject(configurations, configNodeStimulation, nodeList);
        jPanel_GeneralConfiguration = new JPanelGeneralConfigurations(configurations);
        jPanel_NodeConfiguartion = new JPanelNodeConfigurations(configurations, nodeList);
        jPanel_RulesConfiguration = new JPanelNetworkEditor(configurations, nodeList);
        jPanel_NetworkStimulation = new JPanelNodeStimulation(configurations, configNodeStimulation, nodeList);
        this.add(jTabbedPane_Menu);
        jTabbedPane_Menu.setTabPlacement(JTabbedPane.LEFT);
        jTabbedPane_Menu.setMaximumSize(new Dimension(1200, 680));
        jTabbedPane_Menu.setMinimumSize(new Dimension(148, 100));

        jTabbedPane_Menu.addTab("New Project", jPanel_NewProject);
        jTabbedPane_Menu.addTab("General Configuration", jPanel_GeneralConfiguration);
        jTabbedPane_Menu.addTab("Node Configuartion", jPanel_NodeConfiguartion);
        jTabbedPane_Menu.addTab("Rules Configuration", jPanel_RulesConfiguration);
        jTabbedPane_Menu.addTab("Network Stimulation", jPanel_NetworkStimulation);
    }

    private void setLayoutDesign() {

        GroupLayout jPanel_NewProjectLayout = new GroupLayout(jPanel_NewProject);
        jPanel_NewProject.setLayout(jPanel_NewProjectLayout);
        jPanel_NewProjectLayout.setHorizontalGroup(
                jPanel_NewProjectLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1152, Short.MAX_VALUE)
        );
        jPanel_NewProjectLayout.setVerticalGroup(
                jPanel_NewProjectLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 680, Short.MAX_VALUE)
        );

        GroupLayout jPanel_GeneralConfigurationLayout = new GroupLayout(jPanel_GeneralConfiguration);
        jPanel_GeneralConfiguration.setLayout(jPanel_GeneralConfigurationLayout);
        jPanel_GeneralConfigurationLayout.setHorizontalGroup(
                jPanel_GeneralConfigurationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1152, Short.MAX_VALUE)
        );
        jPanel_GeneralConfigurationLayout.setVerticalGroup(
                jPanel_GeneralConfigurationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 680, Short.MAX_VALUE)
        );

        GroupLayout jPanel_NodeConfiguartionLayout = new GroupLayout(jPanel_NodeConfiguartion);
        jPanel_NodeConfiguartion.setLayout(jPanel_NodeConfiguartionLayout);
        jPanel_NodeConfiguartionLayout.setHorizontalGroup(
                jPanel_NodeConfiguartionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1152, Short.MAX_VALUE)
        );
        jPanel_NodeConfiguartionLayout.setVerticalGroup(
                jPanel_NodeConfiguartionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 680, Short.MAX_VALUE)
        );

        GroupLayout jPanel_RulesConfigurationLayout = new GroupLayout(jPanel_RulesConfiguration);
        jPanel_RulesConfiguration.setLayout(jPanel_RulesConfigurationLayout);
        jPanel_RulesConfigurationLayout.setHorizontalGroup(
                jPanel_RulesConfigurationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1152, Short.MAX_VALUE)
        );
        jPanel_RulesConfigurationLayout.setVerticalGroup(
                jPanel_RulesConfigurationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 680, Short.MAX_VALUE)
        );

        GroupLayout jPanel_NetworkStimulationLayout = new GroupLayout(jPanel_NetworkStimulation);
        jPanel_NetworkStimulation.setLayout(jPanel_NetworkStimulationLayout);
        jPanel_NetworkStimulationLayout.setHorizontalGroup(
                jPanel_NetworkStimulationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1152, Short.MAX_VALUE)
        );
        jPanel_NetworkStimulationLayout.setVerticalGroup(
                jPanel_NetworkStimulationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 680, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane_Menu, GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane_Menu)
        );
    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                com.formdev.flatlaf.FlatIntelliJLaf.setup();                
//                com.formdev.flatlaf.FlatDarculaLaf.setup();
//                com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme.setup();
//                com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme.setup();
                new Main();
            }
        });
    }

}
