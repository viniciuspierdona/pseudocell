/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.gui.validation;

import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.pseudocell.core.nodes.Node;
import org.pseudocell.core.nodes.NodeModification;

/**
 *
 * @author ViníciusPierdoná
 */
public class FieldValidation {

    Boolean validationFlag;
    String validationMessage, numCharAllowed, doubleCharAllowed;
    int maxCharacterAllowed;

    /* Constructor */
    public FieldValidation() {
        this.validationFlag = true;
        this.maxCharacterAllowed = 48;
        this.numCharAllowed = "0987654321";
        this.doubleCharAllowed = "0987654321.";
    }

    /* Getters and Setters */
    public String getNumCharAllowed() {
        return numCharAllowed;
    }

    public String getDoubleCharAllowed() {
        return doubleCharAllowed;
    }

    public int getMaxCharacterAllowed() {
        return maxCharacterAllowed;
    }


    /* Methods */
    public boolean validateMandatoryTextField(JTextField textField, Frame frame) {
        this.validationFlag = true;
        if (textField.getText().isBlank()) {
            JOptionPane.showMessageDialog(frame, "[ERROR] Mandatory field is blank:\n- " + textField.getName(), "Error - Empty field", JOptionPane.ERROR_MESSAGE);
            validationFlag = false;
        }
        return validationFlag;
    }

    public boolean validateMandatoryTextField(ArrayList<JTextField> textFields, Frame frame) {
        this.validationFlag = true;
        String message = "";
        for (JTextField textField : textFields) {
            if (textField.getText().isBlank()) {
                message += "- " + textField.getName() + "\n";
                validationFlag = false;
            }
        }
        if (!validationFlag) {
            JOptionPane.showMessageDialog(frame, "[ERROR] Mandatory field is blank:\n" + message, "Error - Empty field", JOptionPane.ERROR_MESSAGE);
        }
        return validationFlag;
    }
    
    public boolean validateMaxCharacters (JTextField textField, Frame frame){
        this.validationFlag = true;
        if (textField.getText().length() > maxCharacterAllowed) {
            JOptionPane.showMessageDialog(frame, "[ERROR] Field with more characters than allowed [" + maxCharacterAllowed + " characters limit]:\n- " + textField.getName(), "Error - Maximum number of characters extrapolated", JOptionPane.ERROR_MESSAGE);
            validationFlag = false;
        }
        return validationFlag;
    }
    
    public boolean validateMaxCharacters (ArrayList<JTextField> textFields, Frame frame){
        this.validationFlag = true;
        String message = "";
        for (JTextField textField : textFields) {
            if (textField.getText().length() > maxCharacterAllowed) {
                message += "- " + textField.getName() + "\n";
                validationFlag = false;
            }
        }
        if (!validationFlag) {
            JOptionPane.showMessageDialog(frame, "[ERROR] Field with more characters than allowed [" + maxCharacterAllowed + " characters limit]:\n" + message, "Error - Maximum number of characters extrapolated", JOptionPane.ERROR_MESSAGE);
        }
        return validationFlag;
    }

    public boolean validatePositiveIntegerTextField (ArrayList<JTextField> textFields, Frame frame) {
        this.validationFlag = true;
        String message = "";
        for (JTextField textField : textFields) {
            if (textField.getText().matches("[0-9]+") == false || Integer.valueOf(textField.getText()) <= 0) {
                message += "- " + textField.getName() + "\n";
                validationFlag = false;
            }
        }
        if (!validationFlag) {
            JOptionPane.showMessageDialog(frame, "[ERROR] The following fields accept only integers and positive numbers:\n" + message, "Error - Numeric field", JOptionPane.ERROR_MESSAGE);
        }
        return validationFlag;
    }
    
    public boolean validatePositiveDoubleTextField (ArrayList<JTextField> textFields, Frame frame) {
        this.validationFlag = true;
        String message = "";
        for (JTextField textField : textFields) {
            if (textField.getText().matches("-?(\\d*\\.)?\\d+") == false || Double.valueOf(textField.getText()) < 0) {
                message += "- " + textField.getName() + "\n";
                validationFlag = false;
            }
        }
        if (!validationFlag) {
            JOptionPane.showMessageDialog(frame, "[ERROR] The following fields accept only positive floar numbers:\n" + message, "Error - Numeric field", JOptionPane.ERROR_MESSAGE);
        }
        return validationFlag;
    }
    
    public boolean validateInputOutputNode(Node nodeInput, Node nodeOutput, Frame frame) {
        this.validationFlag = true;
        if (nodeInput.getName().equals(nodeOutput.getName())) {
            JOptionPane.showMessageDialog(frame, "[ERROR] Input and output node cannot be the same", "Error - Metabolic Rule", JOptionPane.ERROR_MESSAGE);
            validationFlag = false;
        }
        return validationFlag;
    }

    public boolean validateModificationComboBox(JComboBox<NodeModification> modificationComboBox, Frame frame) {
        this.validationFlag = true;
        if (modificationComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(frame, "[ERROR] This node has no modifications that can be associated with a rule", "Error - Modification Rule", JOptionPane.ERROR_MESSAGE);
            validationFlag = false;
        }
        return validationFlag;
    }
}
