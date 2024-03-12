/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.pseudocell.core.nodes.Node;

/**
 *
 * @author ViníciusPierdoná
 */
public class Pseudocell {
    
    private List<Network> networks;
    private List<Double> meanExpression;
    private List<Integer> stableTicks;
    private boolean alive;
    
    /* Constructors */
    public Pseudocell(List<Network> networks) {
        this.alive = true;
        this.networks = networks;
        this.meanExpression = new ArrayList<>();
    }
    
    /* Getters and Setters */
    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public List<Double> getMeanExpression() {
        boolean arraySetup = false; // Variable that controls the setup of meanExpression List
        Double freqSum;
        
        meanExpression.clear();
        for (Network network : networks){
            if (!arraySetup) {
                 
                for (int i = 0; i < network.getDefaultNodes().size(); i++) {
                    Node node = network.getDefaultNodes().get(i);
                    meanExpression.add(node.getFrequency());
                }
            } else {
                for (int i = 0; i < network.getDefaultNodes().size(); i++) {
                    Node node = network.getDefaultNodes().get(i);
                    freqSum = meanExpression.get(i) + node.getFrequency();
                    meanExpression.set(i, freqSum);
                }
            }
            arraySetup = true;
        }
        for (int i = 0; i < meanExpression.size(); i++) {
            meanExpression.set(i, (meanExpression.get(i) / networks.size()));
        }
        return meanExpression;
    }
    
    public List<Integer> getStableTick() {
        // For simplicity, the list of cycles in which the network determined stability in node variation is given for the first network of each sample.
        Network network = networks.get(0);
        for (int i = 0; i < network.getDefaultNodes().size(); i++) {
            Node node = network.getDefaultNodes().get(i);
            stableTicks.add(node.getStableTick());
        }
        return stableTicks;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    /* Methods */
    public void update() {
        if (this.alive == true) {
            for (int i = 0; i<networks.size();i++) {
                networks.get(i).update();
            }
        }
    }
    
}
