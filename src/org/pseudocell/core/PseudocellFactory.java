/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core;

import java.util.ArrayList;
import java.util.List;
import org.pseudocell.config.Config;

/**
 *
 * @author ViníciusPierdoná
 */
public class PseudocellFactory {
    
    NetworkFactory networkFactory = new NetworkFactory();
    
    public Pseudocell createPseudocell(Config configurations){
        List<Network> networks = new ArrayList<>();
        for (int i=0; i < configurations.numberOfNetworks; i++) {
            networks.add(networkFactory.createNetwork(configurations));
        }
        Pseudocell pseudocell = new Pseudocell(networks);
        return pseudocell;
    }
    
}
