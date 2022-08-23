/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.nodes;

/**
 *
 * @author ViníciusPierdoná
 */
public class Metabolite extends Node{
    private Double income, minValue, maxValue;
    
    /* Constructors */
    public Metabolite(String name, double status, Double income, Double minValue, Double maxValue) {
        super(name, 2, status);
        this.income = income;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    
    /* Getters and Setters */
    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }
    
    /* Methods */
    public void addIncome(){
        // The income can be a negative value. In this case, it checks if the addition of income does not reduce the 
        // status below the minimum value.
        if (super.getStatus() + this.income < this.minValue) {
            super.setStatus(this.minValue);
        } else if (super.getStatus() + this.income < this.maxValue){
            super.setStatus(super.getStatus() + this.income);
        } else {
            super.setStatus(this.maxValue);
        }
    }
    
}
