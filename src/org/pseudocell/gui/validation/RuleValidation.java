/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.validation;

import java.awt.Frame;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.rules.Rule;
import org.pseudocell.gui.components.RuleTree;

/**
 *
 * @author ViníciusPierdoná
 */
public class RuleValidation {

    private boolean validationFlag;

    public boolean isTreeEmpty(RuleTree ruleTree, Frame frame) {
        this.validationFlag = true;
        processRuleTree(ruleTree.rootNode);
        if (validationFlag) {
            JOptionPane.showMessageDialog(frame, "[ERROR] The Rule Tree has no valid relational operations.", "Error - Empty field", JOptionPane.ERROR_MESSAGE);
        }
        return validationFlag;
    }

    private void processRuleTree(DefaultMutableTreeNode root) {
        Enumeration children = root.children();
        String rootString = root.toString();
        if (!rootString.startsWith("Root Node") && !rootString.startsWith("[Bracket")) {
            validationFlag = false;
            return;
        }
        if (children != null) {
            while (children.hasMoreElements()) {
                processRuleTree((DefaultMutableTreeNode) children.nextElement());
            }
        }
    }

    /**
     * Checks if the state of the rule to be created does not match that of
     * another rule that already exists in this node.
     *
     * @param rule
     * @param node
     */
    public boolean checkRuleStatus(Rule rule, Node node, Frame frame) {
        this.validationFlag = true;
        if (!node.getRules().isEmpty()) {
            for (Rule nodeRule : node.getRules()) {
                if (rule.getNodeStatus().equals(nodeRule.getNodeStatus())) {
                    JOptionPane.showMessageDialog(frame, "[ERROR] This node already has a rule associated with that status.", "Error - Empty field", JOptionPane.ERROR_MESSAGE);
                    this.validationFlag = false;
                }
            }
        }
        return validationFlag;
    }

}
