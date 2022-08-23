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
    String validationMessage, numCharAllowed;
    int maxCharacterAllowed;

    /* Constructor */
    public FieldValidation() {
        this.validationFlag = true;
        this.maxCharacterAllowed = 48;
        this.numCharAllowed = "0987654321";
    }

    /* Getters and Setters */
    public String getNumCharAllowed() {
        return numCharAllowed;
    }

    public int getMaxCharacterAllowed() {
        return maxCharacterAllowed;
    }


    /* Methods */
    public Boolean validateMandatoryTextField(JTextField textField, Frame frame) {
        this.validationFlag = true;
        if (textField.getName().equals("jTextFieldNPProjectName")) {
            // Checks if a name has been defined for the project
            if (textField.getText().length() == 0) {
                JOptionPane.showMessageDialog(frame, "[ERROR] It is necessary to define a name for the project.", "Error - Empty field", JOptionPane.ERROR_MESSAGE);
                validationFlag = false;
            }
            // Checks that the Project Name field does not have more characters than the maximum allowed 
            if (textField.getText().length() > maxCharacterAllowed) {
                JOptionPane.showMessageDialog(frame, "[ERROR] Project Name cannot be longer than " + maxCharacterAllowed + " characters", "Error - Field out of bounds", JOptionPane.ERROR_MESSAGE);
                validationFlag = false;
            }
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
        if (modificationComboBox.getItemCount()==0) {
            JOptionPane.showMessageDialog(frame, "[ERROR] This node has no modifications that can be associated with a rule", "Error - Modification Rule", JOptionPane.ERROR_MESSAGE);
            validationFlag = false;
        }
        return validationFlag;
    }
}
