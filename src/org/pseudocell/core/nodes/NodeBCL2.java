/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ViníciusPierdoná
 */
public class NodeBCL2 extends Node {
    
    /* Constructors */
    public NodeBCL2() {
        super("BCL2", 1, 1.0);
        /* Phosphorilation sites */
        List<NodeModification> nodeModifications = new ArrayList<>();
        nodeModifications.add(new NodeModification("Thr56", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Thr69", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Ser70", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Ser87", 0.0, 0.0));        
        super.setNodeModifications(nodeModifications);
    }    
}
