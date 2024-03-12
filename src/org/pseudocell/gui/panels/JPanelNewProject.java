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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingWorker;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.pseudocell.core.Pseudocell;
import org.pseudocell.core.PseudocellFactory;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.gui.components.JLabelSubTitle;
import org.pseudocell.gui.components.JLabelTitle;
import org.pseudocell.config.Config;
import org.pseudocell.core.persistence.XMLNetworkWriter;
import org.pseudocell.gui.validation.FieldValidation;
import org.xml.sax.SAXException;

/**
 *
 * @author ViníciusPierdoná
 */
public class JPanelNewProject extends JPanel {

    private static int DEFAULT_SIZE = GroupLayout.DEFAULT_SIZE;
    private static int PREFERRED_SIZE = GroupLayout.PREFERRED_SIZE;

    // Components variables
    private JButton JButton_Cancel, JButton_Execute;
    private JLabelTitle JLabel_Title;
    private JLabelSubTitle JLabel_Subtitle;
    private JLabel JLabel_NetworkSize, JLabel_NetworkSizeOutput, JLabel_NumberNetworks, JLabel_NumberNetworksOutput,
            JLabel_NumberOfTicks, JLabel_NumberOfTicksOutput, JLabel_ProjectName, JLabel_SimulationOutput;
    private JPanel JPanel_NewProject, JPanel1, JPanel2;
    private JTextField JTextField_ProjectName;
    private JList listLogs;
    private DefaultListModel model_ListLogs;
    private JScrollPane jScrollPane1;

    private Config configurations;
    private List<Node> nodeList;
    private FieldValidation fieldValidation;
    private SimulationWorker simulationWorker;
    private boolean executionStarted;

    /**
     * Creates new form NewProject
     *
     * @param configurations
     * @param nodeList
     */
    public JPanelNewProject(Config configurations, List<Node> nodeList) {

        this.configurations = configurations;
        this.nodeList = nodeList;
        this.fieldValidation = new FieldValidation();
        this.simulationWorker = new SimulationWorker();

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
        JLabel_NetworkSizeOutput.setText(String.valueOf(nodeList.size()));
        JLabel_NumberNetworksOutput.setText(String.valueOf(configurations.numberOfNetworks));
        JLabel_NumberOfTicksOutput.setText(String.valueOf(configurations.numberOfTicks));
        JButton_Cancel.setEnabled(false);
    }

