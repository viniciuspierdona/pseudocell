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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.config.Config;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.gui.components.JLabelImportant;
import org.pseudocell.gui.components.JListNodeCellRender;
import org.pseudocell.gui.utils.NodeFilter;
import org.pseudocell.gui.validation.FieldValidation;

/**
 *
 * @author ViníciusPierdoná
 */
public class JPanelGeneralConfigurations extends JPanel {

    private static int DEFAULT_SIZE = GroupLayout.DEFAULT_SIZE;
    private static int PREFERRED_SIZE = GroupLayout.PREFERRED_SIZE;

    // Components variables
    private JButton JButton_Export, JButton_Filter, JButton_Import, JButton_Reset, JButton_Save;
    private JLabel JLabel_Filter, JLabel_Frequency, JLabel_FrequencyOutput1, JLabel_ImportantMessage1,
            JLabel_ImportantMessage2, JLabel_LastUpdate, JLabel_LastUpdateOutput, JLabel_NetworkNumber,
            JLabel_NodeList, JLabel_ProjectName, JLabel_SampleNumber, JLabel_TargetNode, JLabel_TickNumber,
            JLabel_FrequencyOutput2, jLabel_StimulusMes1, jLabel_StimulusMes2, jLabel_StimulusMes3;
    private JLabelTitle JLabel_Title;
    private JLabelSubTitle JLabel_SubTitle1, jLabel_SubTitle2;
    private JLabelImportant JLabel_Important;
    private JList JList_NodeList;
    private DefaultListModel model_NodeList;
    private JScrollPane jScrollPane1;
    private JSlider JSlider_Frequency;
    private JTextField JTextField_Filter, JTextField_NetworkNumber, JTextField_ProjectName, JTextField_SampleNumber,
            JTextField_TargetNode, JTextField_TickNumber;
    private JCheckBox jCheckBox_Stimulation;
    private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanelGeneralConfigurationsScreen;
    private JSeparator jSeparator1, jSeparator2, jSeparator3;

    private Config configurations;
    private List<Node> nodeList;
    private NodeFilter nodeFilter;
    private Node selectedNode;
    private FieldValidation fieldValidation;

    /**
     * Creates new form GeneralConfigurations
     *
     * @param configurations
     * @param nodeList
     */
    public JPanelGeneralConfigurations(Config configurations, List<Node> nodeList) {

        this.configurations = configurations;
        this.nodeList = nodeList;
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
        JTextField_ProjectName.setText(configurations.projectName);
        JLabel_LastUpdateOutput.setText(Config.dateFormat.format(configurations.lastUpdate));
        JTextField_TickNumber.setText(configurations.numberOfTicks.toString());
        JTextField_NetworkNumber.setText(configurations.numberOfNetworks.toString());
        JTextField_SampleNumber.setText(configurations.numberOfSamples.toString());
        JList_NodeList.setModel(nodeFilter.filterNodes(model_NodeList, nodeList, null));
        JTextField_TargetNode.setText(configurations.stimulatedNode);
        JLabel_FrequencyOutput1.setText(String.valueOf(configurations.stimulatedNodeFrequency));
        JLabel_FrequencyOutput2.setText(String.valueOf(configurations.stimulatedNodeFrequency));
        JSlider_Frequency.setValue(configurations.stimulatedNodeFrequency);
    }

