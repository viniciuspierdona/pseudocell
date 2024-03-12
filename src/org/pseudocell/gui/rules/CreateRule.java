/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.rules;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.WindowConstants;
import org.pseudocell.config.Config;
import org.pseudocell.core.nodes.Metabolite;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.nodes.NodeModification;
import org.pseudocell.core.rules.Rule;
import org.pseudocell.core.rules.RuleFactory;
import org.pseudocell.gui.components.JComboBoxModCellRender;
import org.pseudocell.gui.components.JComboBoxNodeCellRender;
import org.pseudocell.gui.components.JLabelImportant;
import org.pseudocell.gui.components.JLabelInternal;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.gui.components.JListRuleCellRender;
import org.pseudocell.gui.components.JSpinnerDouble;
import org.pseudocell.gui.components.RuleTree;
import org.pseudocell.gui.validation.FieldValidation;
import org.pseudocell.gui.validation.RuleValidation;

/**
 *
 * @author ViníciusPierdoná
 */
public class CreateRule extends JFrame {

    private static int DEFAULT_SIZE = GroupLayout.DEFAULT_SIZE;
    private static int PREFERRED_SIZE = GroupLayout.PREFERRED_SIZE;
    private static final String BOX_TRUE = "true";
    private static final String BOX_FALSE = "false";
    private static final int RULETYPE_DEFAULT = 1;
    private static final int RULETYPE_METABOLIC = 2;
    private static final int RULETYPE_MODIFICATION = 3;

    // Components variables
    private JButton jButton_Add, jButton_Cancel, jButton_CreateBracket, jButton_CreateRule, jButton_Delete;
    private JComboBox<String> jComboBox_ComparisionVariable, jComboBox_LogicalOperator, jComboBox_RelationalOperation,
            jComboBox_ModificationValue;
    private JComboBox<Node> jComboBox_InputNode, jComboBox_OutputNode, jComboBox_RO_Node;
    private JComboBox<NodeModification> jComboBox_Modification;
    private JLabelInternal jLabel_InternalTitle1, jLabel_InternalTitle2, jLabel_InternalTitle3;
    private JLabel jLabel_ImportantText1, jLabel_ImportantText2, jLabel_ImportantText3, jLabel_ConversionValue,
            jLabel_InputNode, jLabel_Modification, jLabel_ModificationValue, jLabel_NodeName, jLabel_NodeType,
            jLabel_OutputNode, jLabel_RO_LogicalOperator, jLabel_RO_NodeName, jLabel_RO_RelationalOperator,
            jLabel_RO_Value, jLabel_RO_Variable, jLabel_RestingStatus, jLabel_RuleList, jLabel_RuleStatus,
            jLabel_Status;
    private JLabelSubTitle jLabel_Subtitle1, jLabel_Subtitle2, jLabel_Subtitle3;
    private JLabelTitle jLabel_Title;
    private JLabelImportant jLabel_ImportantTitle;
    private JList<String> jList_RuleList;
    private DefaultListModel model_RuleList;
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanel5, jPanel6, jPanel7, jPanel_CreateRule;
    private JScrollPane jScrollPane_RuleList, jScrollPane_RuleTree;
    private JSeparator jSeparator1, jSeparator2, jSeparator3, jSeparator4, jSeparator5, jSeparator6;
    private JSpinnerDouble jSpinner_ComparisionValue;
    private JTextField jTextField_NodeName, jTextField_NodeRestingStatus, jTextField_NodeStatus, jTextField_NodeType,
            jTextField_RuleStatus, jTextField_ConversionValue;
    private RuleTree jTree_Rule;

    private Node selectedNode;
    private List<Node> nodeList;
    private Config configurations;
    private int ruleType, bracketNumber;
    private RuleFactory ruleFactory;
    private FieldValidation fieldValidation;
    private RuleValidation ruleValidation;

