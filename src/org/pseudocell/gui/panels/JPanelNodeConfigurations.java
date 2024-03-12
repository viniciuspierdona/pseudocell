/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.pseudocell.core.NetworkFactory;
import org.pseudocell.core.nodes.Metabolite;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.persistence.XMLNetworkReader;
import org.pseudocell.core.persistence.XMLNetworkWriter;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.gui.components.JListNodeCellRender;
import org.pseudocell.config.Config;
import org.pseudocell.gui.nodes.CreateKnockout;
import org.pseudocell.gui.nodes.CreateModification;
import org.pseudocell.gui.nodes.CreateNode;
import org.pseudocell.gui.nodes.EditModification;
import org.pseudocell.gui.utils.NodeFilter;
import org.pseudocell.gui.validation.FieldValidation;
import org.xml.sax.SAXException;

/**
 *
 * @author ViníciusPierdoná
 */
public class JPanelNodeConfigurations extends JPanel {

    private static int DEFAULT_SIZE = GroupLayout.DEFAULT_SIZE;
    private static int PREFERRED_SIZE = GroupLayout.PREFERRED_SIZE;
    private static final int TYPE_PROTEINGENE = 1;
    private static final int TYPE_METABOLITE = 2;
    private static final int TYPE_OTHER = 3;
    private static final int TYPE_MIRNA = 4;
    private static final int TYPE_DRUG = 5;

    private JButton JButton_AddMod, JButton_AddNode, JButton_EditMod, JButton_ExportNodes, JButton_Filter,
            JButton_ImportNodes, JButton_Knockout, JButton_Reset, JButton_Save;
    private JComboBox<String> JComboBox_Modifications;
    private JLabel JLabel_Filter, JLabel_Income, JLabel_MaxValue, JLabel_MinValue, JLabel_Modifications, JLabel_Name,
            JLabel_NodesList, JLabel_RestingStatus, JLabel_Status, JLabel_Type;
    private JLabelSubTitle JLabel_SubTitle1, JLabel_Subtitle2;
    private JLabelTitle JLabel_Title;
    private JTextField JTextField_Filter, JTextField_Income, JTextField_MaxValue, JTextField_MinValue, JTextField_Name,
            JTextField_RestingStatus, JTextField_Status, JTextField_Type;
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanelNodeConfigurationsScreen;
    private JSeparator jSeparator1, jSeparator2;
    private JList<Node> listNodesList;
    private DefaultListModel model_NodeList;
    private JScrollPane jScrollPane1;

    private NetworkFactory networkFactory;
    private Config configurations;
    private List<Node> nodeList, displayedNodes;
    private NodeFilter nodeFilter;
    private Node selectedNode;
    private FieldValidation fieldValidation;

