/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.utils;

import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ViníciusPierdoná
 */
public class RuleTreeUtils {

    private String treeString;

    public String printDescendants(DefaultMutableTreeNode root) {
        treeString = "";
        processRuleTree(root);
        // Removes any empty parentheses that the user might have placed
        treeString = treeString.replace("()", "");
        // Ignore the last logical operator of the String
        for (int i = treeString.length(); i > 0; i--) {
            char treeStringFragment = treeString.charAt(i-1);
            if (treeStringFragment == '&' || treeStringFragment == '|') {
                treeString = String.valueOf(new StringBuilder(treeString).deleteCharAt(i-1));
                break;
            }
        }
        // Fix the number of brackets in the resulting string
        int openBrackets = StringUtils.countMatches(treeString, "(");
        int closeBrackets = StringUtils.countMatches(treeString, ")");
        while (openBrackets > closeBrackets) {
            treeString += ")";
            openBrackets = StringUtils.countMatches(treeString, "(");
            closeBrackets = StringUtils.countMatches(treeString, ")");
        }
        while (StringUtils.countMatches(treeString, "&)")>0) {
            treeString = treeString.replace("&)", ")&");
       }
        return this.treeString;
    }

    private void processRuleTree(DefaultMutableTreeNode root) {
        Enumeration children = root.children();
        if (!root.toString().startsWith("Root Node")) {
            if (root.toString().startsWith("[Bracket")) {
                treeString += "(";
            } else {
                treeString += root;
            }
            if (root.getNextNode() != null) {
                if (root.getLevel() > root.getNextNode().getLevel()) {
                    treeString += ")";
                }
            }
        }
        if (children != null) {
            while (children.hasMoreElements()) {
                processRuleTree((DefaultMutableTreeNode) children.nextElement());
            }
        }
    }

}
