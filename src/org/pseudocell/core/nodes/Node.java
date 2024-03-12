/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.pseudocell.core.rules.Rule;

/**
 *
 * @author ViníciusPierdoná
 */
public class Node implements Comparable<Node> {

    /* Variables
    * The variable type represents the node type:
    * 1 - Gene or Protein
    * 2 - Metabolite
    * 3 - Other
    * 4 - miRNA
    * 5 - Drug
     */
    private String name;
    private Integer type, id, stableCount, stableTick;
    private Double status, cumulativeStatus, frequency, restingStatus, stableVariationThreshold, stableFrequency;
    private Boolean knockdown = false;
    private List<Rule> rules;
    private List<NodeModification> nodeModifications;
    // Variable used in the Editor Interface
    private Boolean custom = false;
    private static int totalNodes;

    /* Constructors */
    public Node(String name) {
        this.id = totalNodes;
        this.name = name;
        this.type = 1;
        this.status = 0.0;
        this.cumulativeStatus = 0.0;
        this.frequency = 0.0;
        this.restingStatus = 0.0;
        this.stableTick = 0;
        this.stableCount = 0;
        this.stableVariationThreshold = 0.1;
        this.stableFrequency = 0.0;
        this.rules = new ArrayList<>();
        this.nodeModifications = new ArrayList<>();

        Node.totalNodes = Node.totalNodes + 1;
    }

    public Node(String name, Integer type, double status) {
        this.id = totalNodes;
        this.name = name;
        this.type = type;
        this.status = status;
        this.cumulativeStatus = 0.0;
        this.frequency = 0.0;
        this.restingStatus = 0.0;
        this.stableTick = 0;
        this.stableCount = 0;
        this.stableVariationThreshold = 0.1;
        this.stableFrequency = 0.0;
        this.rules = new ArrayList<>();
        this.nodeModifications = new ArrayList<>();

        Node.totalNodes = Node.totalNodes + 1;
    }

    public Node(String name, Integer type, double status, double restingStatus) {
        this.id = totalNodes;
        this.name = name;
        this.type = type;
        this.status = status;
        this.cumulativeStatus = 0.0;
        this.frequency = 0.0;
        this.restingStatus = restingStatus;
        this.stableTick = 0;
        this.stableCount = 0;
        this.stableVariationThreshold = 0.1;
        this.stableFrequency = 0.0;
        this.rules = new ArrayList<>();
        this.nodeModifications = new ArrayList<>();

        Node.totalNodes = Node.totalNodes + 1;
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public Integer getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public Double getStatus() {
        if (knockdown) {
            return 0.0;
        }
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public Double getCumulativeStatus() {
        return cumulativeStatus;
    }

    public void setCumulativeStatus(Double cumulativeStatus) {
        this.cumulativeStatus = cumulativeStatus;
    }

    public Double getFrequency() {
        return frequency;
    }

    public Integer getStableCount() {
        return stableCount;
    }

    public Integer getStableTick() {
        return stableTick;
    }

    public Double getStableVariationThreshold() {
        return stableVariationThreshold;
    }

    public Double getStableFrequency() {
        return stableFrequency;
    }

    public void setFrequency(Double frequency, int currentTick) {
        this.frequency = frequency;
        if(frequency > 0){
            double currentFrequency = frequency;
            double frequencyVariation = currentFrequency - stableFrequency;
            if (Math.abs(frequencyVariation) <= (stableFrequency*stableVariationThreshold)) {
                this.stableCount = this.stableCount + 1;
            } else {
                this.stableFrequency = currentFrequency;
                this.stableCount = 0;
                this.stableTick = currentTick;
            }
        }
    }

    public Boolean getKnockdown() {
        return knockdown;
    }

    public void setKnockdown(Boolean knockdown) {
        this.knockdown = knockdown;
    }

    public List<Rule> getRules() {
        Collections.sort(rules);
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public Boolean getCustom() {
        return custom;
    }

    public void setCustom(Boolean custom) {
        this.custom = custom;
    }

    public static int getTotalNodes() {
        return totalNodes;
    }

    public List<NodeModification> getNodeModifications() {
        return nodeModifications;
    }

    public void setNodeModifications(List<NodeModification> nodeModifications) {
        this.nodeModifications = nodeModifications;
    }

    public Double getRestingStatus() {
        return restingStatus;
    }

    public void setRestingStatus(Double restingStatus) {
        this.restingStatus = restingStatus;
    }

    /* Methods */
    @Override
    public int compareTo(Node otherNode) {
        if (this.id < otherNode.getId()) {
            return -1;
        } else {
            return 1;
        }
    }

    public void clearModifications() {
        if (nodeModifications.size() > 0) {
            for (int i = 0; i < nodeModifications.size(); i++) {
                nodeModifications.get(i).setModificationStatus(nodeModifications.get(i).getRestingStatus());
            }
        }
    }
}
