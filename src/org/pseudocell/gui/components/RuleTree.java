/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.components;

import java.awt.Toolkit;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.pseudocell.core.rules.Rule;
import org.pseudocell.gui.utils.RuleTreeUtils;

/**
 *
 * @author ViníciusPierdoná
 */
public class RuleTree extends JTree {

    public DefaultMutableTreeNode rootNode;
    protected DefaultTreeModel treeModel;
    private RuleTreeUtils ruleTreeUtils = new RuleTreeUtils();
    private Toolkit toolkit = Toolkit.getDefaultToolkit();

    public RuleTree() {

        rootNode = new DefaultMutableTreeNode("Root Node");
        treeModel = new DefaultTreeModel(rootNode);
        this.setModel(treeModel);
        this.setEditable(true);
        this.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        this.setShowsRootHandles(true);
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
        TreePath currentSelection = this.getSelectionPath();
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
    
    public void removeCurrentNode(DefaultMutableTreeNode currentNode) {
            MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
            if (parent != null) {
                treeModel.removeNodeFromParent(currentNode);
                return;
            }
        // Either there was no selection, or the root was selected.
        toolkit.beep();
    }

    /**
     * Add child to the currently selected node.
     */
    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = this.getSelectionPath();
        String lastComponent;
        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            for (int i = parentPath.getPathCount(); i > 0; i--) {
                lastComponent = String.valueOf(parentPath.getPathComponent(i - 1));
                if (lastComponent.startsWith("[Bracket ")) {
                    parentNode = (DefaultMutableTreeNode) (parentPath.getPathComponent(i - 1));
                    break;
                }
            }
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
            this.scrollPathToVisible(new TreePath(childNode.getPath()));
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

    public String printTree() {
        return ruleTreeUtils.printDescendants(rootNode);
    }

    public boolean isEmpty() {
        boolean empty = true;
        if (this.rootNode.getChildCount() > 0) {
            empty = false;
        }
        return empty;
    }


}
