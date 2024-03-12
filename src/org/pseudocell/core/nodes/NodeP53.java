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
public class NodeP53 extends Node {

    /* Consctrutors */
    public NodeP53() {
        super("TP53", 1, 0.0);

        List<NodeModification> nodeModifications = new ArrayList<>();
        /* Phosphorilation sites */
        nodeModifications.add(new NodeModification("Ser15", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Thr18", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Ser20", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Ser33", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Ser37", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Ser46", 0.0, 0.0));
        // Acetylation sites
        //    Obs: Lys305 relates to acetylations of Lys305, Lys372, Lys373, Lys381, Lys382 and Lys386 */
        nodeModifications.add(new NodeModification("Lys120", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Lys164", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Lys305", 0.0, 0.0));
        nodeModifications.add(new NodeModification("Lys320", 0.0, 0.0));
        super.setNodeModifications(nodeModifications);
    }
}
