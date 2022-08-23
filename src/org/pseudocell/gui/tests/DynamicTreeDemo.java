/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.tests;

import org.pseudocell.gui.components.RuleTree;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import org.pseudocell.gui.components.PanelLayout;

/**
 *
 * @author ViníciusPierdoná
 */
public class DynamicTreeDemo extends JFrame implements ActionListener {

    private int newNodeSuffix = 1;
    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";
    private static int TEXTFIELD_COLUMNS = 18;

    // Component
    private JButton addButton, removeButton, clearButton;
    private JTextField ruleA, ruleB, ruleC;
    private RuleTree treePanel;

    public DynamicTreeDemo() {
        setTitle("Edit Network Rules");        
        setContentPane(getContainer());

        setBounds(400, 200, 650, 720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        printDescendants(treePanel.rootNode);
    }

    private PanelLayout getContainer() {
        PanelLayout masterContainer = new PanelLayout();

        // Create Components
        treePanel = new RuleTree();
        treePanel.populateTree();

        addButton = new JButton("Add");
        addButton.setActionCommand(ADD_COMMAND);
        addButton.addActionListener(this);

        removeButton = new JButton("Remove");
        removeButton.setActionCommand(REMOVE_COMMAND);
        removeButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setActionCommand(CLEAR_COMMAND);
        clearButton.addActionListener(this);

        ruleA = new JTextField(TEXTFIELD_COLUMNS);
        ruleB = new JTextField(TEXTFIELD_COLUMNS);
        ruleC = new JTextField(TEXTFIELD_COLUMNS);

        masterContainer.addComponent(treePanel, 0, 0, 8, 6, masterContainer.fillHorizontal);
        masterContainer.addComponent(addButton, 9, 0, 1, 2, masterContainer.fillHorizontal);
        masterContainer.addComponent(removeButton, 9, 2, 1, 2, masterContainer.fillHorizontal);
        masterContainer.addComponent(clearButton, 9, 4, 1, 2, masterContainer.fillHorizontal);
        masterContainer.addComponent(ruleA, 0, 7, 1, TEXTFIELD_COLUMNS, masterContainer.fillHorizontal);
        masterContainer.addComponent(ruleB, 1, 7, 1, TEXTFIELD_COLUMNS, masterContainer.fillHorizontal);
        masterContainer.addComponent(ruleC, 2, 7, 1, TEXTFIELD_COLUMNS, masterContainer.fillHorizontal);
        
        return masterContainer;

    }

    public void populateTree(DynamicTree treePanel) {
        NetworkFactory networkFactory = new NetworkFactory();
        Network network = networkFactory.createNetwork(new Config());
        Rule rule = network.getDefaultNodes().get(3).getRules().get(0);
        String ruleString[] = rule.getRuleString().split("(?<=[()&|])|(?=[()&|])");
        DefaultMutableTreeNode currentNode = treePanel.rootNode;
        DefaultMutableTreeNode fatherNode = treePanel.rootNode;
        int bracketNumber = 1;
        String ruleFragment;
        // Cycles through all elements of the rule
        for (int i = 0; i < ruleString.length; i++) {
            ruleFragment = ruleString[i];

            // Controls bracket concatenation
            if (ruleFragment.equals("(")) {
                currentNode = treePanel.addObject(fatherNode, "[Bracket " + bracketNumber++ + "]");
                fatherNode = currentNode;
            } else if (ruleFragment.equals(")")) {
                fatherNode = (DefaultMutableTreeNode) currentNode.getParent().getParent();
            } else // Checks if the current fragment is a relational operation
            if (ruleFragment.startsWith("Node:") || ruleFragment.startsWith("Mod:")) {
                // Checks if the current fragment is the last fragment of the rule
                if (i + 1 < ruleString.length) {
                    // Check for the next logical operator
                    for (int j = i; j < ruleString.length; j++) {
                        if (ruleString[j].equals("&") || ruleString[j].equals("|")) {
                            ruleFragment += " " + ruleString[j];
                            break;
                        }
                    }
                }
                currentNode = treePanel.addObject(fatherNode, ruleFragment);
            }
        }
    }

    public static void printDescendants(DefaultMutableTreeNode root) {
        Enumeration children = root.children();
        if (root.toString().startsWith("[Bracket")) {
            System.out.println("(");
        } else {
            System.out.println(root);
        }
        if (root.getNextNode() != null) {
            if (root.getLevel() > root.getNextNode().getLevel()) {
                System.out.println(")");
            }
        }
        if (children != null) {
            while (children.hasMoreElements()) {
                printDescendants((DefaultMutableTreeNode) children.nextElement());
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (ADD_COMMAND.equals(command)) {
            // Add button clicked
            treePanel.addObject("New Node " + newNodeSuffix++);
        } else if (REMOVE_COMMAND.equals(command)) {
            // Remove button clicked
            treePanel.removeCurrentNode();
        } else if (CLEAR_COMMAND.equals(command)) {
            // Clear button clicked.
            treePanel.clear();
        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("DynamicTreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        DynamicTreeDemo newContentPane = new DynamicTreeDemo();
//        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                com.formdev.flatlaf.FlatDarculaLaf.setup();
                DynamicTreeDemo newContentPane = new DynamicTreeDemo();
            }
        });
    }
}
