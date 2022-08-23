/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.components;

import java.awt.Component;
import java.util.Locale;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import org.pseudocell.core.nodes.Node;

/**
 *
 * @author ViníciusPierdoná
 */
public class JListNodeCellRender extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (renderer instanceof JLabel && value instanceof Node) {
            ((JLabel) renderer).setText("[Node] " + ((Node) value).getName());
        }
        return this;
    }
}
