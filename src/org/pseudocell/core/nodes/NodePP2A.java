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
public class NodePP2A extends Node{
    
    /* Constructors */
    public NodePP2A() {
        super("PP2A", 1, 0.0);
        /* 
        * Subunits: 
        *    PPP2R2 - PR55, B55 
        *    PPP2R5 - PR61, B56
        *    PPP2R3 - PR72 
        */
        List<NodeModification> nodeModifications = new ArrayList<>();
        nodeModifications.add(new NodeModification("PPP2R2", 0.0, 0.0));
        nodeModifications.add(new NodeModification("PPP2R5", 0.0, 0.0));
        nodeModifications.add(new NodeModification("PPP2R3", 0.0, 0.0));      
        super.setNodeModifications(nodeModifications);
    }
}
