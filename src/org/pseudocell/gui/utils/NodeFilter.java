/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.utils;

import java.util.List;
import javax.swing.DefaultListModel;
import org.pseudocell.core.nodes.Node;

/**
 *
 * @author ViníciusPierdoná
 */
public class NodeFilter {
//    
//    List<Node> displayedNodes = new ArrayList<>();

    public  DefaultListModel filterNodes(DefaultListModel listModel, List<Node> nodeList, String textInput) {
        // Clears the list of nodes in the listNCNodesList component of the Node Configuration screen
        if (!listModel.isEmpty()) {
            listModel.clear();
//           displayedNodes.clear();            
        }
        // Populates the list if no filter has been done
        if (textInput == null || textInput.isEmpty()) {
            for (Node n : nodeList) {
//                listModel.addElement("[Node] " + n.getName());
                listModel.addElement(n);
//                displayedNodes.add(n);
            }
        } else {
            // Apply filter
            for (Node n : nodeList) {
                if (n.getName().contains(textInput)) {
                    listModel.addElement(n);
//                    listModel.addElement("[Node] " + n.getName());
//                    displayedNodes.add(n);
                }
            }
        }
        return listModel;
    }

}
