/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.rules;

import java.util.List;
import org.pseudocell.core.nodes.Metabolite;
import org.pseudocell.core.nodes.Node;

/**
 *
 * @author ViníciusPierdoná
 */
public class MetabolicRule extends Rule {
    
    
    /* Constructors */
    public MetabolicRule(String ruleString, String inputNode, String outputNode, Double conversionValue) {
        super(ruleString, conversionValue);
        super.setInputNode(inputNode);
        super.setOutputNode(outputNode);
    }
    
}
