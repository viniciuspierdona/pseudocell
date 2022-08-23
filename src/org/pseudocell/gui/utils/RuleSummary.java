/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.utils;

import java.util.ArrayList;
import java.util.List;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.rules.MetabolicRule;
import org.pseudocell.core.rules.ModificationRule;
import org.pseudocell.core.rules.Rule;

/**
 *
 * @author ViníciusPierdoná
 */
public class RuleSummary {

    Rule rule;

    public List<String> listRules(Node node) {
        List<String> returnList = new ArrayList<>();
        for (int i = 0; i < node.getRules().size(); i++) {
            rule = node.getRules().get(i);
            String ruleString = "";
            if (rule instanceof MetabolicRule) {
                ruleString = "[Metabolic Rule]   " + cleanRuleString(rule.getRuleString());
            } else if (rule instanceof ModificationRule) {
                ruleString = "[Modification Rule]   " + cleanRuleString(rule.getRuleString());
            } else {
                ruleString = "[Rule]   " + cleanRuleString(rule.getRuleString());
            }
            returnList.add(ruleString);
        }
        return returnList;
    }

    public String listRule(Rule rule) {
        String ruleString = "";
        if (rule instanceof MetabolicRule) {
            ruleString = "[Metabolic Rule]   " + cleanRuleString(rule.getRuleString());
        } else if (rule instanceof ModificationRule) {
            ruleString = "[Modification Rule]   " + cleanRuleString(rule.getRuleString());
        } else {
            ruleString = "[Rule]   " + cleanRuleString(rule.getRuleString());
        }
        return ruleString;
    }

    public String cleanRuleString(String ruleString) {
//        ruleString = ruleString.replace("Node:", "");
//        ruleString = ruleString.replace(";", " ");
        ruleString = ruleString.replaceAll("[&|]", " $0 ");
        ruleString = ruleString.replaceAll("\\|", "OR");
        ruleString = ruleString.replaceAll("&", "AND");
        ruleString = ruleString.replaceAll("[<>=]+", " $0 ");
        return ruleString;
    }

}
