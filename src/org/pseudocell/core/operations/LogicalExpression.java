package org.pseudocell.core.operations;

import java.util.HashMap;
import java.util.Map;

import org.pseudocell.core.operations.LogicalOperation.Operands;

/**
 *
 * Represents and resolves a mathematical formula. It's also possible to use
 * parenthesis.
 * <p>
 * The formula can have spaces; this class cleans it before start parsing.
 * There's a especial operator 'random'. To use it: 'rnd(42)', this results in a
 * value between 0 and 41.99.
 *
 * Adapted by ViníciusPierdoná from the Towel project, developed by:
 *
 * @author Marcos A. Vasconcelos Junior Available in:
 * https://github.com/MarkyVasconcelos/Towel/wiki/Expression
 */
public class LogicalExpression {

    private String expression = null;
    private Map<String, Double> variables = new HashMap<String, Double>();

    /**
     * Creates an empty Expression. You need to use
     * {@link #setExpression(String)} to assign a math expression string to.
     */
    public LogicalExpression() {
        // do nothing
    }

    /**
     * Creates an Expression and assigns the math expression string.
     *
     * @param s the expression string
     */
    public LogicalExpression(String s) {
        setExpression(s);
    }

    /**
     * Adds a variable and its value in the Expression.
     * <p>
     * Something like this can be done:
     *
     * <pre>
     * Expression e = new Expression(&quot;(x+4)*x&quot;);
     * e.setVariable(&quot;x&quot, 7);
     * </pre>
     *
     * @param v the variable name
     * @param val the variable value
     */
    public void setVariable(String v, double val) {
        variables.put(v, val);
    }

    /**
     * Sets the expression.
     *
     * @param s the expression string
     */
    public void setExpression(String s) {
        expression = s;
    }

    /**
     * Resolve and returns the numerical value of this expression.
     *
     * @return the expression value
     */
    public Double resolve() {
        if (expression == null) {
            return null;
        }
        try {
            return evaluate(new OperationParticle(this));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Double evaluate(OperationParticle n) {
        if (n.hasOperator() && n.hasChild()) {
            if (n.getOperator().getType() == Operands.SINGLE) {
                n.setValue(n.getOperator().resolve(evaluate(n.getLeft()), null));
            } else if (n.getOperator().getType() == Operands.DOUBLE) {
                n.setValue(n.getOperator().resolve(evaluate(n.getLeft()),
                        evaluate(n.getRight())));
            }
        }
        return n.getValue();
    }

    /**
     * *
     * Gets the variable's value.
     *
     * @param s the variable's name
     * @return the variable's value
     */
    public Double getVariable(String s) {
        return variables.get(s);
    }

    /**
     * Converts a string to a double or, if it's not possible, returns the value
     * of the variable with the given name.
     *
     * @param s the string value or the variable name
     * @return the double value
     */
    public Double getDouble(String s) {
        if (s == null) {
            return null;
        }
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return getVariable(s);
        }
    }

    /**
     * @return a string representation of this expression
     */
    public String getExpression() {
        return expression;
    }
}
