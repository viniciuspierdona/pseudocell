/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.components;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import org.pseudocell.core.nodes.NodeModification;

/**
 *
 * @author ViníciusPierdoná
 */
public class JComboBoxModCellRender extends DefaultListCellRenderer {

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (renderer instanceof JLabel && value instanceof NodeModification) {
            ((JLabel) renderer).setText(((NodeModification) value).getName());
        }
        return this;
    }
}