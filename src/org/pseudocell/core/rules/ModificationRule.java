/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.rules;

/**
 *
 * @author ViníciusPierdoná
 */
public class ModificationRule extends Rule{

    public ModificationRule(String ruleString, String modification, Double nodeStatus) {
        super(ruleString, nodeStatus);
        super.setModification(modification);
    }   
    
}
