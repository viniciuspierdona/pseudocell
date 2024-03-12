/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.nodes;

/**
 *
 * @author ViníciusPierdoná
 */
public class NodeModification {

    private String name;
    private Double modificationStatus, restingStatus;

    /* Constructors */
    public NodeModification(String name, Double modificationStatus, Double restingStatus) {
        this.name = name;
        this.modificationStatus = modificationStatus;
        this.restingStatus = restingStatus;
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getModificationStatus() {
        return modificationStatus;
    }

    public void setModificationStatus(Double modificationStatus) {
        this.modificationStatus = modificationStatus;
    }

    public Double getRestingStatus() {
        return restingStatus;
    }

    public void setRestingStatus(Double restingStatus) {
        this.restingStatus = restingStatus;
    }

}