    /**
     * Creates new form NodeConfigurations
     *
     * @param configurations
     * @param nodeList
     */
    public JPanelNodeConfigurations(Config configurations, List<Node> nodeList) {

        this.configurations = configurations;
        this.nodeList = nodeList;
        this.networkFactory = new NetworkFactory();
        this.nodeFilter = new NodeFilter();
        this.fieldValidation = new FieldValidation();

        setComponents();
        setLayoutDesign();

        // Create a listener to control the methods needed when shown or hidden the card
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent evt) {
                shown();
            }
        });
    }

    public void shown() {
        listNodesList.setModel(nodeFilter.filterNodes(model_NodeList, nodeList, null));
        JTextField_Name.setEditable(false);
        JTextField_Type.setEditable(false);
    }

    public void setComponents() {
        jPanelNodeConfigurationsScreen = new JPanel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        JLabel_Title = new JLabelTitle();
        JLabel_SubTitle1 = new JLabelSubTitle();
        JLabel_Subtitle2 = new JLabelSubTitle();
        JLabel_Filter = new JLabel();
        JLabel_NodesList = new JLabel();
        JLabel_Name = new JLabel();
        JLabel_Income = new JLabel();
        JLabel_Status = new JLabel();
        JLabel_MaxValue = new JLabel();
        JLabel_RestingStatus = new JLabel();
        JLabel_Modifications = new JLabel();
        JLabel_MinValue = new JLabel();
        JLabel_Type = new JLabel();
        JTextField_Filter = new JTextField();
        JTextField_RestingStatus = new JTextField();
        JTextField_Status = new JTextField();
        JTextField_MinValue = new JTextField();
        JTextField_MaxValue = new JTextField();
        JTextField_Type = new JTextField();
        JTextField_Name = new JTextField();
        JTextField_Income = new JTextField();
        listNodesList = new JList<>();
        model_NodeList = new DefaultListModel();
        jScrollPane1 = new JScrollPane();
        JComboBox_Modifications = new JComboBox<>();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        JButton_ExportNodes = new JButton();
        JButton_ImportNodes = new JButton();
        JButton_AddNode = new JButton();
        JButton_Reset = new JButton();
        JButton_Filter = new JButton();
        JButton_Knockout = new JButton();
        JButton_Save = new JButton();
        JButton_EditMod = new JButton();
        JButton_AddMod = new JButton();

        JTextField_Name.setName("Node Name TextField");
        JTextField_Status.setName("Node Status TextField");
        JTextField_RestingStatus.setName("Node Resting Status TextField");
        JTextField_Income.setName("Metabolic Income TextField");
        JTextField_MinValue.setName("Metabolic Min. Value TextField");
        JTextField_MaxValue.setName("Metabolic Max. Value TextField");

        JLabel_Title.setText("Node Configurations");
        JLabel_SubTitle1.setText("Edit key node settings such as their initial state or knockout specific nodes");
        JLabel_Filter.setText("Filter");
        JButton_Filter.setText("Filter");
        JButton_Knockout.setText("Create a knockout");
        JLabel_NodesList.setText("Nodes List");
        JLabel_Name.setText("Name");
        JLabel_Income.setText("Metabolic income");
        JLabel_Status.setText("Initial status");
        JLabel_RestingStatus.setText("Resting status");
        JLabel_Modifications.setText("Node modifications");
        JLabel_MinValue.setText("Metabolic min. value");
        JButton_EditMod.setText("Edit Mod");
        JLabel_Subtitle2.setText("Edit a node of the network");
        JButton_Save.setText("Save Node Edition");
        JLabel_MaxValue.setText("Metabolic max. value");
        JButton_AddMod.setText("Add Mod");
        JLabel_Type.setText("Node Type");
        JButton_ExportNodes.setText("Export Nodes");
        JButton_ImportNodes.setText("Import Nodes");
        JButton_AddNode.setText("Create Node");
        JButton_Reset.setText("Reset Nodes");

        jScrollPane1.setViewportView(listNodesList);
        listNodesList.setCellRenderer(new JListNodeCellRender());

        JButton_Filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JButton_Filter_ActionPerformed();
            }
        });
        JButton_Knockout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JButton_Knockout_ActionPerformed();
            }
        });
        listNodesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                listNodesList_MouseClicked(evt);
            }
        });
        JButton_Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_Save_ActionPerformed();
            }
        });
        JButton_EditMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_EditMod_ActionPerformed();
            }
        });
        JButton_AddMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_AddMod_ActionPerformed();
            }
        });
        JButton_ExportNodes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_ExportNodes_ActionPerformed();
            }
        });
        JButton_ImportNodes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_ImportNodes_ActionPerformed();
            }
        });
        JButton_AddNode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_AddNode_ActionPerformed();
            }
        });
        JButton_Reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_Reset_ActionPerformed();
            }
        });
    }

    public void setLayoutDesign() {
        setMaximumSize(new Dimension(900, 640));
        setMinimumSize(new Dimension(900, 640));
        setPreferredSize(new Dimension(900, 640));

        jPanelNodeConfigurationsScreen.setMaximumSize(new Dimension(650, 720));
        jPanelNodeConfigurationsScreen.setMinimumSize(new Dimension(650, 720));
        jPanelNodeConfigurationsScreen.setPreferredSize(new Dimension(650, 720));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        GroupLayout jPanelNodeConfigurationsScreenLayout = new GroupLayout(jPanelNodeConfigurationsScreen);
        jPanelNodeConfigurationsScreen.setLayout(jPanelNodeConfigurationsScreenLayout);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        // Organizing jPanel1
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLabel_SubTitle1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JLabel_Title, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addComponent(JLabel_Title)
                                .addGap(6, 6, 6)
                                .addComponent(JLabel_SubTitle1)
                                .addContainerGap())
        );

        // Organizing jPanel2
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(JLabel_Filter, GroupLayout.Alignment.LEADING)
                                                        .addComponent(JLabel_NodesList, GroupLayout.Alignment.LEADING))
                                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent(JTextField_Filter, PREFERRED_SIZE, 261, PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JButton_Filter)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                                                .addComponent(JButton_Knockout, PREFERRED_SIZE, 139, PREFERRED_SIZE)))
                                                .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JLabel_Filter)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JTextField_Filter, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(JButton_Filter)
                                        .addComponent(JButton_Knockout))
                                .addGap(6, 6, 6)
                                .addComponent(JLabel_NodesList)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, PREFERRED_SIZE, 123, PREFERRED_SIZE)
                                .addGap(3, 3, 3))
        );

        // Organizing jPanel3
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(JLabel_Subtitle2, PREFERRED_SIZE, 285, PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jSeparator1)
                                                .addContainerGap())
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(JButton_AddMod, PREFERRED_SIZE, 104, PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JButton_EditMod, PREFERRED_SIZE, 104, PREFERRED_SIZE))
                                                        .addComponent(JLabel_Name, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(JTextField_Name)
                                                        .addComponent(JLabel_Modifications, DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                                        .addComponent(JTextField_RestingStatus)
                                                        .addComponent(JLabel_RestingStatus, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(JLabel_Status, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(JTextField_Status)
                                                        .addComponent(JComboBox_Modifications, 0, DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(140, 140, 140)
                                                                .addComponent(JButton_Save))
                                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(JTextField_MinValue)
                                                                .addComponent(JTextField_Income)
                                                                .addComponent(JTextField_Type)
                                                                .addComponent(JLabel_Income, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(JLabel_MinValue, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(JLabel_Type, PREFERRED_SIZE, 266, PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(JTextField_MaxValue)
                                                                .addComponent(JLabel_MaxValue, PREFERRED_SIZE, 266, PREFERRED_SIZE)))
                                                .addGap(6, 6, 6))))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLabel_Subtitle2)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jSeparator1, PREFERRED_SIZE, 17, PREFERRED_SIZE)))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLabel_Name)
                                        .addComponent(JLabel_Type))
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JTextField_Name, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(JTextField_Type, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLabel_Status)
                                        .addComponent(JLabel_Income))
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JTextField_Status, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(JTextField_Income, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLabel_RestingStatus)
                                        .addComponent(JLabel_MinValue))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JTextField_RestingStatus, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(JTextField_MinValue, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(JLabel_Modifications)
                                                .addGap(0, 0, 0)
                                                .addComponent(JComboBox_Modifications, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(JLabel_MaxValue)
                                                .addGap(0, 0, 0)
                                                .addComponent(JTextField_MaxValue, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(JButton_AddMod)
                                                        .addComponent(JButton_EditMod)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JButton_Save)))
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        // Organizing jPanel4
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(JButton_ExportNodes)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JButton_ImportNodes)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(JButton_AddNode)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JButton_Reset))
                                        .addComponent(jSeparator2, GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator2, DEFAULT_SIZE, 7, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(JButton_AddNode)
                                                .addComponent(JButton_Reset))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(JButton_ExportNodes)
                                                        .addComponent(JButton_ImportNodes))
                                                .addContainerGap())))
        );

        // Organizing jPanelNodeConfigurationsScreenLayout
        jPanelNodeConfigurationsScreenLayout.setHorizontalGroup(
                jPanelNodeConfigurationsScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNodeConfigurationsScreenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelNodeConfigurationsScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanelNodeConfigurationsScreenLayout.setVerticalGroup(
                jPanelNodeConfigurationsScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelNodeConfigurationsScreenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addContainerGap(7, Short.MAX_VALUE))
        );

        // Organizing this panel
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelNodeConfigurationsScreen, PREFERRED_SIZE, 620, PREFERRED_SIZE)
                                .addGap(0, 360, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelNodeConfigurationsScreen, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );
    }

    private void JButton_Filter_ActionPerformed() {
        listNodesList.removeAll();
        listNodesList.setModel(nodeFilter.filterNodes(model_NodeList, nodeList, JTextField_Filter.getText()));
    }

    private void listNodesList_MouseClicked(MouseEvent evt) {
        // Ensures the item will only be accessed on the second click
        if (evt.getClickCount() == 2) {
            selectedNode = listNodesList.getSelectedValue();
            boolean metabolite = false;
            //
            JTextField_Name.setText(selectedNode.getName());
            JTextField_Status.setText(String.valueOf(selectedNode.getStatus()));
            JTextField_RestingStatus.setText(String.valueOf(selectedNode.getRestingStatus()));
            // Checks if the node has modifications and, if so, populates the ComboBox
            JComboBox_Modifications.removeAllItems();
            if (!selectedNode.getNodeModifications().isEmpty()) {
                for (int i = 0; i < selectedNode.getNodeModifications().size(); i++) {
                    JComboBox_Modifications.addItem(selectedNode.getNodeModifications().get(i).getName());
                }
            } else {
                JComboBox_Modifications.addItem("<none>");
            }
            // Set node type
            switch (selectedNode.getType()) {
                case TYPE_PROTEINGENE:
                    JTextField_Type.setText("Protein/Gene");
                    break;
                case TYPE_METABOLITE:
                    JTextField_Type.setText("Metabolite");
                    break;
                case TYPE_OTHER:
                    JTextField_Type.setText("Other");
                    break;
                case TYPE_MIRNA:
                    JTextField_Type.setText("miRNA");
                    ;
                    break;
                case TYPE_DRUG:
                    JTextField_Type.setText("Drug");
                    break;
                default:
                    throw new AssertionError();
            }
            // If the node is a metabolite, populate specific fields for metabolites. If not, block these fields.
            if (selectedNode.getType() == 2) {
                JTextField_Income.setText(String.valueOf(((Metabolite) selectedNode).getIncome()));
                JTextField_MinValue.setText(String.valueOf(((Metabolite) selectedNode).getMinValue()));
                JTextField_MaxValue.setText(String.valueOf(((Metabolite) selectedNode).getMaxValue()));
                metabolite = true;
            }

            JTextField_Income.setEditable(metabolite);
            JTextField_MinValue.setEditable(metabolite);
            JTextField_MaxValue.setEditable(metabolite);
            JTextField_RestingStatus.setEditable(!metabolite);
        }
    }

    private void JButton_Reset_ActionPerformed() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will restore the nodes, including their rules, to those provided by default. Would you like to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            configurations.networkSourceInputType = "default";
            nodeList = networkFactory.createNetwork(configurations).getDefaultNodes();
            setComponents();
        }
    }

    private void JButton_ExportNodes_ActionPerformed() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will not export any unsaved changes. Would you like to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    // Export node settings
                    XMLNetworkWriter.exportNodeList(file.getAbsolutePath(), nodeList);
                    JOptionPane.showMessageDialog(this, "Export completed successfully.", "Successful Import", JOptionPane.INFORMATION_MESSAGE);
                } catch (ParserConfigurationException | IOException | SAXException | TransformerException ex) {
                }
            } else {
                System.out.println("File access cancelled by user.");
            }
        }
    }

    private void JButton_ImportNodes_ActionPerformed() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will replace the current network, including its rules, with the chosen network. Would you like to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileChooser.getSelectedFile();
                    // Replaces the list of current nodes with those submitted by the user.
                    nodeList = XMLNetworkReader.importNodeList(file);
                    shown();
                    JOptionPane.showMessageDialog(this, "File imported successfully.", "Successful Import", JOptionPane.INFORMATION_MESSAGE);
                } catch (ParserConfigurationException | IOException | SAXException ex) {
                }
            } else {
                System.out.println("File access cancelled by user.");
            }
        }
    }

    private void JButton_Save_ActionPerformed() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will save any changes made to the nodes. Would you like to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            /* Validations and alerts: 
             * Checks if Node Name, Node Initial Status, Node Resting Status and all Metabolic fields are filled in and 
             * if the float fields have only positive and higher numbers that zero.
            */
            ArrayList<JTextField> validationMandatoryTextFields = new ArrayList<>();
            ArrayList<JTextField> validationDoubleTextFields = new ArrayList<>();
            validationMandatoryTextFields.add(JTextField_Name);
            validationDoubleTextFields.add(JTextField_Status);
            validationDoubleTextFields.add(JTextField_RestingStatus);
            if (selectedNode.getType() == 2) {
                validationDoubleTextFields.add(JTextField_Income);
                validationDoubleTextFields.add(JTextField_MinValue);
                validationDoubleTextFields.add(JTextField_MaxValue);
            }
            validationMandatoryTextFields.addAll(validationDoubleTextFields);
            if (!fieldValidation.validateMandatoryTextField(validationMandatoryTextFields, null)
                    || !fieldValidation.validatePositiveDoubleTextField(validationDoubleTextFields, null)) {
                return;
            }

            selectedNode.setStatus(Double.valueOf(JTextField_Status.getText()));
            selectedNode.setRestingStatus(Double.valueOf(JTextField_RestingStatus.getText()));
            selectedNode.setStatus(Double.valueOf(JTextField_Status.getText()));
            if (selectedNode.getType() == 2) {
                ((Metabolite) selectedNode).setIncome(Double.valueOf(JTextField_Income.getText()));
                ((Metabolite) selectedNode).setMinValue(Double.valueOf(JTextField_MinValue.getText()));
                ((Metabolite) selectedNode).setMaxValue(Double.valueOf(JTextField_MaxValue.getText()));
            }
        }
    }

    private void JButton_EditMod_ActionPerformed() {
        // Checks if a node has been selected by the user.
        if (JTextField_Name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "[ERROR] No nodes were selected.", "Error - Empty Node", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Checks if the node has any modifications to be edited.
        if (JComboBox_Modifications.getItemAt(0).equals("<none>")) {
            JOptionPane.showMessageDialog(this, "[ERROR] This node has no modifications available for editing.", "Error - Empty Node", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int modificationIndex = JComboBox_Modifications.getSelectedIndex();
        EditModification frame = new EditModification(configurations, nodeList, selectedNode, modificationIndex);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void JButton_AddMod_ActionPerformed() {
        // Checks if a node has been selected by the user.
        if (JTextField_Name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "[ERROR] No nodes were selected.", "Error - Empty Node", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CreateModification frame = new CreateModification(configurations, selectedNode);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void JButton_Knockout_ActionPerformed() {
        CreateKnockout frame = new CreateKnockout(configurations, nodeList);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void JButton_AddNode_ActionPerformed() {
        CreateNode frame = new CreateNode(configurations, nodeList);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
}
