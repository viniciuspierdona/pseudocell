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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.config.Config;
import org.pseudocell.gui.validation.FieldValidation;

/**
 *
 * @author ViníciusPierdoná
 */
public class JPanelGeneralConfigurations extends JPanel {
    
    private static int DEFAULT_SIZE = GroupLayout.DEFAULT_SIZE;
    private static int PREFERRED_SIZE = GroupLayout.PREFERRED_SIZE;

    // Components variables
    private JButton JButton_Export, JButton_Import, JButton_Reset, JButton_Save;
    private JComboBox<String> JComboBox_NodeFileFormat;
    private JLabelTitle JLabel_Title;
    private JLabelSubTitle JLabel_Subtitle;
    private JLabel JLabel_Important, JLabel_ImportantMessage1, JLabel_ImportantMessage2, JLabel_LastUpdate,
            JLabel_LastUpdateOutput, JLabel_NetworkFileFormat, JLabel_NetworkNumber, JLabel_NetworkSourceFile,
            JLabel_ProjectName, JLabel_SampleNumber, JLabel_TickNumber;    
    private JTextField JTextField_NetworkNumber, JTextField_NodeSourceFile, JTextField_ProjectName,
            JTextField_SampleNumber, JTextField_TickNumber;
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanelGeneralConfigurationsScreen;
    private JSeparator jSeparator1, jSeparator2, jSeparator3;
    
    Config configurations;
    FieldValidation fieldValidation;

