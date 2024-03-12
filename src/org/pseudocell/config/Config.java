/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Config class manages the configuration settings for the pseudoCell application.
 * It provides methods to load and save configurations from/to a properties file.
 *
 * @author GuilhermeBorges and ViníciusPierdoná
 */
package org.pseudocell.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * The Config class holds configuration settings for the pseudoCell application.
 */
public final class Config {
    
    // Constants for network source types
    public static final String NETWORK_SOURCE_TYPE_DEFAULT = "default";
    public static final String NETWORK_SOURCE_TYPE_XML = "xml";
    public static final String NETWORK_SOURCE_TYPE_SQL = "sql";
    
    // Constants for node types
    public static final String NODE_TYPE_DEFAULT = "default";
    public static final String NODE_TYPE_GENERAL = "general";
    public static final String NODE_TYPE_MIRNA = "miRNA";
    public static final String NODE_TYPE_METABOLITE = "metabolite";
    public static final String NODE_TYPE_DRUG = "drug";
    public static final String NODE_TYPE_BCL2 = "BCL2";
    public static final String NODE_TYPE_RIPK1 = "RIPK1";
    public static final String NODE_TYPE_P53 = "P53";
    public static final String NODE_TYPE_PP2A = "PP2A";
    
    public static SimpleDateFormat dateFormat;
    
    // Configuration properties
    public Date lastUpdate;
    public String configFileName = "pseudoCell.config";
    public String projectName;
    public String networkSourceInputType;
    public String networkSourceFileName;
    private String stringDateFormat;
    public String stimulatedNode;
    public Integer numberOfNetworks;
    public Integer numberOfTicks;
    public Integer numberOfSamples;
    public Integer stimulatedNodeFrequency;
    
    /**
     * Default constructor initializes default configuration settings and saves them.
     */
    public Config() {
        stringDateFormat = "yyyy-MM-dd HH:mm";
        Config.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        lastUpdate = new Date();
        projectName = "newProject";
        networkSourceInputType = NETWORK_SOURCE_TYPE_DEFAULT;
        networkSourceFileName = "networkNodes.xml";
        numberOfNetworks = 10;
        numberOfTicks = 1000;
        numberOfSamples = 30;
        stimulatedNode = "";
        stimulatedNodeFrequency = 10;
//        loadConfigs();
        saveConfigs();
    }
    
    /**
     * Loads configuration settings from the default configuration file.
     */
    public void loadConfigs(){
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(configFileName)) {
            prop.load(fis);
            
            lastUpdate = dateFormat.parse(prop.getProperty("lastUpdate","2022-07-28 18:00").trim());
            projectName = prop.getProperty("projectName", "newProject").trim();
            networkSourceInputType = prop.getProperty("networkSourceInputType", NETWORK_SOURCE_TYPE_DEFAULT).trim();            
            networkSourceFileName = prop.getProperty("networkSourceFileName", "networkNodes.xml").trim();
            numberOfNetworks = Integer.valueOf(prop.getProperty("numberOfNetworks","10").trim());
            numberOfTicks = Integer.valueOf(prop.getProperty("numberOfTicks","100").trim());
            numberOfSamples = Integer.valueOf(prop.getProperty("numberOfSamples","30").trim());
            stringDateFormat = prop.getProperty("dateFormat", "yyyy-MM-dd HH:mm").trim();
            stimulatedNode = prop.getProperty("stimulatedNode","").trim();
            stimulatedNodeFrequency = Integer.valueOf(prop.getProperty("stimulatedNodeFrequency","10").trim());
            
            Config.dateFormat = new SimpleDateFormat(stringDateFormat);
        } catch (FileNotFoundException ex) {
            System.err.println("[ERROR] File not found. \n"+ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.err.println("[ERROR] Exception when opening file. \n"+ex.getLocalizedMessage());
        } catch (ParseException ex) {
            System.err.println("[ERROR] Error converting property. \n"+ex.getLocalizedMessage());
        } 
       
    }
    
