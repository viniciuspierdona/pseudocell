/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.panels;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.gui.components.JListNodeCellRender;
import org.pseudocell.config.Config;
import org.pseudocell.config.ConfigNodeStimulation;
import org.pseudocell.gui.utils.NodeFilter;

/**
 *
 * @author ViníciusPierdoná
 */
public class JPanelNodeStimulation extends JPanel {

    private static int DEFAULT_SIZE = GroupLayout.DEFAULT_SIZE;
    private static int PREFERRED_SIZE = GroupLayout.PREFERRED_SIZE;

    // Components variables
    private JButton JButton_Export, JButton_Filter, JButton_Import, JButton_Reset, JButton_Save;
    private JLabelTitle JLabel_Title;
    private JLabelSubTitle JLabel_Subtitle;
    private JLabel JLabel_Filter, JLabel_Frequency, JLabel_FrequencyOutput, JLabel_NodeList, JLabel_TargetNode;
    private JList<Node> JList_NodeList;
    private DefaultListModel model_NodeList;
    private JScrollPane jScrollPane1;
    private JSlider JSlider_Frequency;
    private JTextField JTextField_Filter, JTextField_TargetNode;
    private JPanel jPanel1, jPanel2, jPanel3, jPanelNodeStimulationScreen;

    Config configurations;
    ConfigNodeStimulation configNodeStimulation;
    List<Node> nodeList;
    NodeFilter nodeFilter;
    Node selectedNode;

    public JPanelNodeStimulation(Config configurations, ConfigNodeStimulation configNodeStimulation, List<Node> nodeList) {
        this.configurations = configurations;
        this.configNodeStimulation = configNodeStimulation;
        this.nodeList = nodeList;
        this.nodeFilter = new NodeFilter();

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
        JTextField_TargetNode.setText(configNodeStimulation.stimulatedNode);
        JLabel_FrequencyOutput.setText(String.valueOf(configNodeStimulation.stimulatedNodeFrequency));
        JSlider_Frequency.setValue(configNodeStimulation.stimulatedNodeFrequency);
    }

