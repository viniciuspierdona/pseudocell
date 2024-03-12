/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.nodes.Metabolite;
import org.pseudocell.core.nodes.NodeModification;
import org.pseudocell.core.operations.LogicalExpression;
import org.pseudocell.core.operations.RelationalOperation;

/**
 *
 * @author ViníciusPierdoná
 */
public class RuleMediator {

    private List<Node> defaultNodes;
    private RelationalOperation relationalOperation;
    private LogicalExpression logicalExpression;

    public List<Node> resolve(Node node, List<Node> dfNodes) {
        this.defaultNodes = dfNodes;
        List<Node> updatedNodes = new ArrayList<>();
        Double originalStatus = node.getStatus();
        // If node is not a Metabolite, ensures that, in case no logic rule is satisfied, 
        // the node status returns to the value determined by the variable restingStatus
        if (!(node instanceof Metabolite)) {
            node.setStatus(node.getRestingStatus());
        }
        // Cycles through all rules of a node
        // It assumes that the rule list are ordered from those defined for the smallest status values to the largest
        for (Rule r : node.getRules()) {
            // Check the rule type
            if (r instanceof MetabolicRule) {
                node = resolveMetabolicRules(node, r);
            } else if (r instanceof ModificationRule) {
                node = resolveModificationRules(node, r);
            } else {
                Node updatedNode = resolveNodeRules(node, r);
                // Checks whether the node state has been modified. If so, update the node.
                if (!Objects.equals(updatedNode.getStatus(), originalStatus)) {
                    node = updatedNode;
                }
            }
        }
        // If the node returns to 0.0, resets its modifications
        if (node.getStatus().equals(0.0)) {
            node.clearModifications();
        }
        updatedNodes.add(node);
        defaultNodes = updateDefaultList(defaultNodes, updatedNodes);
        return defaultNodes;
    }

    public Node resolveNodeRules(Node node, Rule r) {
        String resultString = "";
        //Creates an array separating the parentheses and logical operators from the relational operations
        String ruleString[] = r.getRuleString().split("(?<=[()&|])|(?=[()&|])");
        // Replaces all occurrences of nodes within a logic rule with the state value of those nodes
        for (int i = 0; i < ruleString.length; i++) {
            resultString = resultString + processRuleFragment(ruleString[i]);
        }
        logicalExpression = new LogicalExpression(resultString);
        if (logicalExpression.resolve() == 1) {
            node.setStatus(r.getNodeStatus());
        }
        return node;
    }

    public Node resolveModificationRules(Node node, Rule r) {
        String resultString = "";
        //Creates an array separating the parentheses and logical operators from the relational operations
        String ruleString[] = r.getRuleString().split("(?<=[()&|])|(?=[()&|])");
        // Replaces all occurrences of nodes within a logic rule with the state value of those nodes
        for (int i = 0; i < ruleString.length; i++) {
            resultString = resultString + processRuleFragment(ruleString[i]);
        }
        logicalExpression = new LogicalExpression(resultString);
        if (logicalExpression.resolve() == 1) {
            for (int i = 0; i < node.getNodeModifications().size(); i++) {
                NodeModification mod = node.getNodeModifications().get(i);
                if (r.getModification().equals(mod.getName())) {
                    node.getNodeModifications().get(i).setModificationStatus(r.getNodeStatus());
                }
            }
            // It guarantees that, in case any modification of the node has been updated, that its new state is already available to compose the other possible logical rules of this node.
            defaultNodes = updateDefaultList(defaultNodes, node);
        }
        return node;
    }

