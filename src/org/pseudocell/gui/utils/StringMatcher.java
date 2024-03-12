/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ViníciusPierdoná
 */
public class StringMatcher {
    
    Matcher matcher;
    Pattern pattern;
    
    public StringMatcher(){
    }
    
    public String findRelationalOperator(String ruleString){
        String relationalOperator = null;
        pattern = Pattern.compile("[<>=]+");
        matcher = pattern.matcher(ruleString);
        if (matcher.find()) {
            relationalOperator = ruleString.substring(matcher.start(), matcher.end());
        }
        return relationalOperator;
    }
    
    public String findLogicalOperator(String ruleString){
        String logicalOperator = null;
        pattern = Pattern.compile("[|&]");
        matcher = pattern.matcher(ruleString);
        if (matcher.find()) {
            logicalOperator = ruleString.substring(matcher.start(), matcher.end());
        }
        return logicalOperator;
    }
    
}
