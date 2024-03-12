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
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.nodes.NodeModification;
import org.pseudocell.core.rules.MetabolicRule;
import org.pseudocell.core.rules.ModificationRule;
import org.pseudocell.core.rules.Rule;
import org.pseudocell.core.utils.StringUtil;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.gui.components.JListNodeCellRender;
import org.pseudocell.gui.components.JListRuleCellRender;
import org.pseudocell.gui.components.JSpinnerDouble;
import org.pseudocell.gui.components.RuleTree;
import org.pseudocell.config.Config;
import org.pseudocell.gui.rules.CreateRule;
import org.pseudocell.gui.rules.EditRule;
import org.pseudocell.gui.utils.NodeFilter;
import org.pseudocell.gui.utils.RuleSummary;
import org.pseudocell.gui.utils.StringMatcher;
import org.pseudocell.gui.validation.RuleValidation;

/**
 *
 * @author ViníciusPierdoná
 */
public class JPanelNetworkEditor extends JPanel {

    private static int DEFAULT_SIZE = GroupLayout.DEFAULT_SIZE;
    private static int PREFERRED_SIZE = GroupLayout.PREFERRED_SIZE;

    // Components variables
    private JButton jButton_CreateBracket, jButton_CreateNew, jButton_Edit, jButton_Delete, jButton_Filter, jButton_Save;
    private JComboBox<String> jComboBox_ComparisionVariable, jComboBox_InputNode, jComboBox_LogicalOperator,
            jComboBox_Modification, jComboBox_ModificationValue, jComboBox_Node, jComboBox_OutputNode, jComboBox_RelationalOperator;
    private JLabelTitle jLabel_Title;
    private JLabelSubTitle jLabel_SubTitle, jLabel_Subtitle2;
    private JLabel jLabel_ComparisionValue, jLabel_ComparisionVariable, jLabel_ConversionValue, jLabel_Filter,
            jLabel_InputNode, jLabel_LogicalOperator, jLabel_MetabolicTitle, jLabel_Modification, jLabel_ModificationTitle,
            jLabel_ModificationValue, jLabel_Node, jLabel_NodeList, jLabel_OuputNode, jLabel_RelationalOperator, jLabel_RuleList;
    private JList<Rule> jList_RuleList;
    private JList<Node> jList_NodeList;
    private DefaultListModel model_RuleList, model_NodeList;
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanel5, jPanel6;
    private JPanel jPanel_RuleEditor, jPanel_RuleSelection;
    private JScrollPane jScrollPane1, jScrollPane2, jScrollPane3;
    private JSeparator jSeparator1, jSeparator2, jSeparator3;
    //private JSpinner jSpinner_ComparisionValue;
    private JSpinnerDouble jSpinner_ConversionValue, jSpinner_ComparisionValue;
    private JTextField jTextField_Filter;
    private RuleTree jTree_RuleEditor;

    private Config configurations;
    private List<Node> nodeList;
    private NodeFilter nodeFilter;
    private Node selectedNode;
    private Rule selectedRule;
    private DefaultMutableTreeNode selectedTreeNode;
    private RuleSummary ruleSummary;
    private RuleValidation ruleValidation;
    private int bracketNumber;

    /**
     * Creates new form NetworkEditor
     *
     * @param configurations
     * @param nodeList
     */
    public JPanelNetworkEditor(Config configurations, List<Node> nodeList) {
        this.configurations = configurations;
        this.nodeList = nodeList;
        this.nodeFilter = new NodeFilter();
        this.ruleSummary = new RuleSummary();
        this.ruleValidation = new RuleValidation();
        this.bracketNumber = 1;

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
        jList_NodeList.setModel(nodeFilter.filterNodes(model_NodeList, nodeList, null));
    }