    /**
     * Loads configuration settings from a specified file.
     *
     * @param file The file from which to load configurations.
     */
    public void loadConfigs(File file){
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);
            
            lastUpdate = dateFormat.parse(prop.getProperty("lastUpdate","2022-01-18 18:00").trim());
            projectName = prop.getProperty("projectName", "newProject").trim();
            networkSourceInputType = prop.getProperty("networkSourceInputType", NETWORK_SOURCE_TYPE_DEFAULT).trim();       
            networkSourceFileName = prop.getProperty("networkSourceFileName", "networkNodes.xml").trim();
            numberOfNetworks = Integer.valueOf(prop.getProperty("numberOfNetworks","10").trim());
            numberOfTicks = Integer.valueOf(prop.getProperty("numberOfTicks","100").trim());
            numberOfSamples = Integer.valueOf(prop.getProperty("numberOfSamples","30").trim());
            stringDateFormat = prop.getProperty("dateFormat", "yyyy-MM-dd HH:mm").trim();
            stimulatedNode = prop.getProperty("stimulatedNode","").trim();
            stimulatedNodeFrequency = Integer.valueOf(prop.getProperty("stimulatedNodeFrequency","10").trim());
            
            Config.dateFormat = new SimpleDateFormat(stringDateFormat);
        } catch (FileNotFoundException ex) {
            System.err.println("[ERROR] File not found. \n"+ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.err.println("[ERROR] Exception when opening file. \n"+ex.getLocalizedMessage());
        } catch (ParseException ex) {
            System.err.println("[ERROR] Error converting property. \n"+ex.getLocalizedMessage());
        } 
       
    }

    /**
     * Returns a string representation of the Config object.
     *
     * @return String representation of the Config object.
     */
    @Override
    public String toString() {
        return "Configs{" + "lastUpdate=" + dateFormat.format(lastUpdate) + 
                ",\n configFileName=" + configFileName +
                ",\n projectName=" + projectName +
                ",\n networkSourceInputType=" + networkSourceInputType + 
                ",\n networkSourceFileName=" + networkSourceFileName + 
                ",\n numberOfNetworks=" + numberOfNetworks + 
                ",\n numberOfTicks=" + numberOfTicks + 
                ",\n numberOfSamples=" + numberOfSamples + 
                ",\n stimulatedNode=" + stimulatedNode +
                ",\n stimulatedNodeFrequency=" + stimulatedNodeFrequency + '}';
    }

    /**
     * Saves configuration settings to the default configuration file.
     *
     * @return True if saving is successful, false otherwise.
     */
    public boolean saveConfigs() {
        Properties prop = new Properties();
        try (FileOutputStream fos = new FileOutputStream(configFileName)) {
            prop.put("lastUpdate", dateFormat.format(lastUpdate));
            prop.put("dateFormat", stringDateFormat);
            prop.put("projectName", projectName);
            prop.put("networkSourceInputType", networkSourceInputType);
            prop.put("networkSourceFileName", networkSourceFileName);
            prop.put("numberOfNetworks", numberOfNetworks.toString());
            prop.put("numberOfTicks", numberOfTicks.toString());
            prop.put("numberOfSamples", numberOfSamples.toString());   
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
    
    /**
     * Saves configuration settings to a specified file.
     *
     * @param file The file to which configurations should be saved.
     * @return True if saving is successful, false otherwise.
     */
    public boolean saveConfigs(File file) {
        Properties prop = new Properties();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            prop.put("lastUpdate", dateFormat.format(lastUpdate));
            prop.put("dateFormat", stringDateFormat);
            prop.put("projectName", projectName);
            prop.put("networkSourceInputType", networkSourceInputType);
            prop.put("networkSourceFileName", networkSourceFileName);
            prop.put("numberOfNetworks", numberOfNetworks.toString());
            prop.put("numberOfTicks", numberOfTicks.toString());
            prop.put("numberOfSamples", numberOfSamples.toString());
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
    
    
}
