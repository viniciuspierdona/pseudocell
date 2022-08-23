/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.rules;

import java.util.ArrayList;
import java.util.List;
import org.pseudocell.core.nodes.Metabolite;

/**
 * Class responsible for handling the logic rules that determines one of the
 * possible states of a node.
 *
 * @author ViníciusPierdoná
 */
public class Rule implements Comparable<Rule> {

    private String ruleString;
    private Double nodeStatus;
    
    private String modification = null;
    private String inputNode, outputNode;
    private Double conversionValue;

    /* Constructors */
    public Rule(String ruleString, Double nodeStatus) {
        this.ruleString = ruleString;
        this.nodeStatus = nodeStatus;
    }
    
    public Rule(String ruleString) {
        this.ruleString = ruleString;
    }

    /* Getters and Setters */
    public String getRuleString() {
        return ruleString;
    }

    public void setRuleString(String ruleString) {
        this.ruleString = ruleString;
    }

    public Double getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(Double nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public String getInputNode() {
        return inputNode;
    }

    public void setInputNode(String inputNode) {
        this.inputNode = inputNode;
    }

    public String getOutputNode() {
        return outputNode;
    }

    public void setOutputNode(String outputNode) {
        this.outputNode = outputNode;
    }

    @Override
    public int compareTo(Rule otherRule) {
        if (this.nodeStatus > otherRule.getNodeStatus()) {
            return 1;
        }
        if (this.nodeStatus < otherRule.getNodeStatus()) {
            return -1;
        }
        return 0;
    }

}
