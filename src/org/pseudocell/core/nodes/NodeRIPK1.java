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
public class NodeRIPK1 extends Node {
    
    /* Constructors*/
    public NodeRIPK1() {
        super("RIPK1", 1, 0.0);
        /* Complex Formation */
        List<NodeModification> nodeModifications = new ArrayList<>();
        nodeModifications.add(new NodeModification("ComplexI", 0.0, 0.0));
        nodeModifications.add(new NodeModification("ComplexII", 0.0, 0.0));   
        super.setNodeModifications(nodeModifications);
    }
}
