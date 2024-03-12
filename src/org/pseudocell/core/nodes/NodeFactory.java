/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.core.nodes;

/**
 *
 * @author ViníciusPierdoná
 */
public class NodeFactory {

    public Node createNode(String name) {
        Node node = new Node(name);
        return node;
    }

    public Node createNode(String name, Double status) {
        Node node = new Node(name, 1, status);
        return node;
    }

    public Node createNode(String name, Double status, Double restingStatus) {
        Node node = new Node(name, 1, status, restingStatus);
        return node;
    }

    public Metabolite createMetabolite(String name, double status, Double income, Double minValue, Double maxValue) {
        Metabolite node = new Metabolite(name, status, income, minValue, maxValue);
        return node;
    }

    public Node createMiRNA(String name) {
        Node node = new Node(name, 4, 0.0);
        return node;
    }

    public Node createMiRNA(String name, Double status, Double restingStatus) {
        Node node = new Node(name, 4, status, restingStatus);
        return node;
    }

    public Node createDrug(String name) {
        Node node = new Node(name, 5, 0.0);
        return node;
    }

    public Node createDrug(String name, Double status, Double restingStatus) {
        Node node = new Node(name, 5, status, restingStatus);
        return node;
    }

    public Node createGeneralNode(String name) {
        Node node = new Node(name, 3, 0.0);
        return node;
    }

    public Node createGeneralNode(String name, Double status) {
        Node node = new Node(name, 3, status);
        return node;
    }

    public Node createGeneralNode(String name, Double status, Double restingStatus) {
        Node node = new Node(name, 3, status, restingStatus);
        return node;
    }

    public Node createP53() {
        Node node = new NodeP53();
        return node;
    }

    public Node createBCL2() {
        Node node = new NodeBCL2();
        return node;
    }

    public Node createPP2A() {
        Node node = new NodePP2A();
        return node;
    }

    public Node createRIPK1() {
        Node node = new NodeRIPK1();
        return node;
    }

}
