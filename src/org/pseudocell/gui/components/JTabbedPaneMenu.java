/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.synth.Region;
import javax.swing.plaf.synth.SynthConstants;
import javax.swing.plaf.synth.SynthContext;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.plaf.synth.SynthStyle;

/**
 *
 * @author ViníciusPierdoná
 */
public class JTabbedPaneMenu extends JTabbedPane {

    private boolean componentConstructed = false;

    public JTabbedPaneMenu() {
        super();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (!componentConstructed) {
                    initTabWidth();
                    componentConstructed = true;
                }
            }
        });
    }

    /**
     * Returns the tab's <code>Insets</code>.
     *
     * @return an <code>Insets</code> object with tab boundaries.
     */
    private Insets getTabInsets() {
        Insets insets = UIManager.getInsets("TabbedPane.tabInsets");
        if (insets != null) {
            return insets;
        } else {
            SynthStyle style = SynthLookAndFeel.getStyle(this, Region.TABBED_PANE_TAB);
            SynthContext context = new SynthContext(this, Region.TABBED_PANE_TAB, style, SynthConstants.ENABLED);
            return style.getInsets(context, null);
        }
    }

    /**
     * Returns the <code>Insets</code> of the tab area.
     *
     * @return an <code>Insets</code> object with the boundaries of the tab
     * area.
     */
    private Insets getTabAreaInsets() {
        Insets insets = UIManager.getInsets("TabbedPane.tabAreaInsets");
        if (insets != null) {
            return insets;
        } else {
            SynthStyle style = SynthLookAndFeel.getStyle(this, Region.TABBED_PANE_TAB_AREA);
            SynthContext context = new SynthContext(this, Region.TABBED_PANE_TAB_AREA, style, SynthConstants.ENABLED);
            return style.getInsets(context, null);
        }
    }

    /**
     * Sets the width of the tab.
     */
    private void initTabWidth() {
        int tabCount = getTabCount();
        if (tabCount == 0) {
            return;
        }
        Insets tabInsets = this.getTabInsets();
        Insets tabAreaInsets = this.getTabAreaInsets();
        Insets insets = getInsets();

        int areaWidth = getWidth() - tabAreaInsets.left - tabAreaInsets.right - insets.left - insets.right;
        int tabWidth = areaWidth / 4;
        int gap = 0;

        // Sets the width of the tab
        tabWidth = tabWidth - tabInsets.left - tabInsets.right - 50;
        for (int i = 0; i < tabCount; i++) {
            JLabel label = (JLabel) getTabComponentAt(i);
            if (label == null) {
                break;
            }
            label.setPreferredSize(new Dimension(tabWidth + (i < gap ? 1 : 0), label.getPreferredSize().height));
        }
    }

    /**
     * Repaint the component.
     */
    @Override
    public synchronized void repaint() {
        initTabWidth();
        super.repaint();
    }

    /**
     * Inserts a new tab in the tabbed panel.
     *
     * @param title
     * @param icon
     * @param component
     * @param tooltip
     * @param index
     */
    @Override
    public void insertTab(String title, Icon icon, Component component, String tooltip, int index) {
        super.insertTab(title, icon, component, tooltip == null ? title : tooltip, index);
        JLabel label = new JLabel(title, JLabel.RIGHT);
        label.putClientProperty( "FlatLaf.styleClass", "h2.regular" );
        Dimension dim = label.getPreferredSize();
        Insets tabInsets = getTabInsets();
        label.setPreferredSize(new Dimension(0, dim.height + tabInsets.top + tabInsets.bottom));
        setTabComponentAt(index, label);
    }

}
