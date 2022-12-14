/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.pseudocell.gui.cards;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.pseudocell.config.Config;
import org.pseudocell.gui.validation.FieldValidation;

/**
 *
 * @author ViníciusPierdoná
 */
public class GeneralConfigurations extends javax.swing.JPanel {

    Config configurations;
    FieldValidation fieldValidation;

    /**
     * Creates new form GeneralConfigurations
     *
     * @param configurations
     */
    public GeneralConfigurations(Config configurations) {
        initComponents();
        this.configurations = configurations;
        fieldValidation = new FieldValidation();
        
        // Create a listener to control the methods needed when shown or hidden the card
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent evt) {
                hidden();
            }

            @Override
            public void componentShown(ComponentEvent evt) {
                shown();
            }
        });
    }
    
    public void shown() {
        setComponents();
    }

    public void hidden() {

    }

    private void setComponents() {
        jTextFieldGCProjectName.setText(configurations.projectName);
        jLabelGCLastUpdateOutput.setText(Config.dateFormat.format(configurations.lastUpdate));
        jTextFieldGCNodeSourceFile.setText(configurations.networkSourceFileName);
        jTextFieldGCTickNumber.setText(configurations.numberOfTicks.toString());
        jTextFieldGCNetworkNumber.setText(configurations.numberOfNetworks.toString());
        jTextFieldGCSampleNumber.setText(configurations.numberOfSamples.toString());
        for(int i = 0;  i < jComboBoxGCNodeFileFormat.getItemCount(); i++) {
            String value = jComboBoxGCNodeFileFormat.getItemAt(i);
            if(value.equals(configurations.networkSourceInputType)){
                jComboBoxGCNodeFileFormat.setSelectedIndex(i);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGeneralConfigurationsScreen = new javax.swing.JPanel();
        jLabelGCTitle = new javax.swing.JLabel();
        jLabelGCSubtitle = new javax.swing.JLabel();
        jLabelGCImportantMessage1 = new javax.swing.JLabel();
        jLabelGCImportantMessage2 = new javax.swing.JLabel();
        jLabelGCImportant = new javax.swing.JLabel();
        jLabelGCLastUpdate = new javax.swing.JLabel();
        jLabelGCLastUpdateOutput = new javax.swing.JLabel();
        jLabelGCProjectName = new javax.swing.JLabel();
        jLabelGCNetworkSourceFile = new javax.swing.JLabel();
        jLabelGCNetworkFileFormat = new javax.swing.JLabel();
        jTextFieldGCNodeSourceFile = new javax.swing.JTextField();
        jComboBoxGCNodeFileFormat = new javax.swing.JComboBox<>();
        jLabelGCTickNumber = new javax.swing.JLabel();
        jTextFieldGCTickNumber = new javax.swing.JTextField();
        jTextFieldGCNetworkNumber = new javax.swing.JTextField();
        jLabelGCNetworkNumber = new javax.swing.JLabel();
        jLabelGCSampleNumber = new javax.swing.JLabel();
        jTextFieldGCSampleNumber = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonGCReset = new javax.swing.JButton();
        jButtonGCSave = new javax.swing.JButton();
        jButtonGCExport = new javax.swing.JButton();
        jButtonGCImport = new javax.swing.JButton();
        jTextFieldGCProjectName = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(650, 720));
        setPreferredSize(new java.awt.Dimension(650, 720));

        jPanelGeneralConfigurationsScreen.setBackground(new java.awt.Color(56, 58, 77));
        jPanelGeneralConfigurationsScreen.setMaximumSize(new java.awt.Dimension(650, 720));
        jPanelGeneralConfigurationsScreen.setPreferredSize(new java.awt.Dimension(650, 720));

        jLabelGCTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelGCTitle.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCTitle.setText("General Configurations");

        jLabelGCSubtitle.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCSubtitle.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCSubtitle.setText("Edit general settings for the simulation");

        jLabelGCImportantMessage1.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCImportantMessage1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCImportantMessage1.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCImportantMessage1.setText("To export changes or additions made to the network, go to \"Edit Network\"");

        jLabelGCImportantMessage2.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCImportantMessage2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCImportantMessage2.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCImportantMessage2.setText("and select the \"Export Network\" option.");

        jLabelGCImportant.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCImportant.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelGCImportant.setForeground(new java.awt.Color(255, 102, 0));
        jLabelGCImportant.setText("Important!");

        jLabelGCLastUpdate.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCLastUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCLastUpdate.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCLastUpdate.setText("Last update");

        jLabelGCLastUpdateOutput.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCLastUpdateOutput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCLastUpdateOutput.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCLastUpdateOutput.setText("0");

        jLabelGCProjectName.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCProjectName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCProjectName.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCProjectName.setText("Project Name");

        jLabelGCNetworkSourceFile.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCNetworkSourceFile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCNetworkSourceFile.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCNetworkSourceFile.setText("Network source file");

        jLabelGCNetworkFileFormat.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCNetworkFileFormat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCNetworkFileFormat.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCNetworkFileFormat.setText("Network file format");

        jTextFieldGCNodeSourceFile.setBackground(new java.awt.Color(69, 71, 95));
        jTextFieldGCNodeSourceFile.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldGCNodeSourceFile.setText("networkNodes.xml");

        jComboBoxGCNodeFileFormat.setBackground(new java.awt.Color(69, 71, 95));
        jComboBoxGCNodeFileFormat.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxGCNodeFileFormat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "default", "xml", "SQL (not implemented)" }));

        jLabelGCTickNumber.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCTickNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCTickNumber.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCTickNumber.setText("Number of ticks");

        jTextFieldGCTickNumber.setBackground(new java.awt.Color(69, 71, 95));
        jTextFieldGCTickNumber.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldGCTickNumber.setText("1000");
        jTextFieldGCTickNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldGCTickNumberKeyTyped(evt);
            }
        });

        jTextFieldGCNetworkNumber.setBackground(new java.awt.Color(69, 71, 95));
        jTextFieldGCNetworkNumber.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldGCNetworkNumber.setText("10");
        jTextFieldGCNetworkNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldGCNetworkNumberKeyTyped(evt);
            }
        });

        jLabelGCNetworkNumber.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCNetworkNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCNetworkNumber.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCNetworkNumber.setText("Number of networks");

        jLabelGCSampleNumber.setBackground(new java.awt.Color(204, 204, 255));
        jLabelGCSampleNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelGCSampleNumber.setForeground(new java.awt.Color(204, 204, 255));
        jLabelGCSampleNumber.setText("Number of samples");

        jTextFieldGCSampleNumber.setBackground(new java.awt.Color(69, 71, 95));
        jTextFieldGCSampleNumber.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldGCSampleNumber.setText("30");
        jTextFieldGCSampleNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldGCSampleNumberKeyTyped(evt);
            }
        });

        jButtonGCReset.setBackground(new java.awt.Color(126, 129, 161));
        jButtonGCReset.setForeground(new java.awt.Color(51, 51, 51));
        jButtonGCReset.setText("Reset");
        jButtonGCReset.setBorderPainted(false);
        jButtonGCReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGCResetActionPerformed(evt);
            }
        });

        jButtonGCSave.setBackground(new java.awt.Color(126, 129, 161));
        jButtonGCSave.setForeground(new java.awt.Color(51, 51, 51));
        jButtonGCSave.setText("Save");
        jButtonGCSave.setBorderPainted(false);
        jButtonGCSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGCSaveActionPerformed(evt);
            }
        });

        jButtonGCExport.setBackground(new java.awt.Color(126, 129, 161));
        jButtonGCExport.setForeground(new java.awt.Color(51, 51, 51));
        jButtonGCExport.setText("Export Configurations");
        jButtonGCExport.setBorderPainted(false);
        jButtonGCExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGCExportActionPerformed(evt);
            }
        });

        jButtonGCImport.setBackground(new java.awt.Color(126, 129, 161));
        jButtonGCImport.setForeground(new java.awt.Color(51, 51, 51));
        jButtonGCImport.setText("Import Configurations");
        jButtonGCImport.setBorderPainted(false);
        jButtonGCImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGCImportActionPerformed(evt);
            }
        });

        jTextFieldGCProjectName.setBackground(new java.awt.Color(69, 71, 95));
        jTextFieldGCProjectName.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldGCProjectName.setText("newProject");

        javax.swing.GroupLayout jPanelGeneralConfigurationsScreenLayout = new javax.swing.GroupLayout(jPanelGeneralConfigurationsScreen);
        jPanelGeneralConfigurationsScreen.setLayout(jPanelGeneralConfigurationsScreenLayout);
        jPanelGeneralConfigurationsScreenLayout.setHorizontalGroup(
            jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                        .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelGCImportant)
                            .addComponent(jLabelGCImportantMessage1)
                            .addComponent(jLabelGCSubtitle)
                            .addComponent(jLabelGCTitle)
                            .addComponent(jLabelGCImportantMessage2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                                .addComponent(jButtonGCExport)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonGCImport)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                .addComponent(jButtonGCSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonGCReset))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldGCNodeSourceFile, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                        .addComponent(jTextFieldGCTickNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                        .addComponent(jTextFieldGCSampleNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                        .addComponent(jLabelGCNetworkSourceFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGCTickNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGCSampleNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldGCProjectName))
                                    .addComponent(jLabelGCProjectName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelGCNetworkFileFormat)
                                    .addComponent(jLabelGCNetworkNumber)
                                    .addComponent(jTextFieldGCNetworkNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxGCNodeFileFormat, javax.swing.GroupLayout.Alignment.TRAILING, 0, 238, Short.MAX_VALUE)
                                    .addComponent(jLabelGCLastUpdate)
                                    .addComponent(jLabelGCLastUpdateOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator3))))
                .addGap(64, 64, 64))
        );
        jPanelGeneralConfigurationsScreenLayout.setVerticalGroup(
            jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabelGCTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGCSubtitle)
                .addGap(26, 26, 26)
                .addComponent(jLabelGCImportant)
                .addGap(0, 0, 0)
                .addComponent(jLabelGCImportantMessage1)
                .addGap(0, 0, 0)
                .addComponent(jLabelGCImportantMessage2)
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGCLastUpdate)
                    .addComponent(jLabelGCProjectName))
                .addGap(7, 7, 7)
                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGCLastUpdateOutput)
                    .addComponent(jTextFieldGCProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGCNetworkSourceFile)
                    .addComponent(jLabelGCNetworkFileFormat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGCNodeSourceFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGCNodeFileFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                        .addComponent(jLabelGCTickNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGCTickNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                        .addComponent(jLabelGCNetworkNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGCNetworkNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGCSampleNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldGCSampleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGCReset)
                    .addComponent(jButtonGCSave)
                    .addComponent(jButtonGCExport)
                    .addComponent(jButtonGCImport))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelGeneralConfigurationsScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelGeneralConfigurationsScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldGCTickNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGCTickNumberKeyTyped
                if (!fieldValidation.getNumCharAllowed().contains(evt.getKeyChar() + "")) {
                    evt.consume();
                }
    }//GEN-LAST:event_jTextFieldGCTickNumberKeyTyped

    private void jTextFieldGCNetworkNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGCNetworkNumberKeyTyped
                if (!fieldValidation.getNumCharAllowed().contains(evt.getKeyChar() + "")) {
                    evt.consume();
                }
    }//GEN-LAST:event_jTextFieldGCNetworkNumberKeyTyped

    private void jTextFieldGCSampleNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGCSampleNumberKeyTyped
                if (!fieldValidation.getNumCharAllowed().contains(evt.getKeyChar() + "")) {
                    evt.consume();
                }
    }//GEN-LAST:event_jTextFieldGCSampleNumberKeyTyped

    private void jButtonGCResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGCResetActionPerformed
                int dialogResult = JOptionPane.showConfirmDialog(null, "This action will restore the last saved settings. Do you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    setComponents();
                }
    }//GEN-LAST:event_jButtonGCResetActionPerformed

    private void jButtonGCSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGCSaveActionPerformed
        // Checks if all fields are filled
        if (jTextFieldGCProjectName.getText().length() == 0
                || jTextFieldGCNodeSourceFile.getText().length() == 0
                || jTextFieldGCTickNumber.getText().length() == 0
                || jTextFieldGCNetworkNumber.getText().length() == 0
                || jTextFieldGCSampleNumber.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "[ERROR] Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Checks that numeric fields contain only numbers and are positive and greater than zero
        if (jTextFieldGCTickNumber.getText().matches("[0-9]+") == false
                || Integer.valueOf(jTextFieldGCTickNumber.getText()) <= 0
                || jTextFieldGCNetworkNumber.getText().matches("[0-9]+") == false
                || Integer.valueOf(jTextFieldGCNetworkNumber.getText()) <= 0
                || jTextFieldGCSampleNumber.getText().matches("[0-9]+") == false
                || Integer.valueOf(jTextFieldGCSampleNumber.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "[ERROR] The Number of Ticks, Networks or Samples fields must be a numeric and positive value.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        saveConfigurations();
    }//GEN-LAST:event_jButtonGCSaveActionPerformed

    private void jButtonGCExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGCExportActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will save the current settings. Do you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            saveConfigurations();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                configurations.saveConfigs(file);
                JOptionPane.showMessageDialog(this, "File saved successfully.", "File Saved", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("File access cancelled by user.");
            }
        }
    }//GEN-LAST:event_jButtonGCExportActionPerformed

    private void jButtonGCImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGCImportActionPerformed
                int dialogResult = JOptionPane.showConfirmDialog(null, "This action will discard the current settings. Do you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogType(javax.swing.JFileChooser.OPEN_DIALOG);
                    int returnVal = fileChooser.showOpenDialog(this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        configurations.loadConfigs(file);
                        setComponents();
                        JOptionPane.showMessageDialog(this, "File imported successfully.", "Successful Import", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println("File access cancelled by user.");
                    }
                }
    }//GEN-LAST:event_jButtonGCImportActionPerformed

    public void saveConfigurations() {
        configurations.projectName = jTextFieldGCProjectName.getText();
        configurations.lastUpdate = new Date();
        jLabelGCLastUpdateOutput.setText(Config.dateFormat.format(configurations.lastUpdate));
        configurations.networkSourceFileName = jTextFieldGCNodeSourceFile.getText();
        configurations.networkSourceInputType = jComboBoxGCNodeFileFormat.getSelectedItem().toString();
        configurations.numberOfTicks = Integer.valueOf(jTextFieldGCTickNumber.getText());
        configurations.numberOfNetworks = Integer.valueOf(jTextFieldGCNetworkNumber.getText());
        configurations.numberOfSamples = Integer.valueOf(jTextFieldGCSampleNumber.getText());
        if (configurations.saveConfigs() == true) {
            JOptionPane.showMessageDialog(this, "Project settings saved successfully.", "Save Configurations", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "[ERROR] There was an error trying to save the project settings.", "Save Configurations", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGCExport;
    private javax.swing.JButton jButtonGCImport;
    private javax.swing.JButton jButtonGCReset;
    private javax.swing.JButton jButtonGCSave;
    private javax.swing.JComboBox<String> jComboBoxGCNodeFileFormat;
    private javax.swing.JLabel jLabelGCImportant;
    private javax.swing.JLabel jLabelGCImportantMessage1;
    private javax.swing.JLabel jLabelGCImportantMessage2;
    private javax.swing.JLabel jLabelGCLastUpdate;
    private javax.swing.JLabel jLabelGCLastUpdateOutput;
    private javax.swing.JLabel jLabelGCNetworkFileFormat;
    private javax.swing.JLabel jLabelGCNetworkNumber;
    private javax.swing.JLabel jLabelGCNetworkSourceFile;
    private javax.swing.JLabel jLabelGCProjectName;
    private javax.swing.JLabel jLabelGCSampleNumber;
    private javax.swing.JLabel jLabelGCSubtitle;
    private javax.swing.JLabel jLabelGCTickNumber;
    private javax.swing.JLabel jLabelGCTitle;
    private javax.swing.JPanel jPanelGeneralConfigurationsScreen;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldGCNetworkNumber;
    private javax.swing.JTextField jTextFieldGCNodeSourceFile;
    private javax.swing.JTextField jTextFieldGCProjectName;
    private javax.swing.JTextField jTextFieldGCSampleNumber;
    private javax.swing.JTextField jTextFieldGCTickNumber;
    // End of variables declaration//GEN-END:variables
}
