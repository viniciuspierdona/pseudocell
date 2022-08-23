/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.pseudocell.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author ViniciusPierdona
 */
public class ConfigNodeStimulation {
    
    private final String configFileName = "nodeStimulation.config";
    
    public String stimulatedNode;
    public Integer stimulatedNodeFrequency;
    
    public ConfigNodeStimulation() {
        stimulatedNode = "";
        stimulatedNodeFrequency = 10;
        saveConfigs();
    }
    
    public void loadConfigs() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(configFileName)) {
            prop.load(fis);
            stimulatedNode = prop.getProperty("stimulatedNode","").trim();
            stimulatedNodeFrequency = Integer.valueOf(prop.getProperty("stimulatedNodeFrequency","10").trim());
            
        } catch (FileNotFoundException ex) {
            System.err.println("[ERROR] File not found. \n"+ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.err.println("[ERROR] Exception when opening file. \n"+ex.getLocalizedMessage());
        } 
    }
    
    public void loadConfigs(File file) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);
            stimulatedNode = prop.getProperty("stimulatedNode","").trim();
            stimulatedNodeFrequency = Integer.valueOf(prop.getProperty("stimulatedNodeFrequency","10").trim());
            
        } catch (FileNotFoundException ex) {
            System.err.println("[ERROR] File not found. \n"+ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.err.println("[ERROR] Exception when opening file. \n"+ex.getLocalizedMessage());
        } 
    }
    
    public boolean saveConfigs(){
        Properties prop = new Properties();
        try (FileOutputStream fos = new FileOutputStream(configFileName)) {
            prop.put("stimulatedNode", stimulatedNode);
            prop.put("stimulatedNodeFrequency", stimulatedNodeFrequency.toString());          
            prop.store(fos,null);
            return true;  
        } catch (FileNotFoundException ex) {
            System.err.println("[ERROR] File not found. \n"+ex.getLocalizedMessage());
            return false;
        } catch (IOException ex) {
            System.err.println("[ERROR] Exception when opening the file. \n"+ex.getLocalizedMessage());
            return false;
        }         
    }
    
    public boolean saveConfigs(File file){
        Properties prop = new Properties();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            prop.put("stimulatedNode", stimulatedNode);
            prop.put("stimulatedNodeFrequency", stimulatedNodeFrequency.toString());          
            prop.store(fos,null);
            return true;  
        } catch (FileNotFoundException ex) {
            System.err.println("[ERROR] File not found. \n"+ex.getLocalizedMessage());
            return false;
        } catch (IOException ex) {
            System.err.println("[ERROR] Exception when opening the file. \n"+ex.getLocalizedMessage());
            return false;
        }         
    }
    
    @Override
    public String toString() {
        return "Configs{" + "configFileName=" + configFileName +
                ",\n stimulatedNode=" + stimulatedNode +
                ",\n stimulatedNodeFrequency=" + stimulatedNodeFrequency + '}';
    }
    
}
