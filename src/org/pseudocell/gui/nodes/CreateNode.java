/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.nodes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.nodes.NodeFactory;
import org.pseudocell.core.nodes.NodeModification;
import org.pseudocell.gui.components.JComboBoxModCellRender;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.config.Config;
import org.pseudocell.gui.validation.FieldValidation;

/**
 *
 * @author ViníciusPierdoná
 */
public class CreateNode extends JFrame {

    private static final int DEFAULT_SIZE = GroupLayout.DEFAULT_SIZE;
    private static final int PREFERRED_SIZE = GroupLayout.PREFERRED_SIZE;
    private static final String BOX_TRUE = "true";
    private static final String BOX_FALSE = "false";

    // Components variables
    private JButton jButton_Cancel, jButton_CreateMod, jButton_CreateNode, jButton_DeleteMod;
    private JComboBox<String> jComboBox_ModRestingStatus, jComboBox_ModStatus, jComboBox_Type;
    private JComboBox<NodeModification> jComboBox_ModList;
    private JLabel jLabel_Income, jLabel_MaxValue, jLabel_MinValue, jLabel_ModList, jLabel_ModName, jLabel_ModRestingStatus,
            jLabel_ModStatus, jLabel_Name, jLabel_RestingStatus, jLabel_Status, jLabel_Type;
    private JLabelSubTitle jLabel_Subtitle1, jLabel_Subtitle2, jLabel_Subtitle3;
    private JLabelTitle jLabel_Title;
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanel5, jPanel_CreateNode;
    private JSeparator jSeparator1, jSeparator2, jSeparator3, jSeparator4;
    private JTextField jTextField_Income, jTextField_MaxValue, jTextField_MinValue, jTextField_ModName, jTextField_Name,
            jTextField_RestingStatus, jTextField_Status;

    private Config configurations;
    private Node node;
    private List<Node> nodeList;
    private List<NodeModification> modificationList;
    private NodeFactory nodeFactory;
    private FieldValidation fieldValidation;

    /**
     * Creates new form CreateNode
     *
     * @param configurations
     * @param nodeList
     */
    public CreateNode(Config configurations, List<Node> nodeList) {
        this.configurations = configurations;
        this.nodeList = nodeList;
        this.modificationList = new ArrayList<>();
        this.nodeFactory = new NodeFactory();
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
        jTextField_Income.setEnabled(false);
        jTextField_MaxValue.setEnabled(false);
        jTextField_MinValue.setEnabled(false);
    }

