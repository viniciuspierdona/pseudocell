/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.utils;

import java.util.ArrayList;
import java.util.List;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.operations.RelationalOperation;
import org.pseudocell.core.rules.Rule;

/**
 *
 * @author ViníciusPierdoná
 */
public class FindEdge {

    public List<String> findModificationEdges(List<Node> nodeList, String targetModification) {
        List<String> nodeEdge = new ArrayList<>();
        // Iterates through all the rules in that list of nodes.
        for (Node node : nodeList) {
            for (Rule rule : node.getRules()) {
                String ruleString[] = rule.getRuleString().split("(?<=[()&|])|(?=[()&|])");
                for (int i = 0; i < ruleString.length; i++) {
                    String ruleFragment = ruleString[i];
                    // Checks if the rule is of type modification
                    if (ruleFragment.startsWith("Mod:")) {
                        int firstIndex = ruleFragment.indexOf("#") + 1;
                        int lastIndex = ruleFragment.indexOf(";");
                        String modification = ruleFragment.substring(firstIndex, lastIndex);
                        // Checks if the modification found is the same as the one sought.
                        // If so, it registers the name of the node that has that rule.
                        if (targetModification.equals(modification)) {
                            nodeEdge.add(node.getName());
                        }
                    }
                }
            }
        }
        return nodeEdge;
    }

    public List<String> findNodeEdges(List<Node> nodeList, String targetNode) {
        List<String> nodeEdge = new ArrayList<>();
        // Iterates through all the rules in that list of nodes.
        for (Node node : nodeList) {
            for (Rule rule : node.getRules()) {
                String ruleString[] = rule.getRuleString().split("(?<=[()&|])|(?=[()&|])");
                for (int i = 0; i < ruleString.length; i++) {
                    String ruleFragment = ruleString[i];
                    // Checks the node involved in the rule
                    if (ruleFragment.startsWith("Node:")) {
                        int firstIndex = ruleFragment.indexOf("Node:") + 5;
                        int lastIndex = ruleFragment.indexOf("#");
                        String nodeName = ruleFragment.substring(firstIndex, lastIndex);
                        // Checks if the node found is the same as the one sought.
                        // If so, it registers the name of the node that has that rule.
                        if (targetNode.equals(nodeName)) {
                            nodeEdge.add(node.getName());
                        }
                    }
                }
            }
        }
        return nodeEdge;
    }

}