    private void setComponents() {
        JButton_Export = new JButton();
        JButton_Filter = new JButton();
        JButton_Import = new JButton();
        JButton_Reset = new JButton();
        JButton_Save = new JButton();
        JLabel_Title = new JLabelTitle();
        JLabel_Subtitle = new JLabelSubTitle();
        JLabel_Filter = new JLabel();
        JLabel_Frequency = new JLabel();
        JLabel_FrequencyOutput = new JLabel();
        JLabel_NodeList = new JLabel();
        JLabel_TargetNode = new JLabel();
        JList_NodeList = new JList<>();
        model_NodeList = new DefaultListModel();
        jScrollPane1 = new JScrollPane();
        JSlider_Frequency = new JSlider();
        JTextField_Filter = new JTextField();
        JTextField_TargetNode = new JTextField();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanelNodeStimulationScreen = new JPanel();

        JLabel_Title.setText("Node Stimulation");
        JLabel_Subtitle.setText("Create disturbances in the network and set how often nodes will be activated.");
        JButton_Save.setText("Save");
        JLabel_Frequency.setText("Frequency of stimulation:");
        JButton_Reset.setText("Reset");
        JLabel_FrequencyOutput.setText("0");
        JLabel_TargetNode.setText("Target Node");
        JButton_Export.setText("Export Configurations");
        JButton_Import.setText("Import Configurations");
        JLabel_Filter.setText("Filter");
        JButton_Filter.setText("Filter");
        JLabel_NodeList.setText("Node List");
        
        jScrollPane1.setViewportView(JList_NodeList);
        JList_NodeList.setCellRenderer(new JListNodeCellRender());

        JSlider_Frequency.setMajorTickSpacing(1);
        JSlider_Frequency.setMinimum(1);
        JSlider_Frequency.setMinorTickSpacing(1);
        JSlider_Frequency.setValue(10);

        JButton_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_SaveActionPerformed(evt);
            }
        });
        JSlider_Frequency.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JSlider_FrequencyStateChanged(evt);
            }
        });
        JButton_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_ResetActionPerformed(evt);
            }
        });
        JButton_Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_ExportActionPerformed(evt);
            }
        });
        JButton_Import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_ImportActionPerformed(evt);
            }
        });
        JButton_Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButton_FilterActionPerformed(evt);
            }
        });
        JList_NodeList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JList_NodeListMouseClicked(evt);
            }
        });
    }

    private void setLayoutDesign() {
        setMaximumSize(new java.awt.Dimension(900, 640));
        setMinimumSize(new java.awt.Dimension(900, 640));
        setPreferredSize(new java.awt.Dimension(900, 640));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        javax.swing.GroupLayout jPanelNodeStimulationScreenLayout = new javax.swing.GroupLayout(jPanelNodeStimulationScreen);
        jPanelNodeStimulationScreen.setLayout(jPanelNodeStimulationScreenLayout);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        // Organizing jPanel1
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JLabel_Subtitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JLabel_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addComponent(JLabel_Title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLabel_Subtitle)
                                .addContainerGap())
        );

        // Organizing jPanel3
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(JLabel_Frequency)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JLabel_FrequencyOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(JLabel_TargetNode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JSlider_Frequency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JTextField_TargetNode)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(JButton_Import, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(JButton_Export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(82, 82, 82)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(JButton_Save, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(JButton_Reset, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JLabel_TargetNode)
                                .addGap(0, 0, 0)
                                .addComponent(JTextField_TargetNode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JLabel_Frequency)
                                        .addComponent(JLabel_FrequencyOutput))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSlider_Frequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JButton_Export)
                                        .addComponent(JButton_Save))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JButton_Reset)
                                        .addComponent(JButton_Import))
                                .addContainerGap())
        );

        // Organizing jPanel2
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(JTextField_Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JButton_Filter))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JLabel_Filter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JLabel_NodeList, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JLabel_Filter)
                                .addGap(0, 0, 0)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(JTextField_Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JButton_Filter))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLabel_NodeList)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                .addContainerGap())
        );

        // Organizing jPanelNodeStimulationScreenLayout
        jPanelNodeStimulationScreenLayout.setHorizontalGroup(
                jPanelNodeStimulationScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNodeStimulationScreenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelNodeStimulationScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelNodeStimulationScreenLayout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanelNodeStimulationScreenLayout.setVerticalGroup(
                jPanelNodeStimulationScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNodeStimulationScreenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelNodeStimulationScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 178, Short.MAX_VALUE))
        );

        // Organizing this panel
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jPanelNodeStimulationScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelNodeStimulationScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }

    private void JList_NodeListMouseClicked(java.awt.event.MouseEvent evt) {
        // Ensures the item will only be accessed on the second click
        if (evt.getClickCount() == 2) {
            selectedNode = JList_NodeList.getSelectedValue();
            JTextField_TargetNode.setText(selectedNode.getName());
        }
    }

    private void JButton_FilterActionPerformed(java.awt.event.ActionEvent evt) {
        model_NodeList.clear();
        JList_NodeList.setModel(nodeFilter.filterNodes(model_NodeList, nodeList, JTextField_Filter.getText()));
    }

    private void JButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will remove the current stimulus. Are you sure you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            configNodeStimulation.stimulatedNode = "";
            configNodeStimulation.stimulatedNodeFrequency = 10;
            JTextField_TargetNode.setText(configNodeStimulation.stimulatedNode);
            JLabel_FrequencyOutput.setText(String.valueOf(configNodeStimulation.stimulatedNodeFrequency));
            JSlider_Frequency.setValue(configNodeStimulation.stimulatedNodeFrequency);
        }
    }

    private void JButton_SaveActionPerformed(java.awt.event.ActionEvent evt) {
        if (JTextField_TargetNode.getText().isBlank()) {
            configNodeStimulation.stimulatedNode = "";
        } else {
            configNodeStimulation.stimulatedNode = JTextField_TargetNode.getText();
        }
        configNodeStimulation.stimulatedNodeFrequency = JSlider_Frequency.getValue();
        if (configNodeStimulation.saveConfigs() == true) {
            JOptionPane.showMessageDialog(this, "Node stimulation settings saved successfully.", "Save Configurations", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "[ERROR] There was an error trying to save the node stimulation settings.", "Save Configurations", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void JSlider_FrequencyStateChanged(javax.swing.event.ChangeEvent evt) {
        JLabel_FrequencyOutput.setText(String.valueOf(JSlider_Frequency.getValue()));
        setVisible(true);
    }

    private void JButton_ExportActionPerformed(java.awt.event.ActionEvent evt) {
        if (JTextField_TargetNode.getText().isBlank()) {
            configNodeStimulation.stimulatedNode = "";
        } else {
            configNodeStimulation.stimulatedNode = JTextField_TargetNode.getText();
        }
        configNodeStimulation.stimulatedNodeFrequency = JSlider_Frequency.getValue();
        if (configNodeStimulation.saveConfigs() == true) {
            JOptionPane.showMessageDialog(this, "Node stimulation settings saved successfully.", "Save Configurations", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "[ERROR] There was an error trying to save the node stimulation settings.", "Save Configurations", JOptionPane.ERROR_MESSAGE);
        }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            configNodeStimulation.saveConfigs(file);
            JOptionPane.showMessageDialog(this, "File saved successfully.", "File Saved", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void JButton_ImportActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogType(javax.swing.JFileChooser.OPEN_DIALOG);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            configNodeStimulation.loadConfigs(file);
            shown();
            JOptionPane.showMessageDialog(this, "File imported successfully.", "Successful Import", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

}
