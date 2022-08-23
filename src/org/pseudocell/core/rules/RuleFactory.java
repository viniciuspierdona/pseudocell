/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.rules;

import org.pseudocell.core.utils.StringUtil;

/**
 *
 * @author ViníciusPierdoná
 */
public class RuleFactory {
    
    public Rule createRule(String ruleString, Double nodeStatus) {
        ruleString = StringUtil.removeCharacters(ruleString, ' ');
        Rule rule = new Rule(ruleString, nodeStatus);
        return rule;
    }
    public Rule createMetabolicRule(String ruleString, String inputNode, String outputNode, Double conversionValue) {
        ruleString = StringUtil.removeCharacters(ruleString, ' ');
        MetabolicRule rule = new MetabolicRule(ruleString, inputNode, outputNode, conversionValue);
        return rule;
    }
    public Rule createModificationRule(String ruleString, String modification, Double nodeStatus) {
        ruleString = StringUtil.removeCharacters(ruleString, ' ');
        ModificationRule rule = new ModificationRule(ruleString, modification, nodeStatus);
        return rule;
    }
}
