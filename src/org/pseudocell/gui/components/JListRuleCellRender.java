/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.components;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.rules.Rule;
import org.pseudocell.gui.utils.RuleSummary;

/**
 *
 * @author ViníciusPierdoná
 */
public class JListRuleCellRender extends DefaultListCellRenderer {
    
    RuleSummary ruleSummary = new RuleSummary();

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (renderer instanceof JLabel && value instanceof Rule) {
            ((JLabel) renderer).setText(ruleSummary.listRule((Rule) value));
        }
        return this;
    }

}