    private void setComponents() {
        jPanel_CreateNode = new JPanel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        jLabel_Title = new JLabelTitle();
        jLabel_Subtitle1 = new JLabelSubTitle();
        jLabel_Subtitle2 = new JLabelSubTitle();
        jLabel_Subtitle3 = new JLabelSubTitle();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jSeparator3 = new JSeparator();
        jSeparator4 = new JSeparator();
        jLabel_Name = new JLabel();
        jLabel_Status = new JLabel();
        jLabel_RestingStatus = new JLabel();
        jLabel_Type = new JLabel();
        jLabel_Income = new JLabel();
        jLabel_MaxValue = new JLabel();
        jLabel_MinValue = new JLabel();
        jLabel_ModName = new JLabel();
        jLabel_ModStatus = new JLabel();
        jLabel_ModRestingStatus = new JLabel();
        jLabel_ModList = new JLabel();
        jTextField_Name = new JTextField();
        jTextField_RestingStatus = new JTextField();
        jTextField_Status = new JTextField();
        jTextField_Income = new JTextField();
        jTextField_MinValue = new JTextField();
        jTextField_MaxValue = new JTextField();
        jTextField_ModName = new JTextField();
        jComboBox_ModList = new JComboBox<>();
        jComboBox_Type = new JComboBox<>();
        jComboBox_ModStatus = new JComboBox<>();
        jComboBox_ModRestingStatus = new JComboBox<>();
        jButton_Cancel = new JButton();
        jButton_CreateNode = new JButton();
        jButton_DeleteMod = new JButton();
        jButton_CreateMod = new JButton();
        
        jTextField_Name.setName("Node Name TextField");
        jTextField_Status.setName("Node Status TextField");
        jTextField_RestingStatus.setName("Node Resting Status TextField");
        jTextField_Income.setName("Metabolic Income TextField");
        jTextField_MinValue.setName("Metabolic Min. Value TextField");
        jTextField_MaxValue.setName("Metabolic Max. Value TextField");

        jLabel_Title.setText("Edit Network");
        jLabel_Subtitle1.setText("Create a new node");
        jLabel_Name.setText("Node Name");
        jLabel_Status.setText("Initial Status");
        jLabel_RestingStatus.setText("Resting Status");
        jLabel_Type.setText("Node Type");
        jTextField_Name.setText("newNode");
        jTextField_RestingStatus.setText("0.0");
        jTextField_Status.setText("0.0");
        jLabel_Subtitle2.setText("Metabolite variables");
        jLabel_Income.setText("Income");
        jLabel_MaxValue.setText("Maximum value");
        jLabel_MinValue.setText("Minimum value");
        jLabel_Subtitle3.setText("Modification variables");
        jLabel_ModName.setText("Modification Name");
        jLabel_ModStatus.setText("Modification initial status");
        jLabel_ModRestingStatus.setText("Modification resting status");
        jLabel_ModList.setText("Modification List");
        jTextField_ModName.setText("newMod");
        jButton_DeleteMod.setText("Remove");
        jButton_Cancel.setText("Cancel");
        jButton_CreateNode.setText("Create node");
        jButton_CreateMod.setText("Add");
        jComboBox_Type.setModel(new DefaultComboBoxModel<>(new String[]{"Protein/Gene", "Metabolite", "miRNA", "Drug", "Other"}));
        jComboBox_ModStatus.setModel(new DefaultComboBoxModel<>(new String[]{BOX_TRUE, BOX_FALSE}));
        jComboBox_ModRestingStatus.setModel(new DefaultComboBoxModel<>(new String[]{BOX_TRUE, BOX_FALSE}));
        jComboBox_ModList.setRenderer(new JComboBoxModCellRender());

        jButton_Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_Cancel_ActionPerformed();
            }
        });
        jButton_CreateNode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_CreateNode_ActionPerformed();
            }
        });
        jButton_DeleteMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_DeleteMod_ActionPerformed();
            }
        });
        jButton_CreateMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton_CreateMod_ActionPerformed();
            }
        });
        jComboBox_Type.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jComboBox_Type_ItemStateChanged();
            }
        });
    }

    private void setLayoutDesign() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(680, 480));
        setResizable(false);

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
        GroupLayout jPanel_CreateNodeLayout = new GroupLayout(jPanel_CreateNode);
        jPanel_CreateNode.setLayout(jPanel_CreateNodeLayout);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        // Organizing jPanel1
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel_Subtitle1, PREFERRED_SIZE, 150, PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(jSeparator1, PREFERRED_SIZE, 442, PREFERRED_SIZE))
                                        .addComponent(jLabel_Title, DEFAULT_SIZE, 598, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addComponent(jLabel_Title)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel_Subtitle1)
                                        .addComponent(jSeparator1, PREFERRED_SIZE, 10, PREFERRED_SIZE))
                                .addContainerGap())
        );

        // Organizing jPanel2
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField_Name, GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_RestingStatus, GroupLayout.Alignment.LEADING, DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                        .addComponent(jLabel_Name, GroupLayout.Alignment.LEADING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField_RestingStatus, GroupLayout.Alignment.LEADING))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel_Status, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_Type, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField_Status)
                                        .addComponent(jComboBox_Type, 0, 156, Short.MAX_VALUE))
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_Name)
                                        .addComponent(jLabel_Status))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_Name)
                                        .addComponent(jTextField_Status))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_RestingStatus)
                                        .addComponent(jLabel_Type))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_RestingStatus)
                                        .addComponent(jComboBox_Type))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        // Organizing jPanel3
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField_Income)
                                        .addComponent(jLabel_Income, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_Subtitle2, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField_MaxValue)
                                        .addComponent(jLabel_MaxValue, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel_MinValue, PREFERRED_SIZE, 154, PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jSeparator2)
                                        .addComponent(jTextField_MinValue))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel_Subtitle2)
                                        .addComponent(jSeparator2, PREFERRED_SIZE, 10, PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_Income)
                                        .addComponent(jLabel_MinValue, PREFERRED_SIZE, 16, PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_Income)
                                        .addComponent(jTextField_MinValue))
                                .addGap(9, 9, 9)
                                .addComponent(jLabel_MaxValue)
                                .addGap(2, 2, 2)
                                .addComponent(jTextField_MaxValue)
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Organizing jPanel4
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator4)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton_CreateNode)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton_Cancel)))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator4, PREFERRED_SIZE, 4, PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_Cancel)
                                        .addComponent(jButton_CreateNode))
                                .addContainerGap(53, Short.MAX_VALUE))
        );

        // Organizing jPanel5
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_ModList, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_ModName, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_ModRestingStatus, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel_ModStatus, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField_ModName)
                                        .addComponent(jComboBox_ModList, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox_ModStatus, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox_ModRestingStatus, 0, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton_CreateMod)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton_DeleteMod))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel_Subtitle3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator3)))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel_Subtitle3)
                                        .addComponent(jSeparator3, PREFERRED_SIZE, 10, PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_ModName)
                                .addGap(2, 2, 2)
                                .addComponent(jTextField_ModName, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_ModStatus)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox_ModStatus, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_ModRestingStatus)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox_ModRestingStatus, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel_ModList)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox_ModList, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_DeleteMod)
                                        .addComponent(jButton_CreateMod))
                                .addContainerGap())
        );

        // Organizing jPanel_CreateNodeLayout
        jPanel_CreateNodeLayout.setHorizontalGroup(
                jPanel_CreateNodeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_CreateNodeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_CreateNodeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel_CreateNodeLayout.createSequentialGroup()
                                                .addGroup(jPanel_CreateNodeLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jPanel3, GroupLayout.Alignment.LEADING, PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(jPanel2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel5, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel_CreateNodeLayout.setVerticalGroup(
                jPanel_CreateNodeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_CreateNodeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_CreateNodeLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel_CreateNodeLayout.createSequentialGroup()
                                                .addComponent(jPanel2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel5, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        // Organizing this frame
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 24, Short.MAX_VALUE)
                                .addComponent(jPanel_CreateNode))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel_CreateNode)
        );

        pack();
    }

    private void jComboBox_Type_ItemStateChanged() {
        boolean metabolite = jComboBox_Type.getSelectedItem().equals("Metabolite");
        jTextField_Income.setEnabled(metabolite);
        jTextField_MinValue.setEnabled(metabolite);
        jTextField_MaxValue.setEnabled(metabolite);
    }

    private void jButton_CreateMod_ActionPerformed() {
        /* Validations and alerts: 
         * Checks if Modification Name field is filled in and  
         * if ir does not exceed the maximum number of characters allowed.
         */
        if (!fieldValidation.validateMandatoryTextField(jTextField_ModName, this)
                || !fieldValidation.validateMaxCharacters(jTextField_ModName, this)) {
            return;
        }
        Double modStatus, modResting;
        String modName = jTextField_ModName.getText();
        if (jComboBox_ModStatus.getSelectedItem().equals(BOX_TRUE)) {
            modStatus = 1.0;
        } else {
            modStatus = 0.0;
        }
        if (jComboBox_ModRestingStatus.getSelectedItem().equals(BOX_TRUE)) {
            modResting = 1.0;
        } else {
            modResting = 0.0;
        }
        NodeModification modification = new NodeModification(modName, modStatus, modResting);
        modificationList.add(modification);
        jComboBox_ModList.addItem(modification);
        jTextField_ModName.setText("newMod");
        jComboBox_ModStatus.setSelectedItem(BOX_TRUE);
        jComboBox_ModRestingStatus.setSelectedItem(BOX_TRUE);
    }

    private void jButton_DeleteMod_ActionPerformed() {
        // Checks if the node has any modifications to be edited.
        if (jComboBox_ModList.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "[ERROR] This node has no modifications available for deletion.", "Error - Empty Modification", JOptionPane.ERROR_MESSAGE);
            return;
        }
        modificationList.remove(jComboBox_ModList.getSelectedItem());
        jComboBox_ModList.removeItem(jComboBox_ModList.getSelectedItem());
        JOptionPane.showMessageDialog(this, "Modification deleted successfully.", "Sucessfully deletion", JOptionPane.INFORMATION_MESSAGE);
    }

    private void jButton_CreateNode_ActionPerformed() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will add this node to the network. Would you like to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            /* Validations and alerts: 
             * Checks if Node Name, Node Initial Status, Node Resting Status and all Metabolic fields are filled in and 
             * if the float fields have only positive and higher numbers that zero.
             */
            ArrayList<JTextField> validationMandatoryTextFields = new ArrayList<>();
            ArrayList<JTextField> validationDoubleTextFields = new ArrayList<>();
            validationMandatoryTextFields.add(jTextField_Name);
            validationDoubleTextFields.add(jTextField_Status);
            validationDoubleTextFields.add(jTextField_RestingStatus);
            if (jComboBox_Type.getSelectedItem().equals("Metabolite")) {
                validationDoubleTextFields.add(jTextField_Income);
                validationDoubleTextFields.add(jTextField_MinValue);
                validationDoubleTextFields.add(jTextField_MaxValue);
            }
            validationMandatoryTextFields.addAll(validationDoubleTextFields);
            if (!fieldValidation.validateMandatoryTextField(validationMandatoryTextFields, null)
                    || !fieldValidation.validatePositiveDoubleTextField(validationDoubleTextFields, null)) {
                return;
            }

            Node node = null;
            String nodeName = jTextField_Name.getText();
            Double nodeStatus = Double.valueOf(jTextField_Status.getText());
            String nodeType = String.valueOf(jComboBox_Type.getSelectedItem());
            Double restingStatus;
            switch (nodeType) {
                case "Protein/Gene":
                    restingStatus = Double.valueOf(jTextField_RestingStatus.getText());
                    node = nodeFactory.createNode(nodeName, nodeStatus, restingStatus);
                    break;
                case "Metabolite":
                    Double income = Double.valueOf(jTextField_Income.getText());
                    Double minValue = Double.valueOf(jTextField_MinValue.getText());
                    Double maxValue = Double.valueOf(jTextField_MaxValue.getText());
                    node = nodeFactory.createMetabolite(nodeName, nodeStatus, income, minValue, maxValue);
                    break;
                case "miRNA":
                    restingStatus = Double.valueOf(jTextField_RestingStatus.getText());
                    node = nodeFactory.createMiRNA(nodeName, nodeStatus, restingStatus);
                    break;
                case "Drug":
                    restingStatus = Double.valueOf(jTextField_RestingStatus.getText());
                    node = nodeFactory.createDrug(nodeName, nodeStatus, restingStatus);
                    break;
                case "Other":
                    restingStatus = Double.valueOf(jTextField_RestingStatus.getText());
                    node = nodeFactory.createGeneralNode(nodeName, nodeStatus, restingStatus);
                    break;
                default:
                    throw new AssertionError();
            }
            if (jComboBox_ModList.getItemCount() > 0) {
                node.setNodeModifications(modificationList);
            }
            nodeList.add(node);
            jTextField_Name.setText("newNode");
            jTextField_Status.setText("0.0");
            jTextField_RestingStatus.setText("0.0");
            jTextField_Income.setText("");
            jTextField_MinValue.setText("");
            jTextField_ModName.setText("newModification");
            jComboBox_ModStatus.setSelectedItem(BOX_TRUE);
            jComboBox_ModRestingStatus.setSelectedItem(BOX_TRUE);
            jComboBox_ModList.removeAllItems();
        }
    }

    private void jButton_Cancel_ActionPerformed() {
        dispose();
    }

}
