/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.nodes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.rules.Rule;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.gui.components.JListNodeCellRender;
import org.pseudocell.gui.components.JListRuleCellRender;
import org.pseudocell.config.Config;
import org.pseudocell.gui.utils.NodeFilter;
import org.pseudocell.gui.utils.RuleSummary;

/**
 *
 * @author ViníciusPierdoná
 */
public class CreateKnockout extends JFrame {
    
    private static final int DEFAULT_SIZE = GroupLayout.DEFAULT_SIZE;
    private static final int PREFERRED_SIZE = GroupLayout.PREFERRED_SIZE;
    private static final int TYPE_PROTEINGENE = 1;
    private static final int TYPE_METABOLITE = 2;
    private static final int TYPE_OTHER = 3;
    private static final int TYPE_MIRNA = 4;
    private static final int TYPE_DRUG = 5;

    // Components variables
    private JButton jButtonFilter;
    private JCheckBox jCheckBoxKnockdown;
    private JLabelTitle jLabelTitle;
    private JLabelSubTitle jLabelSubtitle;
    private JLabel jLabelFilter, jLabelNodeList, jLabelNodeName, jLabelNodeType, jLabelRestingStatus, jLabelRules,
            jLabelStatus;
    private JPanel jPanelCreateKnockoutScreen;
    private JSeparator jSeparator4, jSeparator5;
    private JTextField jTextFieldFilter, jTextFieldNodeName, jTextFieldNodeType, jTextFieldRestingStatus, jTextFieldStatus;
    private JList<Node> JList_NodeList;
    private JList<Rule> JList_RuleList;
    private DefaultListModel model_RuleList, model_NodeList;
    private JScrollPane jScrollPane1, jScrollPane2;

    Config configurations;
    List<Node> nodeList;
    NodeFilter nodeFilter;
    Node selectedNode;
    RuleSummary ruleSummary;

    /**
     * Creates new form CreateKnockout
     *
     * @param configurations
     * @param nodeList
     */
    public CreateKnockout(Config configurations, List<Node> nodeList) {
        setTitle("Pseudocell - Create a knockout for your simulations");

        this.configurations = configurations;
        this.nodeList = nodeList;
        this.nodeFilter = new NodeFilter();
        this.ruleSummary = new RuleSummary();

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
        JList_NodeList.setModel(nodeFilter.filterNodes(model_NodeList, nodeList, null));
    }