    private void setComponents() {
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanelGeneralConfigurationsScreen = new JPanel();
        JLabel_Title = new JLabelTitle();
        JLabel_SubTitle1 = new JLabelSubTitle();
        jLabel_SubTitle2 = new JLabelSubTitle();
        JLabel_Important = new JLabelImportant();
        JLabel_ImportantMessage1 = new JLabel();
        JLabel_ImportantMessage2 = new JLabel();
        JLabel_ProjectName = new JLabel();
        JLabel_LastUpdate = new JLabel();
        JLabel_LastUpdateOutput = new JLabel();
        JLabel_TickNumber = new JLabel();
        JLabel_NetworkNumber = new JLabel();
        JLabel_SampleNumber = new JLabel();
        JLabel_Filter = new JLabel();
        JLabel_NodeList = new JLabel();
        JLabel_TargetNode = new JLabel();
        JLabel_Frequency = new JLabel();
        JLabel_FrequencyOutput1 = new JLabel();
        jLabel_StimulusMes1 = new JLabel();
        jLabel_StimulusMes2 = new JLabel();
        JLabel_FrequencyOutput2 = new JLabel();
        jLabel_StimulusMes3 = new JLabel();
        JTextField_ProjectName = new JTextField();
        JTextField_TickNumber = new JTextField();
        JTextField_NetworkNumber = new JTextField();
        JTextField_SampleNumber = new JTextField();
        JTextField_Filter = new JTextField();
        JTextField_TargetNode = new JTextField();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jSeparator3 = new JSeparator();
        JButton_Export = new JButton();
        JButton_Import = new JButton();
        JButton_Save = new JButton();
        JButton_Reset = new JButton();
        JButton_Filter = new JButton();
        JList_NodeList = new JList();
        jScrollPane1 = new JScrollPane();
        model_NodeList = new DefaultListModel();
        JSlider_Frequency = new JSlider();
        jCheckBox_Stimulation = new JCheckBox();

        JTextField_ProjectName.setName("Project Name TextField");
        JTextField_TickNumber.setName("Number of Ticks TextField");
        JTextField_NetworkNumber.setName("Number of Networks TextField");
        JTextField_SampleNumber.setName("Number of Samples TextField");

        JLabel_Title.setText("General Configurations");
        JLabel_SubTitle1.setText("Edit general settings for the simulation");
        JLabel_Important.setText("Important!");
        JLabel_ImportantMessage1.setText("To export changes or additions made to the network, go to \"Edit Network\"");
        JLabel_ImportantMessage2.setText("and select the \"Export Network\" option.");
        JLabel_ProjectName.setText("Project Name");
        JTextField_ProjectName.setText("newProject");
        JLabel_LastUpdate.setText("Last update");
        JLabel_LastUpdateOutput.setText("0");
        JLabel_TickNumber.setText("Number of ticks");
        JTextField_TickNumber.setText("1000");
        JLabel_NetworkNumber.setText("Number of networks");
        JTextField_NetworkNumber.setText("10");
        JLabel_SampleNumber.setText("Number of samples");
        JTextField_SampleNumber.setText("30");
        JButton_Export.setText("Export Configurations");
        JButton_Import.setText("Import Configurations");
        JButton_Save.setText("Save");
        JButton_Reset.setText("Reset");
        JLabel_Filter.setText("Filter");
        JButton_Filter.setText("Filter");
        JLabel_NodeList.setText("Node List");
        JLabel_TargetNode.setText("Target Node");
        JLabel_Frequency.setText("Frequency of stimulation:");
        JLabel_FrequencyOutput1.setText("50%");
        jCheckBox_Stimulation.setText("Activate Pperturbation");
        jLabel_StimulusMes1.setText("This variable will determine an activation of the");
        jLabel_StimulusMes2.setText("chosen node after");
        JLabel_FrequencyOutput2.setText("2");
        jLabel_StimulusMes3.setText("ticks.");
        jLabel_SubTitle2.setText("Network Stimulation");

        JTextField_TargetNode.setEnabled(false);

        JSlider_Frequency.setMajorTickSpacing(1);
        JSlider_Frequency.setMinimum(1);
        JSlider_Frequency.setMinorTickSpacing(1);
        JSlider_Frequency.setValue(2);
        JSlider_Frequency.setInverted(true);

        jScrollPane1.setViewportView(JList_NodeList);
        JList_NodeList.setCellRenderer(new JListNodeCellRender());

        JTextField_TickNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                JTextField_KeyTyped(evt);
            }
        });
        JTextField_NetworkNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                JTextField_KeyTyped(evt);
            }
        });
        JTextField_SampleNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                JTextField_KeyTyped(evt);
            }
        });
        JButton_Export.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_Export_ActionPerformed(evt);
            }
        });
        JButton_Import.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_Import_ActionPerformed(evt);
            }
        });
        JButton_Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_Save_ActionPerformed(evt);
            }
        });
        JButton_Reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_Reset_ActionPerformed(evt);
            }
        });
        JButton_Filter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_Filter_ActionPerformed();
            }
        });
        JList_NodeList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList_NodeList_MouseClicked(evt);
            }
        });
        JSlider_Frequency.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                JSlider_Frequency_StateChanged(evt);
            }
        });
    }

    private void setLayoutDesign() {
        setMaximumSize(new Dimension(980, 650));
        setMinimumSize(new Dimension(980, 650));
        setPreferredSize(new Dimension(980, 650));

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

        // Organizing jPanel1
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(JLabel_Title, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JLabel_SubTitle1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(JLabel_LastUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JLabel_LastUpdateOutput, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(JLabel_Title)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLabel_SubTitle1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JLabel_LastUpdateOutput)
                                        .addComponent(JLabel_LastUpdate))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        // Organizing jPanel2
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(JTextField_ProjectName)
                                                                .addComponent(JLabel_ProjectName, DEFAULT_SIZE, 260, Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(JTextField_TickNumber, GroupLayout.Alignment.LEADING)
                                                                .addComponent(JLabel_TickNumber, DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                                                .addGap(74, 74, 74)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(JLabel_SampleNumber, PREFERRED_SIZE, 260, PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(JTextField_NetworkNumber)
                                                        .addComponent(JLabel_NetworkNumber, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(JTextField_SampleNumber))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jSeparator1, PREFERRED_SIZE, 6, PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(JLabel_ProjectName)
                                                .addGap(2, 2, 2)
                                                .addComponent(JTextField_ProjectName, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(JLabel_NetworkNumber)
                                                .addGap(2, 2, 2)
                                                .addComponent(JTextField_NetworkNumber, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(JLabel_TickNumber)
                                                .addGap(2, 2, 2)
                                                .addComponent(JTextField_TickNumber, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(JLabel_SampleNumber)
                                                .addGap(2, 2, 2)
                                                .addComponent(JTextField_SampleNumber, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        // Organizing jPanel3
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JButton_Export)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JButton_Import)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JButton_Save)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JButton_Reset)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JButton_Reset)
                                        .addComponent(JButton_Save)
                                        .addComponent(JButton_Export)
                                        .addComponent(JButton_Import))
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Organizing jPanel4
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel_SubTitle2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jSeparator2, PREFERRED_SIZE, 471, PREFERRED_SIZE))
                                        .addComponent(jSeparator3)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(JLabel_NodeList, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(JLabel_Filter, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(JTextField_Filter, PREFERRED_SIZE, 181, PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JButton_Filter))
                                                        .addComponent(jScrollPane1, PREFERRED_SIZE, 260, PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, 71)
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel_StimulusMes2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JLabel_FrequencyOutput2, PREFERRED_SIZE, 32, PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel_StimulusMes3))
                                                        .addComponent(JSlider_Frequency, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(JTextField_TargetNode, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(JLabel_TargetNode, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jCheckBox_Stimulation, GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                                .addComponent(JLabel_Frequency)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(JLabel_FrequencyOutput1, PREFERRED_SIZE, 65, PREFERRED_SIZE))
                                                        .addComponent(jLabel_StimulusMes1, DEFAULT_SIZE, 267, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel_SubTitle2)
                                        .addComponent(jSeparator2, PREFERRED_SIZE, 10, PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JLabel_Filter)
                                        .addComponent(jCheckBox_Stimulation))
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JTextField_Filter, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(JButton_Filter))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(JLabel_TargetNode)
                                                .addComponent(JTextField_TargetNode, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(JLabel_Frequency)
                                                        .addComponent(JLabel_FrequencyOutput1))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JSlider_Frequency, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel_StimulusMes1)
                                                .addGap(2, 2, 2)
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel_StimulusMes2)
                                                        .addComponent(JLabel_FrequencyOutput2)
                                                        .addComponent(jLabel_StimulusMes3)))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(JLabel_NodeList)
                                                .addComponent(jScrollPane1, PREFERRED_SIZE, 113, PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(jSeparator3, DEFAULT_SIZE, 6, Short.MAX_VALUE)
                                .addContainerGap())
        );

        // Organizing jPanelGeneralConfigurations
        jPanelGeneralConfigurationsScreenLayout.setHorizontalGroup(
                jPanelGeneralConfigurationsScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelGeneralConfigurationsScreenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel4, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGeneralConfigurationsScreenLayout.setVerticalGroup(
                jPanelGeneralConfigurationsScreenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelGeneralConfigurationsScreenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addContainerGap())
        );

        // Organizing this panel
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jPanelGeneralConfigurationsScreen, PREFERRED_SIZE, PREFERRED_SIZE, PREFERRED_SIZE)
                                .addContainerGap(333, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelGeneralConfigurationsScreen, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void JButton_Reset_ActionPerformed(ActionEvent evt) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will restore the last saved settings. Do you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            shown();
        }
    }

    private void JButton_Save_ActionPerformed(ActionEvent evt) {
        /* Validations and alerts: 
         * Checks if all Project Name, Number of Ticks, Number of Networks and Number of Samples fields are filled in, 
         * if the Project Name field does not exceed the maximum number of characters allowed and 
         * if the numeric fields have only positive and higher numbers that zero.
         */
        ArrayList<JTextField> validationMandatoryTextFields = new ArrayList<>();
        ArrayList<JTextField> validationNumericTextFields = new ArrayList<>();
        validationMandatoryTextFields.add(JTextField_ProjectName);
        validationNumericTextFields.add(JTextField_TickNumber);
        validationNumericTextFields.add(JTextField_NetworkNumber);
        validationNumericTextFields.add(JTextField_SampleNumber);
        validationMandatoryTextFields.addAll(validationNumericTextFields);
        if (!fieldValidation.validateMandatoryTextField(validationMandatoryTextFields, null)
                || !fieldValidation.validatePositiveIntegerTextField(validationNumericTextFields, null)
                || !fieldValidation.validateMaxCharacters(JTextField_ProjectName, null)) {
            return;
        }
        saveConfigurations();
    }

    private void JButton_Import_ActionPerformed(ActionEvent evt) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will discard the current settings. Do you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                configurations.loadConfigs(file);
                shown();
                if (!configurations.stimulatedNode.isEmpty()) {
                    jCheckBox_Stimulation.setSelected(true);
                }
                JOptionPane.showMessageDialog(this, "File imported successfully.", "Successful Import", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("File access cancelled by user.");
            }
        }
    }

    private void JButton_Export_ActionPerformed(ActionEvent evt) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will save the current settings. Do you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            saveConfigurations();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
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

    private void JTextField_KeyTyped(KeyEvent evt) {
        if (!fieldValidation.getNumCharAllowed().contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

    private void JButton_Filter_ActionPerformed() {
        model_NodeList.clear();
        JList_NodeList.setModel(nodeFilter.filterNodes(model_NodeList, nodeList, JTextField_Filter.getText()));
    }

    private void JList_NodeList_MouseClicked(MouseEvent evt) {
        JTextField_TargetNode.setText(((Node) JList_NodeList.getSelectedValue()).getName());
        jCheckBox_Stimulation.setSelected(true);
    }

    private void JSlider_Frequency_StateChanged(ChangeEvent evt) {
        Double frequency = Double.valueOf(JSlider_Frequency.getValue());
        Double percFrequency = 100/frequency;
        
        JLabel_FrequencyOutput1.setText(String.format("%.2f", percFrequency) + "%");
        JLabel_FrequencyOutput2.setText(String.valueOf(frequency));
        setVisible(true);
    }

    public void saveConfigurations() {
        configurations.projectName = JTextField_ProjectName.getText();
        configurations.lastUpdate = new Date();
        JLabel_LastUpdateOutput.setText(Config.dateFormat.format(configurations.lastUpdate));
        configurations.numberOfTicks = Integer.valueOf(JTextField_TickNumber.getText());
        configurations.numberOfNetworks = Integer.valueOf(JTextField_NetworkNumber.getText());
        configurations.numberOfSamples = Integer.valueOf(JTextField_SampleNumber.getText());
        if (jCheckBox_Stimulation.isSelected()) {
            if (!fieldValidation.validateMandatoryTextField(JTextField_TargetNode, null)) {
                return;
            }
            configurations.stimulatedNode = JTextField_TargetNode.getText();
            configurations.stimulatedNodeFrequency = JSlider_Frequency.getValue();
        } else {
            configurations.stimulatedNode = "";
            configurations.stimulatedNodeFrequency = 10;
        }
        if (configurations.saveConfigs() == true) {
            JOptionPane.showMessageDialog(this, "Project settings saved successfully.", "Save Configurations", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "[ERROR] There was an error trying to save the project settings.", "Save Configurations", JOptionPane.ERROR_MESSAGE);
        }
    }
}