    /**
     * Creates new form CreateRule
     *
     * @param configurations
     * @param selectedNode
     * @param nodeList
     */
    public CreateRule(Config configurations, Node selectedNode, List<Node> nodeList) {
        this.configurations = configurations;
        this.selectedNode = selectedNode;
        this.nodeList = nodeList;
        this.bracketNumber = 0;
        this.ruleFactory = new RuleFactory();
        this.fieldValidation = new FieldValidation();
        this.ruleValidation = new RuleValidation();

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
        ruleType = RULETYPE_DEFAULT;
        setRuleTypeFields();
        jTextField_NodeName.setText(selectedNode.getName());
        jTextField_NodeRestingStatus.setText(String.valueOf(selectedNode.getRestingStatus()));
        jTextField_NodeStatus.setText(String.valueOf(selectedNode.getStatus()));
        switch (selectedNode.getType()) {
            case 1:
                jTextField_NodeType.setText("Protein/Gene");
                break;
            case 2:
                jTextField_NodeType.setText("Metabolite");
                break;
            case 3:
                jTextField_NodeType.setText("Other");
                break;
            case 4:
                jTextField_NodeType.setText("miRNA");
                break;
            case 5:
                jTextField_NodeType.setText("Drug");
                break;
            default:
                throw new AssertionError();
        }
        model_RuleList.clear();
        List<Rule> ruleList = selectedNode.getRules();
        for (Rule rule : ruleList) {
            model_RuleList.addElement(rule);
        }
        jList_RuleList.setModel(model_RuleList);
        jComboBox_Modification.removeAllItems();
        for (NodeModification mod : selectedNode.getNodeModifications()) {
            jComboBox_Modification.addItem(mod);
        }
    }