    private void setComponents() {

        jLabel_Title = new JLabelTitle();
        jLabel_SubTitle = new JLabelSubTitle();
        jLabel_Subtitle2 = new JLabelSubTitle();
        jLabel_Filter = new JLabel();
        jLabel_NodeList = new JLabel();
        jLabel_RuleList = new JLabel();
        jLabel_RelationalOperator = new JLabel();
        jLabel_ComparisionValue = new JLabel();
        jLabel_LogicalOperator = new JLabel();
        jLabel_Node = new JLabel();
        jLabel_ComparisionVariable = new JLabel();
        jLabel_MetabolicTitle = new JLabel();
        jLabel_InputNode = new JLabel();
        jLabel_OuputNode = new JLabel();
        jLabel_ConversionValue = new JLabel();
        jLabel_ModificationTitle = new JLabel();
        jLabel_Modification = new JLabel();
        jLabel_ModificationValue = new JLabel();
        jPanel_RuleSelection = new JPanel();
        jPanel_RuleEditor = new JPanel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jTextField_Filter = new JTextField();
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        jScrollPane3 = new JScrollPane();
        jList_NodeList = new JList<>();
        jList_RuleList = new JList<>();
        model_NodeList = new DefaultListModel();
        model_RuleList = new DefaultListModel();
        jButton_Filter = new JButton();
        jButton_CreateNew = new JButton();
        jButton_Edit = new JButton();
        jButton_CreateBracket = new JButton();
        jButton_Save = new JButton();
        jButton_Delete = new JButton();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jSeparator3 = new JSeparator();
        jTree_RuleEditor = new RuleTree();
        jComboBox_Node = new JComboBox<>();
        jComboBox_ComparisionVariable = new JComboBox<>();
        jComboBox_RelationalOperator = new JComboBox<>();
        jComboBox_LogicalOperator = new JComboBox<>();
        jComboBox_InputNode = new JComboBox<>();
        jComboBox_OutputNode = new JComboBox<>();
        jComboBox_Modification = new JComboBox<>();
        jComboBox_ModificationValue = new JComboBox<>();
        jSpinner_ComparisionValue = new JSpinnerDouble();
        jSpinner_ConversionValue = new JSpinnerDouble();

        jLabel_Title.setText("Edit Network Rules");
        jLabel_SubTitle.setText("Edit the logic rules that determine the state of nodes.");
        jLabel_Filter.setText("Filter");
        jLabel_NodeList.setText("Node List");
        jLabel_RuleList.setText("Rule List");
        jLabel_Subtitle2.setText("Rule Editor");
        jLabel_RelationalOperator.setText("Relational operator");
        jLabel_ComparisionValue.setText("Comparision value");
        jLabel_LogicalOperator.setText("Logical operator");
        jLabel_Node.setText("Node");
        jLabel_ComparisionVariable.setText("Comparison variable");
        jLabel_MetabolicTitle.setText("Metabolic rules variables");
        jLabel_InputNode.setText("Input node");
        jLabel_OuputNode.setText("Output node");
        jLabel_ConversionValue.setText("Conversion value");
        jLabel_ModificationTitle.setText("Modification rules variables");
        jLabel_Modification.setText("Modification");
        jLabel_ModificationValue.setText("Modification value");
        jButton_Filter.setText("Filter");
        jButton_CreateNew.setText("Create new");
        jButton_Edit.setText("Edit rule");
        jButton_CreateBracket.setText("Create Bracket");
        jButton_Save.setText("Save");
        jButton_Delete.setText("Delete");

        jScrollPane1.setViewportView(jList_NodeList);
        jScrollPane2.setViewportView(jList_RuleList);
        jScrollPane3.setViewportView(jTree_RuleEditor);
        jList_NodeList.setCellRenderer(new JListNodeCellRender());
        jList_RuleList.setCellRenderer(new JListRuleCellRender());

//        jScrollPane2.setMaximumSize(new Dimension(380, 160));
        jList_NodeList.setModel(nodeFilter.filterNodes(model_NodeList, nodeList, null));

        jComboBox_RelationalOperator.setModel(new DefaultComboBoxModel<>(new String[]{">=", "<=", ">", "<", "=="}));
        jComboBox_LogicalOperator.setModel(new DefaultComboBoxModel<>(new String[]{"<none>", "AND", "OR"}));
        jComboBox_ModificationValue.setModel(new DefaultComboBoxModel<>(new String[]{"true", "false"}));
        for (Node node : nodeList) {
            jComboBox_Node.addItem(node.getName());
            jComboBox_InputNode.addItem(node.getName());
            jComboBox_OutputNode.addItem(node.getName());
        }

        jButton_Filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButton_Filter_ActionPerformed(evt);
            }
        });
        jButton_CreateNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButton_CreateNew_ActionPerformed(evt);
            }
        });
        jButton_Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButton_Edit_ActionPerformed(evt);
            }
        });
        jButton_CreateBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButton_CreateBracket_ActionPerformed();
            }
        });
        jButton_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButton_Save_ActionPerformed();
            }
        });
        jButton_Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButton_Delete_ActionPerformed();
            }
        });
        jList_NodeList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                jList_NodeList_MouseClicked(evt);
            }
        });
        jList_RuleList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                jList_RuleList_MouseClicked(evt);
            }
        });
        jTree_RuleEditor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                jTree_RuleEditor_MouseClicked(evt);
            }
        });
    }

    private void setLayoutDesign() {
        setMaximumSize(new Dimension(900, 640));
        setMinimumSize(new Dimension(900, 640));
        setPreferredSize(new Dimension(900, 640));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        GroupLayout jPanel_RuleSelectionLayout = new GroupLayout(jPanel_RuleSelection);
        jPanel_RuleSelection.setLayout(jPanel_RuleSelectionLayout);
        GroupLayout jPanel_RuleEditorLayout = new GroupLayout(jPanel_RuleEditor);
        jPanel_RuleEditor.setLayout(jPanel_RuleEditorLayout);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        // Organizing jPanel1
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup()
                                        .addComponent(jLabel_Title)
                                        .addComponent(jLabel_SubTitle)))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel_Title)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel_SubTitle))
        );

        // Organizing jPanel2
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup()
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup()
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextField_Filter, PREFERRED_SIZE, 260, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton_Filter, PREFERRED_SIZE, 100, PREFERRED_SIZE))
                                        .addComponent(jLabel_NodeList, PREFERRED_SIZE, 60, PREFERRED_SIZE)
                                        .addComponent(jLabel_Filter, PREFERRED_SIZE, 40, PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup()
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_Filter)
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup()
                                        .addComponent(jButton_Filter)
                                        .addComponent(jTextField_Filter))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_NodeList)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, PREFERRED_SIZE, 110, PREFERRED_SIZE)
                                .addGap(36, 36, 36))
        );

        // Organizing jPanel3
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_RuleList))
                        .addComponent(jScrollPane2, PREFERRED_SIZE, 380, PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel_RuleList)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, PREFERRED_SIZE, 165, PREFERRED_SIZE)
                                .addContainerGap())
        );

        // Organizing RuleSelectionLayout
        jPanel_RuleSelectionLayout.setHorizontalGroup(
                jPanel_RuleSelectionLayout.createParallelGroup()
                        .addGroup(jPanel_RuleSelectionLayout.createParallelGroup()
                                .addGroup(jPanel_RuleSelectionLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel_RuleSelectionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jPanel1, GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel_RuleSelectionLayout.createSequentialGroup()
                                                        .addComponent(jPanel2)
                                                        .addGap(36, 36, 36)
                                                        .addComponent(jPanel3)))))
        );
        jPanel_RuleSelectionLayout.setVerticalGroup(
                jPanel_RuleSelectionLayout.createParallelGroup()
                        .addGroup(jPanel_RuleSelectionLayout.createParallelGroup()
                                .addGroup(jPanel_RuleSelectionLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel_RuleSelectionLayout.createParallelGroup()
                                                .addComponent(jPanel3)
                                                .addComponent(jPanel2, PREFERRED_SIZE, 190, Short.MAX_VALUE))
                                        .addContainerGap(33, Short.MAX_VALUE)))
        );

        // Organizing jPanel4
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup()
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_Subtitle2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1)
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup()
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator1, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                                        .addComponent(jLabel_Subtitle2))
                                .addContainerGap())
        );

        // Organizing jPanel5
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup()
                        .addComponent(jScrollPane3)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap(164, Short.MAX_VALUE)
                                .addComponent(jButton_CreateNew)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Edit)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup()
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_CreateNew)
                                        .addComponent(jButton_Edit)))
        );

        // Organizing jPanel6
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup())
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup()
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                                        .addComponent(jComboBox_Node, PREFERRED_SIZE, 186, PREFERRED_SIZE)
                                                                        .addComponent(jLabel_Node))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(jLabel_ComparisionVariable))
                                                                        .addComponent(jComboBox_ComparisionVariable)))
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(jLabel_MetabolicTitle)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator2))
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                                        .addComponent(jComboBox_RelationalOperator, PREFERRED_SIZE, 120, PREFERRED_SIZE)
                                                                        .addComponent(jLabel_RelationalOperator))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                                        .addComponent(jSpinner_ComparisionValue, PREFERRED_SIZE, 126, PREFERRED_SIZE)
                                                                        .addComponent(jLabel_ComparisionValue))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(jLabel_LogicalOperator))
                                                                        .addComponent(jComboBox_LogicalOperator, 0, DEFAULT_SIZE, Short.MAX_VALUE)))))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(jComboBox_InputNode, PREFERRED_SIZE, 120, PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jComboBox_OutputNode, PREFERRED_SIZE, 126, PREFERRED_SIZE))
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(jLabel_InputNode)
                                                                                .addGap(69, 69, 69)
                                                                                .addComponent(jLabel_OuputNode)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(jLabel_ConversionValue)
                                                                                .addGap(0, 35, Short.MAX_VALUE))
                                                                        .addComponent(jSpinner_ConversionValue)))
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(jLabel_ModificationTitle)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator3))
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                                        .addComponent(jComboBox_Modification, PREFERRED_SIZE, 186, PREFERRED_SIZE)
                                                                        .addComponent(jLabel_Modification))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel6Layout.createParallelGroup()
                                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addComponent(jLabel_ModificationValue))
                                                                        .addComponent(jComboBox_ModificationValue, 0, DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup()
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_Node)
                                        .addComponent(jLabel_ComparisionVariable))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox_Node)
                                        .addComponent(jComboBox_ComparisionVariable))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_RelationalOperator)
                                        .addComponent(jLabel_ComparisionValue)
                                        .addComponent(jLabel_LogicalOperator))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox_RelationalOperator)
                                        .addComponent(jSpinner_ComparisionValue)
                                        .addComponent(jComboBox_LogicalOperator))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup()
                                        .addComponent(jLabel_MetabolicTitle)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jSeparator2)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup()
                                        .addComponent(jLabel_InputNode)
                                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel_OuputNode)
                                                .addComponent(jLabel_ConversionValue)))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox_InputNode)
                                        .addComponent(jComboBox_OutputNode)
                                        .addComponent(jSpinner_ConversionValue))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup()
                                        .addComponent(jLabel_ModificationTitle)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jSeparator3)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_Modification)
                                        .addComponent(jLabel_ModificationValue))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox_Modification)
                                        .addComponent(jComboBox_ModificationValue))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)))
        );

        // Organizing jPanel_RuleEditor
        jPanel_RuleEditorLayout.setHorizontalGroup(
                jPanel_RuleEditorLayout.createParallelGroup()
                        .addGroup(jPanel_RuleEditorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_RuleEditorLayout.createParallelGroup()
                                        .addComponent(jPanel4)
                                        .addGroup(jPanel_RuleEditorLayout.createSequentialGroup()
                                                .addComponent(jPanel5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                                .addComponent(jPanel6)))
                                .addContainerGap())
        );
        jPanel_RuleEditorLayout.setVerticalGroup(
                jPanel_RuleEditorLayout.createParallelGroup()
                        .addGroup(jPanel_RuleEditorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGroup(jPanel_RuleEditorLayout.createParallelGroup()
                                        .addComponent(jPanel5)
                                        .addComponent(jPanel6))
                                .addContainerGap())
        );

        // Organizing this panel        
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel_RuleSelection)
                                        .addComponent(jPanel_RuleEditor))
                                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel_RuleSelection, PREFERRED_SIZE, 298, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel_RuleEditor)
                                .addContainerGap(47, Short.MAX_VALUE))
        );
    }

    private void jButton_Filter_ActionPerformed(ActionEvent evt) {
        model_NodeList.clear();
        jList_NodeList.setModel(nodeFilter.filterNodes(model_NodeList, nodeList, jTextField_Filter.getText()));
    }

    private void jButton_CreateNew_ActionPerformed(ActionEvent evt) {
        if (selectedNode != null) {
            CreateRule frame = new CreateRule(configurations, selectedNode, nodeList);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "[ERROR] No nodes were selected.", "Error - Empty Node", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void jButton_Edit_ActionPerformed(ActionEvent evt) {
        if (selectedNode != null) {
            if (selectedRule != null) {
                EditRule frame = new EditRule(configurations, selectedNode, nodeList, selectedRule);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "[ERROR] No rule was selected.", "Error - Empty Rule", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "[ERROR] No node was selected.", "Error - Empty Node", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void jList_NodeList_MouseClicked(MouseEvent evt) {
        // Ensures the item will only be accessed on the second click
        if (evt.getClickCount() == 2) {
            selectedNode = jList_NodeList.getSelectedValue();
            model_RuleList.clear();
            List<Rule> ruleList = selectedNode.getRules();
            for (Rule rule : ruleList) {
                model_RuleList.addElement(rule);
            }
            jList_RuleList.setModel(model_RuleList);
            jTree_RuleEditor.clear();
        }
    }

    private void jList_RuleList_MouseClicked(MouseEvent evt) {
        // Ensures the item will only be accessed on the second click
        if (evt.getClickCount() == 2) {
            selectedRule = jList_RuleList.getSelectedValue();
            jTree_RuleEditor.populateTree(selectedRule);

            // Populates the fields referring to metabolic rules
            if (selectedRule instanceof MetabolicRule) {
                jComboBox_InputNode.setSelectedItem(selectedRule.getInputNode());
                jComboBox_OutputNode.setSelectedItem(selectedRule.getOutputNode());
                jSpinner_ConversionValue.setValue(selectedRule.getNodeStatus());
            }

            //Populates the fields referring to modification rules
            if (selectedRule instanceof ModificationRule) {
                for (NodeModification mod : selectedNode.getNodeModifications()) {
                    jComboBox_Modification.addItem(mod.getName());
                }
                jComboBox_Modification.setSelectedItem(selectedRule.getModification());
                if (selectedRule.getNodeStatus() == 1.0) {
                    jComboBox_ModificationValue.setSelectedItem("true");
                } else {
                    jComboBox_ModificationValue.setSelectedItem("false");
                }
            }
        }
    }

    private void jTree_RuleEditor_MouseClicked(MouseEvent evt) {
        // Ensures the item will only be accessed on the second click
        if (evt.getClickCount() == 2) {
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) jTree_RuleEditor.getLastSelectedPathComponent();
            // Checks if any nodes have been selected and if the selected node is a relational operation
            if (treeNode != null && treeNode.isLeaf()) {
                Object treeNodeSelected = treeNode.getUserObject();
                TreeNode[] selectedTreeNodePath = treeNode.getPath();
                selectedTreeNode = (DefaultMutableTreeNode) (selectedTreeNodePath[selectedTreeNodePath.length - 1]);
                List<String> ruleFragmentVariables = processRuleFragment((String) treeNodeSelected);
                jComboBox_Node.setSelectedItem(ruleFragmentVariables.get(0));
                for (Node node : nodeList) {
                    if (node.getName().equals(ruleFragmentVariables.get(0))) {
                        jComboBox_ComparisionVariable.removeAllItems();
                        jComboBox_ComparisionVariable.addItem("Status");
                        if (!node.getNodeModifications().isEmpty()) {
                            for (NodeModification mod : node.getNodeModifications()) {
                                jComboBox_ComparisionVariable.addItem(mod.getName());
                            }
                        }
                        break;
                    }
                }
                jComboBox_ComparisionVariable.setSelectedItem(ruleFragmentVariables.get(1));
                jComboBox_RelationalOperator.setSelectedItem(ruleFragmentVariables.get(2));
                jSpinner_ComparisionValue.setValue(Double.valueOf(ruleFragmentVariables.get(3)));
                if (ruleFragmentVariables.get(4) == null) {
                    // Checks if the operation is associated with a logic rule. The final operations of the rule are not.
                    jComboBox_LogicalOperator.setSelectedItem("<none>");
                } else if (ruleFragmentVariables.get(4).equals("&")) {
                    jComboBox_LogicalOperator.setSelectedItem("AND");
                } else if (ruleFragmentVariables.get(4).equals("|")) {
                    jComboBox_LogicalOperator.setSelectedItem("OR");
                }
                for (NodeModification mod : selectedNode.getNodeModifications()) {
                    jComboBox_Modification.addItem(mod.getName());
                }
            }
        }
    }

    private void jButton_Save_ActionPerformed() {
        String nodeName = jComboBox_Node.getSelectedItem().toString();
        String comparisionVariable = String.valueOf(jComboBox_ComparisionVariable.getSelectedItem());
        String relationalOperation = String.valueOf(jComboBox_RelationalOperator.getSelectedItem());

        // Format the value returned by the Spinner
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        String comparisionValue = df.format(jSpinner_ComparisionValue.getValue());

        String logicalOperation = String.valueOf(jComboBox_LogicalOperator.getSelectedItem());
        String ruleString = "Node:" + nodeName + "#";
        if (!comparisionVariable.equals("Status")) {
            ruleString += comparisionVariable + ";";
        }
        ruleString += relationalOperation + comparisionValue + " ";
        if (logicalOperation.equals("AND")) {
            ruleString += "&";
        } else if (logicalOperation.equals("OR")) {
            ruleString += "|";
        }
        selectedTreeNode.setUserObject(ruleString);
    }

    private void jButton_Delete_ActionPerformed() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will delete the selected operation or, if it is a bracket, all operations inside of it. Are you sure you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (selectedRule != null) {
                jTree_RuleEditor.removeCurrentNode();
            } else {
                JOptionPane.showMessageDialog(this, "[ERROR] No rule were selected.", "Error - Empty Rule", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }

    private void jButton_CreateBracket_ActionPerformed() {
        if (selectedRule != null) {
            jTree_RuleEditor.addObject("[Bracket " + bracketNumber++ + "]");
        } else {
            JOptionPane.showMessageDialog(this, "[ERROR] No rule were selected.", "Error - Empty Rule", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    public List<String> processRuleFragment(String ruleFragment) {
        List<String> ruleFragmentVariables = new ArrayList();
        String nodeName = null;
        String comparisionVariable = null;
        String relationalOperator = null;
        String comparisionNumber = null;
        String logicalOperator = null;
        ruleFragment = StringUtil.removeCharacters(ruleFragment, ' ');
        // Checks if the current rule fragment is a relational operation and a regular Node
        if (ruleFragment.startsWith("Node:")) {
            int firstIndex = ruleFragment.indexOf("Node:") + 5;
            int lastIndex = ruleFragment.indexOf("#");
            nodeName = ruleFragment.substring(firstIndex, lastIndex);
            comparisionVariable = "Status";
            // Checks if the current rule fragment is a relational operation and is associated with an accessory variable
        } else if (ruleFragment.startsWith("Mod:")) {
            int firstIndex = ruleFragment.indexOf("Mod:") + 4;
            int lastIndex = ruleFragment.indexOf("#");
            int modIndex = ruleFragment.indexOf(";");
            nodeName = ruleFragment.substring(firstIndex, lastIndex);
            comparisionVariable = ruleFragment.substring(lastIndex + 1, modIndex);
        }
        StringMatcher stringMatcher = new StringMatcher();
        relationalOperator = stringMatcher.findRelationalOperator(ruleFragment);
        String splitted[] = ruleFragment.split("[<>=]+");
        comparisionNumber = splitted[1].replaceAll("[^\\d.]", "");
        logicalOperator = stringMatcher.findLogicalOperator(ruleFragment);

        ruleFragmentVariables.add(nodeName);
        ruleFragmentVariables.add(comparisionVariable);
        ruleFragmentVariables.add(relationalOperator);
        ruleFragmentVariables.add(comparisionNumber);
        ruleFragmentVariables.add(logicalOperator);
        return ruleFragmentVariables;
    }
}
