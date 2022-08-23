/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.operations;

import java.util.Objects;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.utils.StringUtil;

/**
 *
 * @author ViníciusPierdoná
 */
public class RelationalOperation {
    private String expression;
    private Double value;
    
    /* Constructors */
    public RelationalOperation(String expression) {
        this.expression = expression;
    }
    
    /* Methods */
    public Double resolve(){
        
        expression = StringUtil.removeCharacters(expression, ' ');        
        String splitted[] = expression.split("[<>=]+");
        Double leftOperand = Double.parseDouble(splitted[0]);
        String operator = expression.replaceAll("\\d","");
        operator = operator.replaceAll("\\.","");
        Double rightOperand = Double.parseDouble(splitted[1].replaceAll("[^\\d.]", ""));
        Boolean result = false;
        switch(operator) {
            case "==" -> result = Objects.equals(leftOperand, rightOperand);
            case ">" -> result = leftOperand > rightOperand;
            case ">=" -> result = leftOperand >= rightOperand;
            case "<" -> result = leftOperand < rightOperand;
            case "<=" -> result = leftOperand <= rightOperand;
        }
        if(result){
            value = 1.0;
        } else {
            value = 0.0;
        }
        return value;
    }
}