    public Node resolveMetabolicRules(Node node, Rule r) {
        List<Node> updatedNodes = new ArrayList<>();
        String resultString = "";
        //Creates an array separating the parentheses and logical operators from the relational operations
        String ruleString[] = r.getRuleString().split("(?<=[()&|])|(?=[()&|])");
        // Replaces all occurrences of nodes within a logic rule with the state value of those nodes
        for (int i = 0; i < ruleString.length; i++) {
            resultString = resultString + processRuleFragment(ruleString[i]);
        }
        logicalExpression = new LogicalExpression(resultString);
        if (logicalExpression.resolve() == 1) {
            // Setting the MetabolicConversion variables
            Metabolite inputNode = null;
            Metabolite outputNode = null;
            Double conversionValue = r.getNodeStatus();
            // Iterating through nodes to find input and output nodes
            for (Node n : defaultNodes) {
                if (r.getInputNode().equals(n.getName())) {
                    inputNode = (Metabolite) n;
                } else if (r.getOutputNode().equals(n.getName())) {
                    outputNode = (Metabolite) n;
                }
            }
            // Checks if the conversion does not lower the status below the minimum allowed value for that node
            if ((inputNode.getStatus() - conversionValue) >= inputNode.getMinValue()) {
                inputNode.setStatus(inputNode.getStatus() - conversionValue);
                // Checks if the value to be added to the outputNode does not exceed the maximum value (maxValue) of that node. 
                // If it does, set outputNode status as maxValue
                if ((outputNode.getStatus() + conversionValue) < outputNode.getMaxValue()) {
                    outputNode.setStatus(outputNode.getStatus() + conversionValue);
                } else {
                    outputNode.setStatus(outputNode.getMaxValue());
                }
                // Checks if any of the updated nodes was the node to which the rule belongs
                if (inputNode.getName().equals(node.getName())) {
                    node = inputNode;
                    updatedNodes.add(outputNode);
                } else if (outputNode.getName().equals(node.getName())) {
                    node = outputNode;
                    updatedNodes.add(inputNode);
                } else {
                    updatedNodes.add(inputNode);
                    updatedNodes.add(outputNode);
                }
            }
            defaultNodes = updateDefaultList(defaultNodes, updatedNodes);

        }
        return node;
    }

    public String processRuleFragment(String ruleFragment) {
        // Checks if the current rule fragment is a relational operation and a regular Node
        if (ruleFragment.startsWith("Node:")) {
            int firstIndex = ruleFragment.indexOf("Node:") + 5;
            int lastIndex = ruleFragment.indexOf("#");
            String targetNode = ruleFragment.substring(firstIndex, lastIndex);
            ruleFragment = ruleFragment.replace("Node:" + targetNode + "#", replaceNodeStatus(targetNode));
            // Solves the relational operation and replaces the expression with the result: 1 (true) or 0 (false)
            relationalOperation = new RelationalOperation(ruleFragment);
            ruleFragment = String.valueOf(relationalOperation.resolve());

            // Checks if the current rule fragment is a relational operation and is associated with an accessory variable
        } else if (ruleFragment.startsWith("Mod:")) {
            int firstIndex = ruleFragment.indexOf("Mod:") + 4;
            int lastIndex = ruleFragment.indexOf("#");
            int modIndex = ruleFragment.indexOf(";");
            String targetNode = ruleFragment.substring(firstIndex, lastIndex);
            String mod = ruleFragment.substring(lastIndex + 1, modIndex);
            ruleFragment = ruleFragment.replace("Mod:" + targetNode + "#" + mod + ";", replaceNodeStatus(targetNode, mod));
            // Solves the relational operation and replaces the expression with the result: 1 (true) or 0 (false)
            relationalOperation = new RelationalOperation(ruleFragment);
            ruleFragment = String.valueOf(relationalOperation.resolve());
        }
        return ruleFragment;
    }

    public String replaceNodeStatus(String targetNode) {
        String result = "";
        for (Node n : defaultNodes) {
            if (targetNode.equals(n.getName())) {
                result = String.valueOf(n.getStatus());
                break;
            }
        }
        return result;
    }

    public String replaceNodeStatus(String targetNode, String mod) {
        String result = "";
        for (Node n : defaultNodes) {
            if (targetNode.equals(n.getName())) {
                for (NodeModification m : n.getNodeModifications()) {
                    if (mod.equals(m.getName())) {
                        result = String.valueOf(m.getModificationStatus());
                        break;
                    }
                }
            }
        }
        return result;
    }

    public List<Node> updateDefaultList(List<Node> defaultNodes, List<Node> updatedNodes) {
        // Iterate through updatedNotes and replacing them in the general list of nodes that will be returned in resolve method.
        for (Node updatedNode : updatedNodes) {
            for (int i = 0; i < defaultNodes.size(); i++) {
                String nodeName = defaultNodes.get(i).getName();
                if (updatedNode.getName().equals(nodeName)) {
                    defaultNodes.set(i, updatedNode);
                }
            }
        }
        return defaultNodes;
    }

    public List<Node> updateDefaultList(List<Node> defaultNodes, Node updatedNode) {
        // Replacing the updated node in the general list of nodes that will be returned in resolve method.
        for (int i = 0; i < defaultNodes.size(); i++) {
            String nodeName = defaultNodes.get(i).getName();
            if (updatedNode.getName().equals(nodeName)) {
                defaultNodes.set(i, updatedNode);
            }
        }
        return defaultNodes;
    }
}
