/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.nodes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
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
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.nodes.NodeModification;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.gui.components.JListModificationCellRender;
import org.pseudocell.config.Config;

/**
 *
 * @author ViníciusPierdoná
 */
public class CreateModification extends JFrame{
    
    // Components variables
    private JButton jButtonCancel, jButtonCreate;    
    private JLabelTitle jLabelTitle;
    private JLabelSubTitle jLabelSubtitle;
    private JLabel jLabelModList, jLabelModName, jLabelModRestingStatus, jLabelModStatus, jLabelNodeName,
            jLabelNodeType;   
    private JPanel jPanelModificationAddScreen;
    private JSeparator jSeparator4, jSeparator5;
    private JTextField jTextFieldModName, jTextFieldModStatus, jTextFieldNodeName, jTextFieldNodeType, jTextFieldRestingStatus;
    private JList<NodeModification> JList_Modification;
    private DefaultListModel model_ModificationList;
    private JScrollPane jScrollPane1;
    
    private static final int TYPE_PROTEINGENE = 1;
    private static final int TYPE_METABOLITE = 2;
    private static final int TYPE_OTHER = 3;
    private static final int TYPE_MIRNA = 4;
    private static final int TYPE_DRUG = 5;

    Config configurations;
    Node node;

    /**
     * Creates new form ModificationAdd
     *
     * @param configurations
     * @param node
     */
    public CreateModification(Config configurations, Node node) {

        this.configurations = configurations;
        this.node = node;
        
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
        jTextFieldNodeName.setText(node.getName());
        switch (node.getType()) {
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
        model_ModificationList.clear();
        if (!node.getNodeModifications().isEmpty()) {
            for (int i = 0; i < node.getNodeModifications().size(); i++) {              
                model_ModificationList.addElement(node.getNodeModifications().get(i));
            }
            JList_Modification.setModel(model_ModificationList);
        }
    }

    public void setComponents() {
        jLabelTitle = new JLabelTitle();
        jLabelSubtitle = new JLabelSubTitle();
        jLabelNodeName = new JLabel();
        jLabelNodeType = new JLabel();
        jLabelModName = new JLabel();
        jLabelModStatus = new JLabel();
        jLabelModList = new JLabel();
        jLabelModRestingStatus = new JLabel();
        jPanelModificationAddScreen = new JPanel();
        jSeparator4 = new JSeparator();
        jSeparator5 = new JSeparator();
        jTextFieldNodeName = new JTextField();        
        jTextFieldNodeType = new JTextField();
        jTextFieldModName = new JTextField();        
        jTextFieldModStatus = new JTextField();
        jTextFieldRestingStatus = new JTextField();
        jButtonCancel = new JButton();
        jButtonCreate = new JButton();
        JList_Modification = new JList<>();
        model_ModificationList = new DefaultListModel();
        jScrollPane1 = new JScrollPane();
        
        jScrollPane1.setViewportView(JList_Modification);
        JList_Modification.setCellRenderer(new JListModificationCellRender());
        
        jLabelSubtitle.setText("Create a new modification");
        jLabelNodeName.setText("Node name");
        jLabelNodeType.setText("Node type");
        jButtonCancel.setText("Cancel");
        jButtonCreate.setText("Create");
        jLabelTitle.setText("Edit Network");
        jLabelModName.setText("Modification name");
        jTextFieldModName.setText("newModification");
        jLabelModStatus.setText("Modification initial status");
        jTextFieldModStatus.setText("0.0");
        jLabelModList.setText("Modifications list");
        jLabelModRestingStatus.setText("Modification resting status");
        jTextFieldRestingStatus.setText("0.0");

        jButtonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jButtonCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });
        
        jTextFieldNodeName.setEditable(false);
        jTextFieldNodeType.setEditable(false);
    }
             
    private void setLayoutDesign() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelModificationAddScreen.setMaximumSize(new java.awt.Dimension(680, 480));
        jPanelModificationAddScreen.setPreferredSize(new java.awt.Dimension(680, 480));

        GroupLayout jPanelModificationAddScreenLayout = new GroupLayout(jPanelModificationAddScreen);
        jPanelModificationAddScreen.setLayout(jPanelModificationAddScreenLayout);
        jPanelModificationAddScreenLayout.setHorizontalGroup(
            jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificationAddScreenLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificationAddScreenLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelModificationAddScreenLayout.createSequentialGroup()
                                    .addComponent(jLabelSubtitle)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelTitle))
                            .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelNodeType)
                                .addComponent(jTextFieldNodeType, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelModList)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelModificationAddScreenLayout.createSequentialGroup()
                            .addComponent(jButtonCreate)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonCancel))
                        .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNodeName)
                            .addComponent(jTextFieldNodeName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelModName)
                            .addComponent(jTextFieldModName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelModStatus)
                            .addComponent(jTextFieldModStatus, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelModRestingStatus)
                            .addComponent(jTextFieldRestingStatus, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanelModificationAddScreenLayout.setVerticalGroup(
            jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificationAddScreenLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelTitle)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSubtitle)
                    .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificationAddScreenLayout.createSequentialGroup()
                        .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNodeName)
                            .addComponent(jLabelNodeType))
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldNodeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelModificationAddScreenLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldNodeType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelModificationAddScreenLayout.createSequentialGroup()
                        .addComponent(jLabelModName)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldModName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelModStatus)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldModStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelModRestingStatus)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldRestingStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModificationAddScreenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCreate)
                            .addComponent(jButtonCancel)))
                    .addGroup(jPanelModificationAddScreenLayout.createSequentialGroup()
                        .addComponent(jLabelModList)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(298, 298, 298))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelModificationAddScreen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelModificationAddScreen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
    }                      

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will create a modification within the selected node. Would you like to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (jTextFieldModName.getText().isBlank() | jTextFieldModStatus.getText().isBlank() | jTextFieldRestingStatus.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "[ERROR] All fields must be filled.", "Error - Empty Field", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String modificationName = jTextFieldModName.getText();
            Double modificationStatus = Double.valueOf(jTextFieldModStatus.getText());
            Double modificationResting = Double.valueOf(jTextFieldRestingStatus.getText());
            NodeModification modification = new NodeModification(modificationName, modificationStatus, modificationResting);
            node.getNodeModifications().add(modification);
            JOptionPane.showMessageDialog(rootPane, "Modification created successfully.", "Modification created", JOptionPane.INFORMATION_MESSAGE);            
            JList_Modification.removeAll();
            shown();
            
        }
    }                                             

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {                                              
        dispose();
    }
}
