/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.components;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author ViníciusPierdoná adapted from Chris Watts
 */
public class JSpinnerDouble extends JSpinner {

    private static final double STEP_SIZE = 0.1;

    private SpinnerNumberModel model;

    public JSpinnerDouble() {
        super();
        model = new SpinnerNumberModel(0.0, 0.00, 1000.0, STEP_SIZE);
        this.setModel(model);

        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Double value = getDouble();
                long magnitude = Math.round(Math.log10(value));
                double stepSize = STEP_SIZE * Math.pow(10, magnitude);
                model.setStepSize(stepSize);
            }
        });
    }

    /**
     * Returns the current value as a Double
     */
    public Double getDouble() {      
        return (Double) getValue();
    }

}