    /**
     * Creates new form GeneralConfigurations
     *
     * @param configurations
    */
    public JPanelGeneralConfigurations(Config configurations) {
        
        this.configurations = configurations;
        fieldValidation = new FieldValidation();
        
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
    
    public void shown(){
        JTextField_ProjectName.setText(configurations.projectName);
        JLabel_LastUpdateOutput.setText(Config.dateFormat.format(configurations.lastUpdate));
        JTextField_NodeSourceFile.setText(configurations.networkSourceFileName);
        JTextField_TickNumber.setText(configurations.numberOfTicks.toString());
        JTextField_NetworkNumber.setText(configurations.numberOfNetworks.toString());
        JTextField_SampleNumber.setText(configurations.numberOfSamples.toString());
        for(int i = 0;  i < JComboBox_NodeFileFormat.getItemCount(); i++) {
            String value = JComboBox_NodeFileFormat.getItemAt(i);
            if(value.equals(configurations.networkSourceInputType)){
                JComboBox_NodeFileFormat.setSelectedIndex(i);
            }
        }
    }
    
    public void setComponents(){
        jPanelGeneralConfigurationsScreen = new JPanel();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jSeparator2 = new JSeparator();
        jSeparator1 = new JSeparator();
        jSeparator3 = new JSeparator();        
        JLabel_Title = new JLabelTitle();
        JLabel_Subtitle = new JLabelSubTitle();
        JLabel_Important = new JLabel();
        JLabel_ImportantMessage1 = new JLabel();
        JLabel_ImportantMessage2 = new JLabel();        
        JLabel_ProjectName = new JLabel();
        JLabel_LastUpdate = new JLabel();
        JLabel_LastUpdateOutput = new JLabel();
        JLabel_NetworkFileFormat = new JLabel();
        JLabel_NetworkSourceFile = new JLabel();
        JLabel_TickNumber = new JLabel();        
        JLabel_SampleNumber = new JLabel();
        JLabel_NetworkNumber = new JLabel();
        JTextField_NodeSourceFile = new JTextField();
        JTextField_ProjectName = new JTextField();
        JTextField_TickNumber = new JTextField();
        JTextField_SampleNumber = new JTextField();        
        JTextField_NetworkNumber = new JTextField();
        JComboBox_NodeFileFormat = new JComboBox<>();         
        JButton_Export = new JButton();
        JButton_Import = new JButton();
        JButton_Save = new JButton();
        JButton_Reset = new JButton();
        
        JLabel_Title.setText("General Configurations");
        JLabel_Subtitle.setText("Edit general settings for the simulation");
        JLabel_Important.setText("Important!");
        JLabel_ImportantMessage1.setText("To export changes or additions made to the network, go to \"Edit Network\"");
        JLabel_ImportantMessage2.setText("and select the \"Export Network\" option.");
        JLabel_ProjectName.setText("Project Name");
        JTextField_ProjectName.setText("newProject");
        JLabel_NetworkSourceFile.setText("Network source file");
        JTextField_NodeSourceFile.setText("networkNodes.xml");
        JLabel_LastUpdate.setText("Last update");
        JLabel_LastUpdateOutput.setText("0");
        JLabel_NetworkFileFormat.setText("Network file format");
        JLabel_TickNumber.setText("Number of ticks");
        JTextField_TickNumber.setText("1000");        
        JLabel_SampleNumber.setText("Number of samples");
        JTextField_SampleNumber.setText("30");        
        JLabel_NetworkNumber.setText("Number of networks");
        JTextField_NetworkNumber.setText("10");
        JButton_Export.setText("Export Configurations");
        JButton_Import.setText("Import Configurations");
        JButton_Save.setText("Save");
        JButton_Reset.setText("Reset");    
   
        JComboBox_NodeFileFormat.setModel(new DefaultComboBoxModel<>(new String[] { "default", "xml", "SQL (not implemented)" }));
        
        JTextField_TickNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                JTextField_TickNumber_KeyTyped(evt);
            }
        });
        JTextField_SampleNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                JTextField_SampleNumber_KeyTyped(evt);
            }
        });
        JTextField_NetworkNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                JTextField_NetworkNumber_KeyTyped(evt);
            }
        });
        JButton_Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JButton_Reset_ActionPerformed(evt);
            }
        });
        JButton_Export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JButton_Export_ActionPerformed(evt);
            }
        });
        JButton_Import.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JButton_Import_ActionPerformed(evt);
            }
        });
        JButton_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JButton_Save_ActionPerformed(evt);
            }
        });
    }
    
    public void setLayoutDesign(){
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
        GroupLayout jPanelGeneralConfigurationsScreenLayout = new GroupLayout(jPanelGeneralConfigurationsScreen);
        jPanelGeneralConfigurationsScreen.setLayout(jPanelGeneralConfigurationsScreenLayout);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel_Title, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabel_Subtitle, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabel_Important, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabel_ImportantMessage1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabel_ImportantMessage2, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JLabel_Title)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLabel_Subtitle)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JLabel_Important)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLabel_ImportantMessage1)
                .addComponent(JLabel_ImportantMessage2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTextField_ProjectName)
                    .addComponent(JTextField_NodeSourceFile)
                    .addComponent(JLabel_NetworkSourceFile, DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(JLabel_ProjectName, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLabel_LastUpdateOutput, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabel_NetworkFileFormat, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLabel_LastUpdate, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JComboBox_NodeFileFormat, 0, 238, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel_LastUpdate)
                    .addComponent(JLabel_ProjectName))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel_LastUpdateOutput)
                    .addComponent(JTextField_ProjectName, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel_NetworkSourceFile)
                    .addComponent(JLabel_NetworkFileFormat))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField_NodeSourceFile, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addComponent(JComboBox_NodeFileFormat, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
     
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JTextField_SampleNumber, GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel_TickNumber, GroupLayout.Alignment.LEADING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTextField_TickNumber, GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel_SampleNumber, GroupLayout.Alignment.LEADING, PREFERRED_SIZE, 240, PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTextField_NetworkNumber)
                    .addComponent(JLabel_NetworkNumber, PREFERRED_SIZE, 240, PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JLabel_TickNumber)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextField_TickNumber, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JLabel_NetworkNumber)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextField_NetworkNumber, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLabel_SampleNumber)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextField_SampleNumber, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JButton_Export)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JButton_Import)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JButton_Save)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JButton_Reset)
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(JButton_Reset)
                    .addComponent(JButton_Save)
                    .addComponent(JButton_Export)
                    .addComponent(JButton_Import))
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
       
        jPanelGeneralConfigurationsScreenLayout.setHorizontalGroup(
            jPanelGeneralConfigurationsScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator2, GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.Alignment.LEADING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.Alignment.LEADING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGeneralConfigurationsScreenLayout.setVerticalGroup(
            jPanelGeneralConfigurationsScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, PREFERRED_SIZE, 12, PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );     
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanelGeneralConfigurationsScreen, PREFERRED_SIZE, 618, PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelGeneralConfigurationsScreen, PREFERRED_SIZE, 624, PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
    }
    private void JTextField_TickNumber_KeyTyped(KeyEvent evt) {                                               
                if (!fieldValidation.getNumCharAllowed().contains(evt.getKeyChar() + "")) {
                    evt.consume();
                }
    }                                              

    private void JTextField_NetworkNumber_KeyTyped(KeyEvent evt) {                                                  
                if (!fieldValidation.getNumCharAllowed().contains(evt.getKeyChar() + "")) {
                    evt.consume();
                }
    }                                                 

    private void JTextField_SampleNumber_KeyTyped(KeyEvent evt) {                                                 
                if (!fieldValidation.getNumCharAllowed().contains(evt.getKeyChar() + "")) {
                    evt.consume();
                }
    }                                                

    private void JButton_Reset_ActionPerformed(ActionEvent evt) {                                              
                int dialogResult = JOptionPane.showConfirmDialog(null, "This action will restore the last saved settings. Do you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    setComponents();
                }
    }                                             

    private void JButton_Save_ActionPerformed(ActionEvent evt) {                                             
        // Checks if all fields are filled
        if (JTextField_ProjectName.getText().length() == 0
                || JTextField_NodeSourceFile.getText().length() == 0
                || JTextField_TickNumber.getText().length() == 0
                || JTextField_NetworkNumber.getText().length() == 0
                || JTextField_SampleNumber.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "[ERROR] Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Checks that numeric fields contain only numbers and are positive and greater than zero
        if (JTextField_TickNumber.getText().matches("[0-9]+") == false
                || Integer.valueOf(JTextField_TickNumber.getText()) <= 0
                || JTextField_NetworkNumber.getText().matches("[0-9]+") == false
                || Integer.valueOf(JTextField_NetworkNumber.getText()) <= 0
                || JTextField_SampleNumber.getText().matches("[0-9]+") == false
                || Integer.valueOf(JTextField_SampleNumber.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "[ERROR] The Number of Ticks, Networks or Samples fields must be a numeric and positive value.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        saveConfigurations();
    }                                            

    private void JButton_Export_ActionPerformed(ActionEvent evt) {                                               
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
    }                                              

    private void JButton_Import_ActionPerformed(ActionEvent evt) {                                               
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
    }                                              

    public void saveConfigurations() {
        configurations.projectName = JTextField_ProjectName.getText();
        configurations.lastUpdate = new Date();
        JLabel_LastUpdateOutput.setText(Config.dateFormat.format(configurations.lastUpdate));
        configurations.networkSourceFileName = JTextField_NodeSourceFile.getText();
        configurations.networkSourceInputType = JComboBox_NodeFileFormat.getSelectedItem().toString();
        configurations.numberOfTicks = Integer.valueOf(JTextField_TickNumber.getText());
        configurations.numberOfNetworks = Integer.valueOf(JTextField_NetworkNumber.getText());
        configurations.numberOfSamples = Integer.valueOf(JTextField_SampleNumber.getText());
        if (configurations.saveConfigs() == true) {
            JOptionPane.showMessageDialog(this, "Project settings saved successfully.", "Save Configurations", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "[ERROR] There was an error trying to save the project settings.", "Save Configurations", JOptionPane.ERROR_MESSAGE);
        }
    }
}
