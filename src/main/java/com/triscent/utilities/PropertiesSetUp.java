package com.triscent.utilities;

import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

import static java.nio.file.Paths.get;

public abstract class PropertiesSetUp {

    protected static Properties properties;

    protected static final String RESOURCEPATH= System.getProperty("user.dir")+ File.separator+"src"+File.separator
                        +"main"+File.separator+"resources"+File.separator;


    protected static void setUpProperties(String fileName){
         properties = new Properties();
         if(!fileName.endsWith(".properties"))
             try {
                 throw new Exception("Invalid File Format.");
             } catch (Exception e) {
                 e.printStackTrace();
             }
        try (InputStream inputStream = new FileInputStream(new File(RESOURCEPATH+fileName))) {
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}