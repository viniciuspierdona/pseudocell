/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.tests;

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.pseudocell.core.Network;
import org.pseudocell.core.NetworkFactory;
import org.pseudocell.core.rules.Rule;
import org.pseudocell.config.Config;

/**
 *
 * @author ViníciusPierdoná
 */
public class RuleTree1 extends JPanel {

    public DefaultMutableTreeNode rootNode;
    protected DefaultTreeModel treeModel;
    protected JTree tree;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();

    public RuleTree1() {
        super(new GridLayout(1, 0));

        rootNode = new DefaultMutableTreeNode("Root Node");
        treeModel = new DefaultTreeModel(rootNode);

        tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);

        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane);
    }

    /**
     * Remove all nodes except the root node.
     */
    public void clear() {
        rootNode.removeAllChildren();
        treeModel.reload();
    }

    /**
     * Remove the currently selected node.
     */
    public void removeCurrentNode() {
        TreePath currentSelection = tree.getSelectionPath();
        if (currentSelection != null) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection.getLastPathComponent());
            MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
            if (parent != null) {
                treeModel.removeNodeFromParent(currentNode);
                return;
            }
        }
        // Either there was no selection, or the root was selected.
        toolkit.beep();
    }

    /**
     * Add child to the currently selected node.
     */
    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = tree.getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent, Object child) {
        return addObject(parent, child, false);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent, Object child, boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }

        // It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

        // Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            tree.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    public void populateTree(Rule rule) {
        clear();
        String ruleString[] = rule.getRuleString().split("(?<=[()&|])|(?=[()&|])");
        DefaultMutableTreeNode currentNode = this.rootNode;
        DefaultMutableTreeNode fatherNode = this.rootNode;
        int bracketNumber = 1;
        String ruleFragment;
        // Cycles through all elements of the rule
        for (int i = 0; i < ruleString.length; i++) {
            ruleFragment = ruleString[i];

            // Controls bracket concatenation
            if (ruleFragment.equals("(")) {
                currentNode = this.addObject(fatherNode, "[Bracket " + bracketNumber++ + "]");
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
                currentNode = this.addObject(fatherNode, ruleFragment);
            }
        }
    }

    class MyTreeModelListener implements TreeModelListener {

        public void treeNodesChanged(TreeModelEvent e) {
            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode) (e.getTreePath().getLastPathComponent());

            /*
       * If the event lists children, then the changed node is the child of the
       * node we've already gotten. Otherwise, the changed node and the
       * specified node are the same.
             */
            int index = e.getChildIndices()[0];
            node = (DefaultMutableTreeNode) (node.getChildAt(index));

            System.out.println("The user has finished editing the node.");
            System.out.println("New value: " + node.getUserObject());
        }

        public void treeNodesInserted(TreeModelEvent e) {
        }

        public void treeNodesRemoved(TreeModelEvent e) {
        }

        public void treeStructureChanged(TreeModelEvent e) {
        }
    }
}