    private void setComponents() {

        JLabel_Title = new JLabelTitle();
        JLabel_Subtitle = new JLabelSubTitle();
        JLabel_SimulationOutput = new JLabel();
        JLabel_ProjectName = new JLabel();
        JLabel_NetworkSize = new JLabel();
        JLabel_NetworkSizeOutput = new JLabel();
        JLabel_NumberNetworks = new JLabel();
        JLabel_NumberOfTicks = new JLabel();
        JLabel_NumberNetworksOutput = new JLabel();
        JLabel_NumberOfTicksOutput = new JLabel();
        JButton_Execute = new JButton();
        JButton_Cancel = new JButton();
        JPanel_NewProject = new JPanel();
        JPanel1 = new JPanel();
        JPanel2 = new JPanel();
        listLogs = new JList();
        model_ListLogs = new DefaultListModel();
        jScrollPane1 = new JScrollPane();
        JTextField_ProjectName = new JTextField();

        JLabel_Title.setText("Project Overview");
        JLabel_Subtitle.setText("Create and execute a new PseudoCell simulation");
        JLabel_ProjectName.setText("Project Name:");
        JLabel_NetworkSize.setText("Network Size:");
        JLabel_NumberNetworks.setText("Number of Networks:");
        JLabel_NetworkSizeOutput.setText("0");
        JLabel_NumberNetworksOutput.setText("0");
        JLabel_NumberOfTicks.setText("Number of Ticks:");
        JLabel_NumberOfTicksOutput.setText("0");
        JLabel_SimulationOutput.setText("Simulation Output");
        JButton_Execute.setText("Execute");
        JButton_Cancel.setText("Cancel");
        JTextField_ProjectName.setText("newProject");

        JTextField_ProjectName.setName("Project Name TextField");

        jScrollPane1.setViewportView(listLogs);

        JButton_Execute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_Execute_ActionPerformed();
            }
        });
        JButton_Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton_Cancel_ActionPerformed();
            }
        });
    }

    private void setLayoutDesign() {
        setMaximumSize(new Dimension(900, 640));
        setMinimumSize(new Dimension(900, 640));
        setPreferredSize(new Dimension(900, 640));

        GroupLayout JPanel1Layout = new GroupLayout(JPanel1);
        JPanel1.setLayout(JPanel1Layout);
        GroupLayout JPanel2Layout = new GroupLayout(JPanel2);
        JPanel2.setLayout(JPanel2Layout);
        GroupLayout JPanel_NewProjectLayout = new GroupLayout(JPanel_NewProject);
        JPanel_NewProject.setLayout(JPanel_NewProjectLayout);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        // Organizing jPanel1
        JPanel1Layout.setHorizontalGroup(
                JPanel1Layout.createParallelGroup()
                        .addGroup(JPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(JPanel1Layout.createParallelGroup()
                                        .addGroup(JPanel1Layout.createSequentialGroup()
                                                .addGroup(JPanel1Layout.createParallelGroup()
                                                        .addComponent(JLabel_Subtitle)
                                                        .addComponent(JLabel_Title)))
                                        .addGroup(JPanel1Layout.createSequentialGroup()
                                                .addGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(JPanel1Layout.createSequentialGroup()
                                                                .addComponent(JLabel_ProjectName)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(JTextField_ProjectName, PREFERRED_SIZE, 396, PREFERRED_SIZE)
                                                                .addGap(0, 24, Short.MAX_VALUE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, JPanel1Layout.createSequentialGroup()
                                                                .addComponent(JLabel_NumberOfTicks)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JLabel_NumberOfTicksOutput, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, JPanel1Layout.createSequentialGroup()
                                                                .addComponent(JLabel_NumberNetworks)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JLabel_NumberNetworksOutput, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, JPanel1Layout.createSequentialGroup()
                                                                .addComponent(JLabel_NetworkSize)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(JLabel_NetworkSizeOutput, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addContainerGap())))
        );
        JPanel1Layout.setVerticalGroup(
                JPanel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, JPanel1Layout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addComponent(JLabel_Title)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLabel_Subtitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JLabel_ProjectName)
                                        .addComponent(JTextField_ProjectName))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JLabel_NetworkSize)
                                        .addComponent(JLabel_NetworkSizeOutput))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JLabel_NumberNetworks)
                                        .addComponent(JLabel_NumberNetworksOutput))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JLabel_NumberOfTicks)
                                        .addComponent(JLabel_NumberOfTicksOutput))
                                .addContainerGap())
        );

        // Organizing jPanel2
        JPanel2Layout.setHorizontalGroup(
                JPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, JPanel2Layout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JButton_Execute)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JButton_Cancel)
                                .addGap(31, 31, 31))
                        .addGroup(GroupLayout.Alignment.TRAILING, JPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JLabel_SimulationOutput, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(JPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(JPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane1, PREFERRED_SIZE, 491, PREFERRED_SIZE)
                                        .addContainerGap(28, Short.MAX_VALUE)))
        );
        JPanel2Layout.setVerticalGroup(
                JPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, JPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(JLabel_SimulationOutput)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                                .addGroup(JPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JButton_Cancel)
                                        .addComponent(JButton_Execute))
                                .addContainerGap())
                        .addGroup(JPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(JPanel2Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jScrollPane1, PREFERRED_SIZE, 311, PREFERRED_SIZE)
                                        .addContainerGap(34, Short.MAX_VALUE)))
        );

        // Organizing this JPanel_NewProjectLayout
        JPanel_NewProjectLayout.setHorizontalGroup(
                JPanel_NewProjectLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(JPanel_NewProjectLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(JPanel_NewProjectLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JPanel2, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JPanel1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 347, Short.MAX_VALUE))
        );
        JPanel_NewProjectLayout.setVerticalGroup(
                JPanel_NewProjectLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, JPanel_NewProjectLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JPanel2, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        // Organizing this jPanel        
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGap(24, 24, 24)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JPanel_NewProject)
                                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(JPanel_NewProject))
        );

    }

    private void JButton_Execute_ActionPerformed() {
        /* Validations and alerts: 
         * Checks that the Project Name field is filled in and is its length does not exceed the maximum number of characters allowed
         */
        if (!fieldValidation.validateMandatoryTextField(JTextField_ProjectName, null)
                || !fieldValidation.validateMaxCharacters(JTextField_ProjectName, null)) {
            return;
        }
        if (configurations.numberOfTicks > 1000 || configurations.numberOfNetworks > 10 || configurations.numberOfSamples > 30) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "High values for tick, network or samples  number can lead to long execution times and high processing demand. Do you want to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.NO_OPTION) {
                return;
            }
        }

        // Ensures that the system takes into account user-placed node configurations
        configurations.networkSourceInputType = "xml";

        model_ListLogs.removeAllElements();
        listLogs.setModel(model_ListLogs);
        model_ListLogs.addElement(Config.dateFormat.format(new Date()) + " Loading settings:");
        model_ListLogs.addElement("    Last update: " + Config.dateFormat.format(configurations.lastUpdate));
        model_ListLogs.addElement("    Network Source Input File Name: " + configurations.networkSourceFileName);
        model_ListLogs.addElement("    Number Of Networks: " + configurations.numberOfNetworks);
        model_ListLogs.addElement("    Number Of Ticks: " + configurations.numberOfTicks);
        model_ListLogs.addElement("    Node Stimulated: " + configurations.stimulatedNode);
        model_ListLogs.addElement("    Frequency of Stimulation: " + configurations.stimulatedNodeFrequency);
        model_ListLogs.addElement("   ");
        listLogs.setModel(model_ListLogs);

        if (!executionStarted) {
            simulationWorker = new SimulationWorker();
            simulationWorker.execute();
            executionStarted = false;
            JButton_Cancel.setEnabled(false);
            JButton_Execute.setEnabled(true);
        }

    }

    private void JButton_Cancel_ActionPerformed() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "This action will abort current execution. Would you like to proceed?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            simulationWorker.setStopFlag();
            executionStarted = false;
            JButton_Cancel.setEnabled(false);
            JButton_Execute.setEnabled(true);
        }
    }

    /**
     * SwingWorker class responsible for running the simulation in a background
     * thread. This implementation is important because the simulation can be a
     * heavy and time-consuming task. In this way, the GUI remains responsive to
     * user commands and it is possible to cancel the simulation execution, if
     * desired.
     */
    private class SimulationWorker extends SwingWorker<Void, String> {

        private boolean stopFlag = false;
        private String logString = "";

        @Override
        protected Void doInBackground() throws Exception {
            JButton_Cancel.setEnabled(true);
            JButton_Execute.setEnabled(false);

            String date = String.valueOf(LocalDate.now());
            String time = String.valueOf(LocalTime.now()).replace(":", "-");

            // Initialization of output file and destination directories
            // Creating destination directory
            logString = Config.dateFormat.format(new Date()) + "    Creating directory " + "results/" + JTextField_ProjectName.getText() + "/" + date + "/" + time;
            publish(logString);
            Thread.sleep(60);
            new File("results/" + JTextField_ProjectName.getText() + "/" + date + "/" + time).mkdirs();

            // Creating a file containing the network used in this execution
            try {
                XMLNetworkWriter.exportNodeList("results/" + JTextField_ProjectName.getText() + "/" + date + "/" + time + "/" + configurations.networkSourceFileName, nodeList);
                // Concurrently saves node settings to temporary file
                XMLNetworkWriter.exportNodeList(configurations.networkSourceFileName, nodeList);
            } catch (ParserConfigurationException | IOException | SAXException | TransformerException ex) {
            }

            // Creating the file that will contain the simulation results
            logString = Config.dateFormat.format(new Date()) + "    Creating destiny file... ";
            publish(logString);
            Thread.sleep(60);
            
            // Matrix contaning the mean values for each node per tick.
            Double meanExpressionsPerTic[][] = new Double[configurations.numberOfTicks][nodeList.size()]; 
            
            // String responsible for receiving the activation frequencies of the nodes for each sample
            StringBuilder freq = new StringBuilder();
            try ( PrintWriter writer = new PrintWriter("results/" + JTextField_ProjectName.getText() + "/" + date + "/" + time + "/Frequency.csv")) {
                // Initialize the output file header
                freq.append("Sample");
                freq.append(',');
                // Populate the header of the output file with the name of the nodes
                for (Node node : nodeList) {
                    freq.append(node.getName());
                    freq.append(',');
                }
                freq.append('\n');

                logString = Config.dateFormat.format(new Date()) + " Starting experiments...";
                publish(logString);
                Thread.sleep(60);

                // Iterates through the samples. The number of iterations and therefore of samples is defined by the user in the General Configurations menu
                for (int j = 0; j < configurations.numberOfSamples; j++) {
                    if (stopFlag) {
                        break;
                    }
                    logString = Config.dateFormat.format(new Date()) + " Starting sample: " + j;
                    publish(logString);
                    Thread.sleep(60);
                    // Initialize pseudoCell
                    Pseudocell pseudoCell = new PseudocellFactory().createPseudocell(configurations);
                    // Updates the network by the number of ticks defined by the user in the General Configurations menu
                    for (int i = 0; i < configurations.numberOfTicks; i++) {
                        if (stopFlag) {
                            break;
                        }
                        pseudoCell.update();
//                        logString = Config.dateFormat.format(new Date()) + " [info] " + Config.dateFormat.format(new Date()) + " Tick ended: " + i;
//                        publish(logString);

                        // napshot from all for the first sample
                        if(j == 0){
                            List<Double> meanExpressionPerNode = pseudoCell.getMeanExpression();
                            for(int index = 0; index < meanExpressionPerNode.size(); index++){
                                meanExpressionsPerTic[i][index] = meanExpressionPerNode.get(index);
                            }
                        }
                    }
                    freq.append("Sample " + j + ",");
                    for (Double nodeMeanFreq : pseudoCell.getMeanExpression()) {
                        freq.append(nodeMeanFreq);
                        freq.append(",");
                    }
                    freq.append("\n");
                    
                }
                writer.write(freq.toString());
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            
            System.out.println("Generating Matrix of stability scores");
            // Create a file to add
            StringBuilder freqAllNodesPerTick = new StringBuilder();
            try (PrintWriter writerAllNodesPerTick = new PrintWriter("results/" + JTextField_ProjectName.getText() + "/" + date + "/" + time + "/StabilityScoresPerTick.csv")) {
                // Initialize the output file header
                freqAllNodesPerTick.append("tick");
                freqAllNodesPerTick.append(',');
                // Populate the header of the output file with the name of the nodes
                for (Node node : nodeList) {
                    freqAllNodesPerTick.append(node.getName());
                    freqAllNodesPerTick.append(',');
                }
                freqAllNodesPerTick.append('\n');
                
                // construct the line per tick
                int ticks = configurations.numberOfTicks;
                int nodesSize = nodeList.size();
                
                for(Integer i = 0; i < ticks; i++){
                    freqAllNodesPerTick.append(i.toString());
                    freqAllNodesPerTick.append(',');
                    for(int j = 0; j < nodesSize; j++){

                        freqAllNodesPerTick.append(meanExpressionsPerTic[i][j].toString());
                        freqAllNodesPerTick.append(',');
                    }
                    freqAllNodesPerTick.append('\n');
                }
                
                writerAllNodesPerTick.write(freqAllNodesPerTick.toString());
                
                System.out.println("All is done <3");
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            logString = Config.dateFormat.format(new Date()) + " Ending experiments...";
            publish(logString);
            return null;
        }

        // Receives data chunks from the publish method asynchronously on the Event Dispatch Thread.
        @Override
        protected void process(List<String> chunk) {
            // Get last string from chunk
            String stringChunk = chunk.get(chunk.size() - 1);
            // Update list of logs
            model_ListLogs.addElement(stringChunk);
            listLogs.setModel(model_ListLogs);
        }

        void setStopFlag() {
            stopFlag = true;
        }
    }
}
