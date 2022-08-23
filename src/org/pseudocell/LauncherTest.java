/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.pseudocell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.pseudocell.core.Network;
import org.pseudocell.core.NetworkFactory;
import org.pseudocell.core.Pseudocell;
import org.pseudocell.core.nodes.DefaultNodesBuilder;
import org.pseudocell.core.nodes.Metabolite;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.nodes.NodeBCL2;
import org.pseudocell.core.nodes.NodeFactory;
import org.pseudocell.core.rules.Rule;
import org.pseudocell.core.operations.LogicalExpression;
import org.pseudocell.core.operations.RelationalOperation;
import org.pseudocell.core.rules.MetabolicRule;
import org.pseudocell.core.rules.ModificationRule;
import org.pseudocell.config.Config;

/**
 *
 * @author ViníciusPierdoná
 */
public class LauncherTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        System.out.println("Hello World!");
//        Network net = new Network();
//        net.createDefaultNodes();
//        for (Node n : net.getDefaultNodes()) {
//            System.out.println(n.getName() + n.getStatus());
//        }
//        net.update();
//        for (Node n : net.getDefaultNodes()) {
//            System.out.println(n.getName() + n.getStatus());
//        }        
//        for (int i = 0; i<=10; i++){ 
//            System.out.println("Tick:" + i);
//            for (Node n : net.getDefaultNodes()) {
//                System.out.println(n.getName() + " " + n.getStatus());
//            } 
//            net.update();
//        }
//        LogicalExpression exp = new LogicalExpression("(x+x+x)*5");  
//        exp.setVariable("x", 3);  
//        double result = exp.resolve(); 
//        System.err.println(result);
//        
//        LogicalExpression exp = new LogicalExpression("(x | y) & (z | k)");
//        exp.setVariable("x",1);
//        exp.setVariable("y",1);
//        exp.setVariable("z",2);
//        exp.setVariable("k",1);
//        double result = exp.resolve();
//        System.err.println(result);
        RelationalOperation relationalOperation;
//        relationalOperation = new RelationalOperation("2 == 2");
//        System.err.println(relationalOperation.resolve());