    public void setComponents() {
        jPanelCreateKnockoutScreen = new JPanel();
        jSeparator4 = new JSeparator();
        jSeparator5 = new JSeparator();
        jLabelTitle = new JLabelTitle();
        jLabelSubtitle = new JLabelSubTitle();
        jLabelNodeName = new JLabel();
        jLabelNodeType = new JLabel();
        jLabelNodeList = new JLabel();
        jLabelRestingStatus = new JLabel();
        jLabelStatus = new JLabel();
        jLabelFilter = new JLabel();
        jLabelRules = new JLabel();
        jTextFieldNodeName = new JTextField();
        jTextFieldNodeType = new JTextField();
        jTextFieldStatus = new JTextField();
        jTextFieldFilter = new JTextField();
        jTextFieldRestingStatus = new JTextField();
        JList_NodeList = new JList<>();
        JList_RuleList = new JList<>();
        model_RuleList = new DefaultListModel();
        model_NodeList = new DefaultListModel();
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        jButtonFilter = new JButton();
        jCheckBoxKnockdown = new JCheckBox();

        jLabelSubtitle.setText("Knockout a node");
        jLabelNodeName.setText("Node name");
        jLabelNodeType.setText("Node type");
        jLabelTitle.setText("Edit Network");
        jLabelStatus.setText("Initial Status");
        jLabelNodeList.setText("Node List");
        jLabelRestingStatus.setText("Resting Status");
        jLabelFilter.setText("Filter");
        jButtonFilter.setText("Filter");
        jLabelRules.setText("Rules associated with this node");
        jTextFieldNodeName.setEditable(false);
        jTextFieldNodeType.setEditable(false);
        jTextFieldStatus.setEditable(false);
        jTextFieldRestingStatus.setEditable(false);

        jScrollPane1.setViewportView(JList_NodeList);
        jScrollPane2.setViewportView(JList_RuleList);
        JList_NodeList.setCellRenderer(new JListNodeCellRender());
        JList_RuleList.setCellRenderer(new JListRuleCellRender());

        JList_NodeList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList_NodeList_MouseClicked(evt);
            }
        });
        jButtonFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_Filter_ActionPerformed(evt);
            }
        });

        jCheckBoxKnockdown.setText("Knockout");
        jCheckBoxKnockdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_Knockdown_ItemStateChanged(evt);
            }
        });
    }

    public void setLayoutDesign() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        jPanelCreateKnockoutScreen.setMaximumSize(new java.awt.Dimension(680, 620));
        jPanelCreateKnockoutScreen.setPreferredSize(new java.awt.Dimension(680, 620));

        javax.swing.GroupLayout jPanelCreateKnockoutScreenLayout = new javax.swing.GroupLayout(jPanelCreateKnockoutScreen);
        jPanelCreateKnockoutScreen.setLayout(jPanelCreateKnockoutScreenLayout);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        jPanelCreateKnockoutScreenLayout.setHorizontalGroup(
                jPanelCreateKnockoutScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelCreateKnockoutScreenLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator5, PREFERRED_SIZE, 579, PREFERRED_SIZE)
                                        .addGroup(jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabelTitle)
                                                .addGroup(jPanelCreateKnockoutScreenLayout.createSequentialGroup()
                                                        .addComponent(jLabelSubtitle)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jSeparator4, PREFERRED_SIZE, 437, PREFERRED_SIZE))
                                                .addGroup(jPanelCreateKnockoutScreenLayout.createSequentialGroup()
                                                        .addGroup(jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanelCreateKnockoutScreenLayout.createSequentialGroup()
                                                                        .addComponent(jLabelNodeList)
                                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                                .addGroup(jPanelCreateKnockoutScreenLayout.createSequentialGroup()
                                                                        .addGroup(jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addGroup(jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jScrollPane1, PREFERRED_SIZE, 288, PREFERRED_SIZE)
                                                                                        .addGroup(jPanelCreateKnockoutScreenLayout.createSequentialGroup()
                                                                                                .addComponent(jLabelFilter)
                                                                                                .addGap(258, 258, 258)))
                                                                                .addGroup(jPanelCreateKnockoutScreenLayout.createSequentialGroup()
                                                                                        .addComponent(jTextFieldFilter, PREFERRED_SIZE, 192, PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jButtonFilter)))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jCheckBoxKnockdown, GroupLayout.Alignment.TRAILING)
                                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelNodeName)
                                                                        .addComponent(jTextFieldNodeName, PREFERRED_SIZE, 240, PREFERRED_SIZE)
                                                                        .addComponent(jLabelStatus)
                                                                        .addComponent(jTextFieldStatus, PREFERRED_SIZE, 240, PREFERRED_SIZE)
                                                                        .addComponent(jLabelRestingStatus)
                                                                        .addComponent(jTextFieldRestingStatus, PREFERRED_SIZE, 240, PREFERRED_SIZE)
                                                                        .addComponent(jLabelNodeType)
                                                                        .addComponent(jTextFieldNodeType, PREFERRED_SIZE, 240, PREFERRED_SIZE))))
                                                .addComponent(jLabelRules)
                                                .addComponent(jScrollPane2, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanelCreateKnockoutScreenLayout.setVerticalGroup(
                jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelCreateKnockoutScreenLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabelTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelSubtitle)
                                        .addComponent(jSeparator4, PREFERRED_SIZE, 11, PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelFilter)
                                .addGap(0, 0, 0)
                                .addGroup(jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldFilter, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(jCheckBoxKnockdown)
                                        .addComponent(jButtonFilter))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNodeName)
                                        .addComponent(jLabelNodeList))
                                .addGroup(jPanelCreateKnockoutScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanelCreateKnockoutScreenLayout.createSequentialGroup()
                                                .addComponent(jTextFieldNodeName, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabelNodeType)
                                                .addGap(0, 0, 0)
                                                .addComponent(jTextFieldNodeType, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabelStatus)
                                                .addGap(0, 0, 0)
                                                .addComponent(jTextFieldStatus, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabelRestingStatus)
                                                .addGap(0, 0, 0)
                                                .addComponent(jTextFieldRestingStatus, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelRules)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, PREFERRED_SIZE, 134, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                                .addGap(73, 73, 73))
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanelCreateKnockoutScreen, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanelCreateKnockoutScreen, DEFAULT_SIZE, 632, Short.MAX_VALUE))
        );
        pack();
    }

    private void jButton_Filter_ActionPerformed(java.awt.event.ActionEvent evt) {
        model_NodeList.clear();
        JList_NodeList.setModel(nodeFilter.filterNodes(model_NodeList, nodeList, jTextFieldFilter.getText()));
    }

    private void JList_NodeList_MouseClicked(java.awt.event.MouseEvent evt) {
        // Ensures the item will only be accessed on the second click
        if (evt.getClickCount() == 2) {
            selectedNode = JList_NodeList.getSelectedValue();
            // Populates the fields with the selected node
            jTextFieldNodeName.setText(selectedNode.getName());
            jTextFieldStatus.setText(String.valueOf(selectedNode.getStatus()));
            jTextFieldRestingStatus.setText(String.valueOf(selectedNode.getRestingStatus()));
            // Set node type
            switch (selectedNode.getType()) {
                case TYPE_PROTEINGENE:
                    jTextFieldNodeType.setText("Protein/Gene");
                    break;
                case TYPE_METABOLITE:
                    jTextFieldNodeType.setText("Metabolite");
                    break;
                case TYPE_OTHER:
                    jTextFieldNodeType.setText("Other");
                    break;
                case TYPE_MIRNA:
                    jTextFieldNodeType.setText("miRNA");
                    ;
                    break;
                case TYPE_DRUG:
                    jTextFieldNodeType.setText("Drug");
                    break;
                default:
                    throw new AssertionError();
            }
            jCheckBoxKnockdown.setSelected(selectedNode.getKnockdown());
            model_RuleList.clear();
            List<Rule> ruleList = selectedNode.getRules();
            for (Rule rule : ruleList) {
                model_RuleList.addElement(rule);
            }
            JList_RuleList.setModel(model_RuleList);
        }
    }

    private void jCheckBox_Knockdown_ItemStateChanged(java.awt.event.ItemEvent evt) {
        if (jTextFieldNodeName.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "[ERROR] No nodes were selected.", "Error - Empty Node", JOptionPane.ERROR_MESSAGE);
            return;
        }
        selectedNode.setKnockdown(jCheckBoxKnockdown.isSelected());
    }

}
