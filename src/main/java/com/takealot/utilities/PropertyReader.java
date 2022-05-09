package com.takealot.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    private static volatile PropertyReader propInstance;
    private PropertyReader() {
    }
    public static synchronized PropertyReader getInstance() {
        if (propInstance == null) {
            propInstance = new PropertyReader();
        }
        return propInstance;
    }
    public String getProperty(String propertyName) {

        Properties prop = new Properties();
        FileInputStream inputStreamFile = null;
        try {
            inputStreamFile = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/propertiesfile/config.properties");
            prop.load(inputStreamFile);
            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }
        } catch (Exception e) {
            System.out.println("Property file not found");
        }
        return null;
    }
}
