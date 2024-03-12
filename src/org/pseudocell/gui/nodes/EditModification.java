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
import org.pseudocell.core.utils.FindEdge;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.gui.components.JListModificationCellRender;
import org.pseudocell.config.Config;

/**
 *
 * @author ViníciusPierdoná
 */
public class EditModification extends JFrame{
    
    private static final int TYPE_PROTEINGENE = 1;
    private static final int TYPE_METABOLITE = 2;
    private static final int TYPE_OTHER = 3;
    private static final int TYPE_MIRNA = 4;
    private static final int TYPE_DRUG = 5;
    
    // Components variables
    private JButton jButtonCancel, jButtonDelete, jButtonSave;
    private JLabelTitle jLabelTitle;
    private JLabelSubTitle jLabelSubtitle;
    private JLabel jLabelModList, jLabelModName, jLabelModRestingStatus, jLabelModStatus, jLabelNodeName, jLabelNodeType;
    private JPanel jPanelModificationEditScreen;
    private JSeparator jSeparator4, jSeparator5;
    private JTextField jTextFieldModName, jTextFieldModStatus, jTextFieldNodeName, jTextFieldNodeType, jTextFieldRestingStatus;
    private JList<NodeModification> JList_Modification;
    private DefaultListModel model_ModificationList;
    private JScrollPane jScrollPane1;         

    Config configurations;
    List<Node> nodeList;
    Node node;
    int modificationIndex;
    NodeModification modification;
    FindEdge findEdge;
    
    /**
     * Creates new form ModificationEdit
     *
     * @param configurations
     * @param nodeList
     * @param node
     * @param modificationIndex
     */
    public EditModification(Config configurations, List<Node> nodeList, Node node, int modificationIndex) {
        this.configurations = configurations;
        this.nodeList = nodeList;
        this.node = node;
        this.modificationIndex = modificationIndex;
        this.findEdge = new FindEdge();
        
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
        jTextFieldNodeName.setEditable(false);
        jTextFieldNodeType.setEditable(false);
        model_ModificationList.clear();
        if (!node.getNodeModifications().isEmpty()) {
            for (int i = 0; i < node.getNodeModifications().size(); i++) {
                model_ModificationList.addElement(node.getNodeModifications().get(i));
            }
            JList_Modification.setModel(model_ModificationList);
        }
        setModificationFields(node.getNodeModifications().get(modificationIndex));
    }