    private void setComponents() {
        jPanel_CreateRule = new JPanel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jPanel7 = new JPanel();
        jLabel_Title = new JLabelTitle();
        jLabel_Subtitle1 = new JLabelSubTitle();
        jLabel_Subtitle2 = new JLabelSubTitle();
        jLabel_Subtitle3 = new JLabelSubTitle();
        jLabel_InternalTitle1 = new JLabelInternal();
        jLabel_InternalTitle2 = new JLabelInternal();
        jLabel_InternalTitle3 = new JLabelInternal();
        jLabel_ImportantTitle = new JLabelImportant();
        jLabel_NodeName = new JLabel();
        jLabel_Status = new JLabel();
        jLabel_RestingStatus = new JLabel();
        jLabel_NodeType = new JLabel();
        jLabel_RuleList = new JLabel();
        jLabel_RuleStatus = new JLabel();
        jLabel_InputNode = new JLabel();
        jLabel_OutputNode = new JLabel();
        jLabel_ConversionValue = new JLabel();
        jLabel_Modification = new JLabel();
        jLabel_ModificationValue = new JLabel();
        jLabel_RO_NodeName = new JLabel();
        jLabel_RO_Variable = new JLabel();
        jLabel_RO_RelationalOperator = new JLabel();
        jLabel_RO_Value = new JLabel();
        jLabel_RO_LogicalOperator = new JLabel();
        jLabel_ImportantText1 = new JLabel();
        jLabel_ImportantText2 = new JLabel();
        jLabel_ImportantText3 = new JLabel();
        jTextField_NodeName = new JTextField();
        jTextField_NodeStatus = new JTextField();
        jTextField_NodeRestingStatus = new JTextField();
        jTextField_NodeType = new JTextField();
        jTextField_RuleStatus = new JTextField();
        jScrollPane_RuleList = new JScrollPane();
        jList_RuleList = new JList<>();
        model_RuleList = new DefaultListModel();
        jComboBox_InputNode = new JComboBox<>();
        jComboBox_OutputNode = new JComboBox<>();
        jComboBox_Modification = new JComboBox<>();
        jComboBox_ModificationValue = new JComboBox<>();
        jComboBox_RO_Node = new JComboBox<>();
        jComboBox_ComparisionVariable = new JComboBox<>();
        jComboBox_RelationalOperation = new JComboBox<>();
        jComboBox_LogicalOperator = new JComboBox<>();
        jTextField_ConversionValue = new JTextField();
        jSpinner_ComparisionValue = new JSpinnerDouble();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jSeparator3 = new JSeparator();
        jSeparator4 = new JSeparator();
        jSeparator5 = new JSeparator();
        jSeparator6 = new JSeparator();
        jScrollPane_RuleTree = new JScrollPane();
        jTree_Rule = new RuleTree();
        jButton_Delete = new JButton();
        jButton_Add = new JButton();
        jButton_CreateBracket = new JButton();
        jButton_CreateRule = new JButton();
        jButton_Cancel = new JButton();

        jTextField_NodeName.setEnabled(false);
        jTextField_NodeRestingStatus.setEnabled(false);
        jTextField_NodeStatus.setEnabled(false);
        jTextField_NodeType.setEnabled(false);

        jTextField_RuleStatus.setName("Rule Status TextField");
        jTextField_ConversionValue.setName("Conversion Value TextField");

        jLabel_InternalTitle3.setText("Relational operation");
        jButton_Delete.setText("Delete");
        jButton_Add.setText("Add");
        jButton_CreateBracket.setText("Create Bracket");
        jLabel_Subtitle1.setText("Create a new node");
        jLabel_Title.setText("Edit Network Rules");
        jLabel_NodeName.setText("Node name");
        jLabel_Status.setText("Node initial status");
        jLabel_RestingStatus.setText("Node resting status");
        jLabel_NodeType.setText("Node type");
        jLabel_RuleList.setText("Rule list");
        jLabel_Subtitle2.setText("Rule creation");
        jLabel_RuleStatus.setText("Rule status");
        jLabel_InternalTitle1.setText("Metabolic rules variables");
        jLabel_InputNode.setText("Input node");
        jLabel_OutputNode.setText("Output node");
        jLabel_ConversionValue.setText("Conversion value");
        jLabel_InternalTitle2.setText("Modification rules variables");
        jLabel_Modification.setText("Modification");
        jLabel_ModificationValue.setText("Modification value");
        jLabel_Subtitle3.setText("Relational operation");
        jLabel_RO_NodeName.setText("Node");
        jLabel_RO_Variable.setText("Comparision variable");
        jLabel_RO_RelationalOperator.setText("Relational operator");
        jLabel_RO_Value.setText("Comparision value");
        jLabel_RO_LogicalOperator.setText("Logical operator");
        jLabel_ImportantTitle.setText("Important!");
        jLabel_ImportantText1.setText("All relational operations, with the exception of the");
        jLabel_ImportantText2.setText("last one, must be associated with a logical");
        jLabel_ImportantText3.setText("operator that links it to the next operation.");
        jButton_CreateRule.setText("Create rule");
        jButton_Cancel.setText("Cancel");

        for (Node node : nodeList) {
            jComboBox_RO_Node.addItem(node);
            if (node instanceof Metabolite) {
                jComboBox_InputNode.addItem(node);
                jComboBox_OutputNode.addItem(node);
            }
        }
        jComboBox_RO_Node.setRenderer(new JComboBoxNodeCellRender());
        jComboBox_InputNode.setRenderer(new JComboBoxNodeCellRender());
        jComboBox_OutputNode.setRenderer(new JComboBoxNodeCellRender());
        jComboBox_Modification.setRenderer(new JComboBoxModCellRender());

        jComboBox_RelationalOperation.setModel(new DefaultComboBoxModel<>(new String[]{">=", "<=", ">", "<", "=="}));
        jComboBox_LogicalOperator.setModel(new DefaultComboBoxModel<>(new String[]{"AND", "OR"}));
        jComboBox_ModificationValue.setModel(new DefaultComboBoxModel<>(new String[]{BOX_TRUE, BOX_FALSE}));
        jComboBox_ComparisionVariable.setModel(new DefaultComboBoxModel<>(new String[]{"Status"}));

        jScrollPane_RuleList.setViewportView(jList_RuleList);
        jList_RuleList.setCellRenderer(new JListRuleCellRender());
        jList_RuleList.setEnabled(false);

        jSpinner_ComparisionValue.setValue(Double.valueOf("1.0"));

        jScrollPane_RuleTree.setViewportView(jTree_Rule);
        
        jTextField_RuleStatus.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                JTextField_KeyTyped(evt);
            }
        });
        
        jTextField_ConversionValue.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                JTextField_KeyTyped(evt);
            }
        });

        jButton_Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_Delete_ActionPerformed();
            }
        });
        jButton_Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_Add_ActionPerformed();
            }
        });
        jButton_CreateBracket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_CreateBracket_ActionPerformed();
            }
        });
        jButton_CreateRule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_CreateRule_ActionPerformed();
            }
        });
        jButton_Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_Cancel_ActionPerformed();
            }
        });
        jTextField_RuleStatus.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTextField_RuleStatus_MouseClicked();
            }
        });

        jComboBox_InputNode.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jComboBox_InputNode_MouseClicked();
            }
        });

        jComboBox_OutputNode.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jComboBox_OutputNode_MouseClicked();
            }
        });

        jTextField_ConversionValue.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTextField_ConversionValue_MouseClicked();
            }
        });

        jComboBox_Modification.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jComboBox_Modification_MouseClicked();
            }
        });
        jComboBox_ModificationValue.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jComboBox_ModificationValue_MouseClicked();
            }
        });
        jComboBox_RO_Node.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jComboBox_RO_Node_ItemStateChanged();
            }
        });
    }

    private void setLayoutDesign() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 640));
        setResizable(false);

        jPanel_CreateRule.setMaximumSize(new Dimension(900, 640));
        jPanel_CreateRule.setMinimumSize(new Dimension(900, 640));

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
        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        GroupLayout jPanel_CreateRuleLayout = new GroupLayout(jPanel_CreateRule);
        jPanel_CreateRule.setLayout(jPanel_CreateRuleLayout);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        //
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel_Subtitle1, PREFERRED_SIZE, 150, PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jLabel_Title, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 24, Short.MAX_VALUE)
                                .addComponent(jLabel_Title)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel_Subtitle1))
        );

        //
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField_NodeRestingStatus)
                                        .addComponent(jTextField_NodeName)
                                        .addComponent(jLabel_RestingStatus, GroupLayout.Alignment.LEADING, DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                        .addComponent(jLabel_NodeName, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_Status, DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                        .addComponent(jLabel_NodeType, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField_NodeStatus)
                                        .addComponent(jTextField_NodeType))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_NodeName)
                                        .addComponent(jLabel_Status))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_NodeName, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(jTextField_NodeStatus, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_RestingStatus)
                                        .addComponent(jLabel_NodeType))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_NodeRestingStatus, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(jTextField_NodeType, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_RuleList, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane_RuleList, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, 497, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_RuleList)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane_RuleList, PREFERRED_SIZE, 66, PREFERRED_SIZE)
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel_Subtitle2, DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1, PREFERRED_SIZE, 158, PREFERRED_SIZE))
                                        .addComponent(jLabel_RuleStatus, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_InputNode, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_OutputNode, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_ConversionValue, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField_RuleStatus)
                                        .addComponent(jComboBox_InputNode, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox_OutputNode, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField_ConversionValue)
                                        .addComponent(jComboBox_Modification, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox_ModificationValue)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel_InternalTitle1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator3))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_Modification)
                                                        .addComponent(jLabel_ModificationValue))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel_InternalTitle2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator4)))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel_Subtitle2)
                                                        .addComponent(jSeparator1, PREFERRED_SIZE, 10, PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel_RuleStatus)
                                                .addGap(2, 2, 2)
                                                .addComponent(jTextField_RuleStatus, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel_InternalTitle1)
                                                        .addComponent(jSeparator3, PREFERRED_SIZE, 10, PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel_InputNode)
                                                .addGap(2, 2, 2)
                                                .addComponent(jComboBox_InputNode, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel_OutputNode)
                                                .addGap(2, 2, 2)
                                                .addComponent(jComboBox_OutputNode, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel_ConversionValue)
                                                .addGap(2, 2, 2)
                                                .addComponent(jTextField_ConversionValue, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel_InternalTitle2))
                                        .addComponent(jSeparator4, PREFERRED_SIZE, 10, PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_Modification)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox_Modification, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_ModificationValue)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox_ModificationValue, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addContainerGap(11, Short.MAX_VALUE))
        );

        //
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel_Subtitle3, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator2, PREFERRED_SIZE, 100, PREFERRED_SIZE))
                                        .addComponent(jLabel_RO_Variable, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_RO_NodeName, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox_RO_Node, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox_ComparisionVariable, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox_RelationalOperation, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel_RO_RelationalOperator)
                                                        .addComponent(jLabel_RO_Value)
                                                        .addComponent(jLabel_RO_LogicalOperator)
                                                        .addComponent(jLabel_ImportantTitle)
                                                        .addComponent(jLabel_ImportantText1, DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                                        .addComponent(jLabel_ImportantText2)
                                                        .addComponent(jLabel_ImportantText3)
                                                        .addComponent(jComboBox_LogicalOperator, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jSpinner_ComparisionValue))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel_Subtitle3)
                                        .addComponent(jSeparator2, PREFERRED_SIZE, 10, PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_RO_NodeName)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox_RO_Node, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_RO_Variable)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox_ComparisionVariable, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_RO_RelationalOperator)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox_RelationalOperation, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_RO_Value)
                                .addGap(2, 2, 2)
                                .addComponent(jSpinner_ComparisionValue, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_RO_LogicalOperator)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox_LogicalOperator, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel_ImportantTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_ImportantText1)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel_ImportantText2)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel_ImportantText3, PREFERRED_SIZE, 16, PREFERRED_SIZE)
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane_RuleTree)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel_InternalTitle3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSeparator5))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton_CreateBracket)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton_Add)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton_Delete)))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane_RuleTree, PREFERRED_SIZE, 288, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel_InternalTitle3)
                                        .addComponent(jSeparator5, PREFERRED_SIZE, 10, PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_Delete)
                                        .addComponent(jButton_Add)
                                        .addComponent(jButton_CreateBracket))
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator6)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton_CreateRule)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton_Cancel)))
                                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator6, PREFERRED_SIZE, 4, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton_CreateRule)
                                        .addComponent(jButton_Cancel))
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //
        jPanel_CreateRuleLayout.setHorizontalGroup(
                jPanel_CreateRuleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_CreateRuleLayout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel_CreateRuleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel_CreateRuleLayout.createSequentialGroup()
                                                .addComponent(jPanel2, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                        .addComponent(jPanel7, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel_CreateRuleLayout.createSequentialGroup()
                                                .addComponent(jPanel4, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel5, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel6, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))))
        );
        jPanel_CreateRuleLayout.setVerticalGroup(
                jPanel_CreateRuleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_CreateRuleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_CreateRuleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel2, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_CreateRuleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel5, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel6, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        //
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(36, Short.MAX_VALUE)
                                .addComponent(jPanel_CreateRule, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel_CreateRule, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButton_CreateBracket_ActionPerformed() {
        jTree_Rule.addObject("[Bracket " + bracketNumber++ + "]");
    }

    private void jButton_Add_ActionPerformed() {
        String nodeName = ((Node) jComboBox_RO_Node.getSelectedItem()).getName();
        String comparisionVariable = String.valueOf(jComboBox_ComparisionVariable.getSelectedItem());
        String relationalOperation = String.valueOf(jComboBox_RelationalOperation.getSelectedItem());
        
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
        jTree_Rule.addObject(ruleString);
    }

    private void jButton_Delete_ActionPerformed() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will delete the selected operation or, if it is a bracket, all operations inside of it. Are you sure you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            jTree_Rule.removeCurrentNode();
        }
    }

    private void jButton_CreateRule_ActionPerformed() {
        String ruleString = jTree_Rule.printTree();
        // Checks whether the jTree has valid relational operations.
        if (ruleValidation.isTreeEmpty(jTree_Rule, this)) {
            return;
        }
        Rule rule = null;
        ArrayList<JTextField> validationTextFields = new ArrayList<>();
        switch (ruleType) {
            case RULETYPE_DEFAULT:
                // Checks that the fields for this rule are populated
                validationTextFields.add(jTextField_RuleStatus);
                if (!fieldValidation.validateMandatoryTextField(validationTextFields, this)) {
                    return;
                }

                Double nodeStatus = Double.valueOf(jTextField_RuleStatus.getText());
                rule = ruleFactory.createRule(ruleString, nodeStatus);
                if (!ruleValidation.checkRuleStatus(rule, selectedNode, this)) {
                    return;
                }
                break;
            case RULETYPE_METABOLIC:
                // Checks that the fields for this rule are populated
                validationTextFields.add(jTextField_ConversionValue);
                if (!fieldValidation.validateMandatoryTextField(validationTextFields, this)) {
                    return;
                }
                if (!fieldValidation.validateInputOutputNode((Node) jComboBox_InputNode.getSelectedItem(), (Node) jComboBox_OutputNode.getSelectedItem(), this)) {
                    return;
                }

                String inputNode = String.valueOf(((Node) jComboBox_InputNode.getSelectedItem()).getName());
                String outputNode = String.valueOf(((Node) jComboBox_OutputNode.getSelectedItem()).getName());
                Double conversionValue = Double.valueOf(jTextField_ConversionValue.getText());
                rule = ruleFactory.createMetabolicRule(ruleString, inputNode, outputNode, conversionValue);
                break;
            case RULETYPE_MODIFICATION:
                // Checks that the fields for this rule are populated
                if (!fieldValidation.validateModificationComboBox(jComboBox_Modification, this)) {
                    return;
                }

                String modification = String.valueOf(jComboBox_Modification.getSelectedItem());
                Double modStatus;
                if (jComboBox_ModificationValue.getSelectedItem().equals("true")) {
                    modStatus = 1.0;
                } else if (jComboBox_ModificationValue.getSelectedItem().equals("false")) {
                    modStatus = 0.0;
                } else {
                    JOptionPane.showMessageDialog(this, "[ERROR] Error capturing the state of the modification associated with the rule.", "Error in rule creation.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                rule = ruleFactory.createModificationRule(ruleString, modification, modStatus);
                break;
            default:
                throw new AssertionError();
        }
        selectedNode.getRules().add(rule);
        configurations.networkSourceInputType = Config.NETWORK_SOURCE_TYPE_XML;
        // Update rules list and clear rule fields
        clearFields();
    }

    private void jButton_Cancel_ActionPerformed() {
        dispose();
    }

    private void jTextField_RuleStatus_MouseClicked() {
        ruleType = RULETYPE_DEFAULT;
        this.setRuleTypeFields();
    }

    private void jComboBox_InputNode_MouseClicked() {
        ruleType = RULETYPE_METABOLIC;
        this.setRuleTypeFields();
    }

    private void jComboBox_OutputNode_MouseClicked() {
        ruleType = RULETYPE_METABOLIC;
        this.setRuleTypeFields();
    }

    private void jTextField_ConversionValue_MouseClicked() {
        ruleType = RULETYPE_METABOLIC;
        this.setRuleTypeFields();
    }

    private void jComboBox_Modification_MouseClicked() {
        ruleType = RULETYPE_MODIFICATION;
        this.setRuleTypeFields();
    }

    private void jComboBox_ModificationValue_MouseClicked() {
        ruleType = RULETYPE_MODIFICATION;
        this.setRuleTypeFields();
    }

    private void jComboBox_RO_Node_ItemStateChanged() {
        jComboBox_ComparisionVariable.removeAllItems();
        jComboBox_ComparisionVariable.addItem("Status");
        Node nodeRO = (Node) jComboBox_RO_Node.getSelectedItem();
        if (!nodeRO.getNodeModifications().isEmpty()) {
            for (NodeModification mod : nodeRO.getNodeModifications()) {
                jComboBox_ComparisionVariable.addItem(mod.getName());
            }
        }
    }

    private void setRuleTypeFields() {
        switch (ruleType) {
            case RULETYPE_DEFAULT:
                jTextField_RuleStatus.setEnabled(true);
                jComboBox_InputNode.setEnabled(false);
                jComboBox_OutputNode.setEnabled(false);
                jTextField_ConversionValue.setEnabled(false);
                jComboBox_Modification.setEnabled(false);
                jComboBox_ModificationValue.setEnabled(false);
                break;
            case RULETYPE_METABOLIC:
                jTextField_RuleStatus.setEnabled(false);
                jComboBox_InputNode.setEnabled(true);
                jComboBox_OutputNode.setEnabled(true);
                jTextField_ConversionValue.setEnabled(true);
                jComboBox_Modification.setEnabled(false);
                jComboBox_ModificationValue.setEnabled(false);
                break;
            case RULETYPE_MODIFICATION:
                jTextField_RuleStatus.setEnabled(false);
                jComboBox_InputNode.setEnabled(false);
                jComboBox_OutputNode.setEnabled(false);
                jTextField_ConversionValue.setEnabled(false);
                jComboBox_Modification.setEnabled(true);
                jComboBox_ModificationValue.setEnabled(true);
                break;
            default:
                throw new AssertionError();
        }
    }

    public void clearFields() {
        jTextField_NodeStatus.setText("1.0");
        jComboBox_InputNode.setSelectedIndex(0);
        jComboBox_OutputNode.setSelectedIndex(0);
        jTextField_ConversionValue.setText("");
        if (jComboBox_Modification.getItemCount() > 0) {
            jComboBox_Modification.setSelectedIndex(0);
        }
        jComboBox_ModificationValue.setSelectedIndex(0);
        jComboBox_RO_Node.setSelectedIndex(0);
        jComboBox_ComparisionVariable.setSelectedIndex(0);
        jComboBox_RelationalOperation.setSelectedIndex(0);
        jSpinner_ComparisionValue.setValue(1.0);
        jComboBox_LogicalOperator.setSelectedIndex(0);
        jTree_Rule.clear();
        ruleType = RULETYPE_DEFAULT;
        setRuleTypeFields();
        // Update rule list
        model_RuleList.clear();
        List<Rule> ruleList = selectedNode.getRules();
        for (Rule rule : ruleList) {
            model_RuleList.addElement(rule);
        }
        jList_RuleList.setModel(model_RuleList);
    }
    
    private void JTextField_KeyTyped(KeyEvent evt) {
        if (!fieldValidation.getDoubleCharAllowed().contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

}