//        Rule r1 = new Rule("NodeATM#>=1|((NodeBCL2#>2&NodeTHY#==0))", 2.0);
//        Rule r2 = new Rule("NodeATF#>=2&NodeP53#==0", 1.0);
//        Rule r3 = new Rule("NodePPK2LA3F#==1", 0.0);
//        List<Rule> rules = new ArrayList<>();
//        rules.add(r2);
//        rules.add(r3);
//        rules.add(r1);
//        for (int i = 0; i < rules.size(); i++){
//            System.err.println(rules.get(i).getRuleString());
//        }
//        Node n = new Node(1, "A");
//        n.setRules(rules);
//        for (Rule r : n.getRules()){
//            System.err.println(r.getRuleString());
//        }
//        LogicalExpression logicalExpression;
//        for (Rule r : n.getRules()){
//            String resultString = "";
//            //Creates an array separating the parentheses and logical operators from the relational operations
//            String ruleString[] = r.getRuleString().split("(?<=[()&|])|(?=[()&|])");
//            // Replaces all occurrences of nodes within a logic rule with the state value of those nodes
//            for (int i = 0; i < ruleString.length; i++) {
//                String currentString = ruleString[i];
//                // Checks if the current rule fragment is a relational operation
//                if (currentString.startsWith("Node")){
//                    int firstIndex = currentString.indexOf("Node") + 4;
//                    int lastIndex = currentString.indexOf("#");
//                    String targetNode = currentString.substring(firstIndex, lastIndex);
//                    ruleString[i] = ruleString[i].replace("Node"+targetNode+"#", "1");
//                    // Solves the relational operation and replaces the expression with the result: 1 (true) or 0 (false)
//                    relationalOperation = new RelationalOperation(ruleString[i]);
//                    ruleString[i] = String.valueOf(relationalOperation.resolve());
//                }
//                resultString = resultString + ruleString[i];
//            }
//            System.out.println(resultString);
//            logicalExpression = new LogicalExpression(resultString);            
//            Double nodeStatus = logicalExpression.resolve();
//            System.out.println(nodeStatus);
//        }
//        
//        for (Rule r : n.getRules()){
//            String ruleString = r.getRuleString();
//            for (int i = 0; i <= StringUtils.countMatches(ruleString, "Node"); i++) {
//                int firstIndex = ruleString.indexOf("Node") + 4;
//                int lastIndex = ruleString.indexOf("#");
//                String node = ruleString.substring(firstIndex, lastIndex);
//                
//                ruleString = ruleString.replace("Node"+node+"#", "1");           
//                System.err.println(node);
//            }
//            System.err.println(ruleString);
//        }
        //A
        Node A = new Node("A");
        Rule r3 = new Rule("Mod:BCL2#Thr56;>=1|Node:MetC#>=2", 1.0);
        List<Rule> rules = new ArrayList<>();
        rules.add(r3);
        A.setRules(rules);
        // B
        Node B = new Node("B");
        Rule r2 = new Rule("Node:E#>=1", 2.0);
        Rule r1 = new Rule("Node:A#>=1", 1.0);
        List<Rule> rules1 = new ArrayList<>();
        rules1.add(r2);
        rules1.add(r1);
        B.setRules(rules1);
        // C
        Node C = new Node("C");
        r1 = new Rule("Node:B#==0|Node:D#>=1", 1.0);
        List<Rule> rules2 = new ArrayList<>();
        rules2.add(r1);
        C.setRules(rules2);

        // D
        Node D = new Node("D");
        r1 = new Rule("Node:B#>=1", 1.0);
        List<Rule> rules3 = new ArrayList<>();
        rules3.add(r1);
        D.setRules(rules3);

        // E
        Node E = new Node("E");
        r1 = new Rule("Node:C#>=1", 1.0);
        List<Rule> rules4 = new ArrayList<>();
        rules4.add(r1);
        E.setRules(rules4);
        
        // X
        Node X = new NodeBCL2();
        r1 = new Rule("Node:C#>=1&Node:B#<2", 1.0);
        ModificationRule mod1 = new ModificationRule("Node:E#>=1", "Thr56", 1.0);
        ModificationRule mod2 = new ModificationRule("Node:D#>=1", "Thr69", 0.0);
        List<Rule> rules5 = new ArrayList<>();
        rules5.add(r1);
        rules5.add(mod1);
        rules5.add(mod2);
        X.setRules(rules5);
        
        // MetA
        Metabolite MetA = new Metabolite("MetA", 1, 0.2, 0.0, 2.0);
        List<Rule> metARules = new ArrayList<>();
        // MetB
        Metabolite MetB = new Metabolite("MetB", 0, 0.0, 0.0, 3.0);
        List<Rule> metBRules = new ArrayList<>();
        // MetC
        Metabolite MetC = new Metabolite("MetC", 0, 0.0, 0.0, 2.0);
        List<Rule> metCRules = new ArrayList<>();
        //MetD
        Metabolite MetD = new Metabolite("MetD", 0, 0.0, 0.0, 2.0);
        List<Rule> metDRules = new ArrayList<>();
        
        // MetabolicRules
        // MetA Rules
        MetabolicRule mR1 = new MetabolicRule("Node:MetA#>=1", "MetA", "MetB", 1.0);
        metARules.add(mR1);
        MetA.setRules(metARules);
        // MetB Rules
        mR1 = new MetabolicRule("Node:B#>=1", "MetB", "MetC", 1.0);
        metBRules.add(mR1);
        MetB.setRules(metBRules);
        // MetC Rules
        mR1 = new MetabolicRule("Node:MetC#>=2", "MetC", "MetD", 0.5);
        MetabolicRule mR2 = new MetabolicRule("Node:MetC#>=1", "MetA", "MetB", 0.25);
        metCRules.add(mR1);
        metCRules.add(mR2);
        MetC.setRules(metCRules);
        


        List<Node> defaultNodes = new ArrayList<>();
        defaultNodes.add(A);
        defaultNodes.add(B);
        defaultNodes.add(C);
        defaultNodes.add(D);
        defaultNodes.add(E);
        defaultNodes.add(X);
        defaultNodes.add(MetA);
        defaultNodes.add(MetB);
        defaultNodes.add(MetC);
        defaultNodes.add(MetD);
        Network network = new Network(defaultNodes);
        Network network1 = network;
        Network network2 = network;
        Network network3 = network;
        Network network4 = network;
        List<Network> networks = new ArrayList<>();
        networks.add(network1);
        networks.add(network2);
        networks.add(network3);
        networks.add(network4);
        Pseudocell pseudocell = new Pseudocell(networks);
//        for (Node n : network.getDefaultNodes()) {
//            for (Rule r : n.getRules()) {
//                System.out.println("Node: " + n.getName() + " | Rule: " + r.getRuleString() + " - Status: " + r.getNodeStatus());
//            }
//        }
//
        network.getDefaultNodes().get(0).setStatus(1.0);
        for (int i = 0; i < 10; i++){
            System.out.println("Tick: "+i);

            pseudocell.update();
//            for (Node n : network.getDefaultNodes()) {
//                System.out.println(n.getId()+" | Node: "+n.getName()+" - Status: "+n.getStatus());
//            }
        }
        for (Double f : pseudocell.getMeanExpression()) {
                System.out.println(f);
        }
//
//        NodeFactory nodeFactory = new NodeFactory();
//        Node A = nodeFactory.createNode("A");
//        Node B = nodeFactory.createNode("B");
//        Node C = nodeFactory.createP53();
//        Node D = nodeFactory.createMiRNA("D");
//        Node E = nodeFactory.createNode("E");
//        
//        List<Node> nodes = new ArrayList<>();
//        nodes.add(A);
//        nodes.add(B);
//        nodes.add(C);
//        nodes.add(D);
//        nodes.add(E);
//        for (Node n : nodes) {
//            System.out.println("Node: " + n.getName() + " | ID: " + n.getId());
//        }
//        Config configurations = new Config();
//        DefaultNodesBuilder defaultNodesBuilder = new DefaultNodesBuilder();
//        NetworkFactory networkFactory = new NetworkFactory();
//        Network network = networkFactory.createNetwork(configurations);
//        for (int i = 0; i < 10; i++){
//            System.out.println("Tick: "+i);
//            network.update();
//        }        
    }
}