    public void setComponents() {
        jPanelModificationEditScreen = new JPanel();
        jSeparator4 = new JSeparator();
        jSeparator5 = new JSeparator();
        jLabelTitle = new JLabelTitle();
        jLabelSubtitle = new JLabelSubTitle();
        jLabelNodeName = new JLabel();
        jLabelNodeType = new JLabel();
        jLabelModName = new JLabel();
        jLabelModStatus = new JLabel();
         jLabelModList = new JLabel();
        jLabelModRestingStatus = new JLabel();
        jTextFieldNodeName = new JTextField();
        jTextFieldModName = new JTextField();
        jTextFieldNodeType = new JTextField();
        jButtonCancel = new JButton();
        jButtonSave = new JButton();
        jButtonDelete = new JButton();
        jTextFieldModStatus = new JTextField();
        jTextFieldRestingStatus = new JTextField();
        JList_Modification = new JList<>();
        model_ModificationList = new DefaultListModel();
        jScrollPane1 = new JScrollPane();
        
        jLabelSubtitle.setText("Edit a modification");
        jLabelNodeName.setText("Node name");
        jLabelNodeType.setText("Node type");
        jButtonCancel.setText("Cancel");
        jButtonSave.setText("Save");
        jLabelTitle.setText("Edit Network");
        jLabelModName.setText("Modification name");
        jTextFieldModName.setText("newModification");
        jLabelModStatus.setText("Modification initial status");
        jTextFieldModStatus.setText("0.0");
        jLabelModList.setText("Modifications list");
        jLabelModRestingStatus.setText("Modification resting status");
        jTextFieldRestingStatus.setText("0.0");
        jButtonDelete.setText("Delete");
        
        jScrollPane1.setViewportView(JList_Modification);
        JList_Modification.setCellRenderer(new JListModificationCellRender());
        
        jButtonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jButtonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        JList_Modification.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                listModMouseClicked(evt);
            }
        });
        jButtonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });        
    }
                    
    private void setLayoutDesign() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        jPanelModificationEditScreen.setMaximumSize(new java.awt.Dimension(680, 480));
        jPanelModificationEditScreen.setPreferredSize(new java.awt.Dimension(680, 480));        

        GroupLayout jPanelModificationEditScreenLayout = new GroupLayout(jPanelModificationEditScreen);
        jPanelModificationEditScreen.setLayout(jPanelModificationEditScreenLayout);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        jPanelModificationEditScreenLayout.setHorizontalGroup(
            jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificationEditScreenLayout.createSequentialGroup()
                .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelModificationEditScreenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 522, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING, jPanelModificationEditScreenLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelModificationEditScreenLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelModificationEditScreenLayout.createSequentialGroup()
                                            .addComponent(jLabelSubtitle)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabelTitle))
                                    .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelNodeType)
                                        .addComponent(jTextFieldNodeType, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelModList)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelModificationEditScreenLayout.createSequentialGroup()
                                    .addComponent(jButtonSave)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonDelete)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonCancel))
                                .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNodeName)
                                    .addComponent(jTextFieldNodeName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelModName)
                                    .addComponent(jTextFieldModName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelModStatus)
                                    .addComponent(jTextFieldModStatus, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelModRestingStatus)
                                    .addComponent(jTextFieldRestingStatus, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanelModificationEditScreenLayout.setVerticalGroup(
            jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificationEditScreenLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelTitle)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSubtitle)
                    .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificationEditScreenLayout.createSequentialGroup()
                        .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNodeName)
                            .addComponent(jLabelNodeType))
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldNodeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelModificationEditScreenLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldNodeType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelModificationEditScreenLayout.createSequentialGroup()
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
                        .addGroup(jPanelModificationEditScreenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSave)
                            .addComponent(jButtonCancel)
                            .addComponent(jButtonDelete)))
                    .addGroup(jPanelModificationEditScreenLayout.createSequentialGroup()
                        .addComponent(jLabelModList)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(298, 298, 298))
        );
     
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelModificationEditScreen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelModificationEditScreen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                      

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {                                              
        dispose();
    }                                             

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will edit this modification within the selected node. Would you like to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (jTextFieldModName.getText().isBlank() | jTextFieldModStatus.getText().isBlank() | jTextFieldRestingStatus.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "[ERROR] All fields must be filled.", "Error - Empty Field", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String modificationName = jTextFieldModName.getText();
            Double modificationStatus = Double.valueOf(jTextFieldModStatus.getText());
            Double modificationResting = Double.valueOf(jTextFieldRestingStatus.getText());
            modification.setName(modificationName);
            modification.setModificationStatus(modificationStatus);
            modification.setRestingStatus(modificationResting);
            JOptionPane.showMessageDialog(rootPane, "Modification created successfully.", "Modification created", JOptionPane.INFORMATION_MESSAGE);
            JList_Modification.removeAll();
            shown();
        }
    }                                           

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int dialogResult = JOptionPane.showConfirmDialog(null, "Warning! This action will delete this modification from that node. Would you like to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (jTextFieldModName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "[ERROR] No modification has been selected.", "Error - Empty Field", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Check if the selected modification participates in any rules on the network.
            List<String> nodeEdge = findEdge.findModificationEdges(nodeList, jTextFieldModName.getText());
            if (nodeEdge.isEmpty()) {
                node.getNodeModifications().remove(node.getNodeModifications().get(modificationIndex));
                // Update the interface
                JList_Modification.removeAll();
                shown();
                jTextFieldModName.setText("");
                jTextFieldModStatus.setText("");
                jTextFieldRestingStatus.setText("");
            } else {
                String errorMessage = "";
                for (String edge : nodeEdge) {
                    errorMessage += "\n- " + edge;
                }
                JOptionPane.showMessageDialog(this, "[ERROR] The modification cannot be deleted because it is associated with the following nodes:\n"+errorMessage, "Error - Empty Node", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }                                             

    private void listModMouseClicked(java.awt.event.MouseEvent evt) {                                     
        if (evt.getClickCount() == 2) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "You will lose any unsaved edits made to this modification. Would you like to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                setModificationFields(JList_Modification.getSelectedValue());
            }
        }
    }                                    

    public void setModificationFields(NodeModification mod) {
        modification = mod;
        jTextFieldModName.setText(mod.getName());
        jTextFieldModStatus.setText(String.valueOf(mod.getModificationStatus()));
        jTextFieldRestingStatus.setText(String.valueOf(mod.getRestingStatus()));
    }
}
