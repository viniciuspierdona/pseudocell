/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Network class represents the pseudoCell network, which consists of nodes and their interactions.
 * It manages the update process, node configurations, and stimulation within the network.
 *
 * @author ViníciusPierdoná
 */
package org.pseudocell.core;

import org.pseudocell.core.nodes.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.pseudocell.core.nodes.Metabolite;
import org.pseudocell.core.nodes.NodeModification;
import org.pseudocell.core.rules.RuleMediator;

/**
 * The Network class models the pseudoCell network and its functionality.
 */
public class Network {

    private List<Node> defaultNodes = new ArrayList();
    private int tick, stimulatedNodeFrequency;
    private RuleMediator ruleMediator = new RuleMediator();
    private String stimulatedNode;

    /* Constructors*/
    public Network(List<Node> defaultNodes, String stimulatedNode, int stimulatedNodeFrequency) {
        this.defaultNodes = defaultNodes;
        this.stimulatedNode = stimulatedNode;
        this.stimulatedNodeFrequency = stimulatedNodeFrequency;
        // Configuring the network to start execution at tick zero
        this.tick = 0;
    }

    /* Getters and Setters*/
    public List<Node> getDefaultNodes() {
        return defaultNodes;
    }

    public void setDefaultNodes(List<Node> defaultNodes) {
        this.defaultNodes = defaultNodes;
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    /* Methods */
    public void update() {
        tick += 1;
        // Shuffles the order in which nodes will be updated
        Collections.shuffle(defaultNodes);
        for (int i = 0; i < defaultNodes.size(); i++) {
            Node n = defaultNodes.get(i);
            // Checks if the user has entered a node to be stimulated and if the current node matches that node. In addition, it checks if the tick corresponds to the activation frequency.
            if (!stimulatedNode.isEmpty() && tick % stimulatedNodeFrequency == 0 && stimulatedNode.equals(n.getName())) {
                n.setStatus(1.0);
            } else {
                // Checks if there are rules described for that node
                if (n.getRules().isEmpty()) {
                    if (!(n instanceof Metabolite)) {
                        // Ensures that no-rules nodes (Metabolites are a exception) revert to their baseline state after 
                        // the update.
                        n.setStatus(n.getRestingStatus());
                    }
                } else {
                    defaultNodes = ruleMediator.resolve(n, defaultNodes);
                }
                // If the node is a metabolite, after checking its rules, it is necessary to add income to its status
                if (n instanceof Metabolite) {
                    ((Metabolite) n).addIncome();
                }
            }
        }
        // Rearrange the order of nodes
        Collections.sort(defaultNodes);
        for (int i = 0; i < defaultNodes.size(); i++) {
            Node n = defaultNodes.get(i);
            n.setCumulativeStatus(n.getCumulativeStatus() + n.getStatus());
            n.setFrequency(n.getCumulativeStatus() / tick, tick);
        }
    }

    // Method responsible for replacing the settings of the default nodes with those submitted by the user.
    public void importNodeConfigurations(List<Node> nodes) {
        for (Node n : nodes) {
            // Cycles through the entire list of default nodes, replacing those present in the list passed by parameter
            for (int i = 0; i < defaultNodes.size(); i++) {
                if (defaultNodes.get(i).getName().equals(n.getName())) {
                    defaultNodes.set(i, n);
                    defaultNodes.get(i).setCustom(true);
                    break;
                }
            }
        }
    }
}
