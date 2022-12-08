package com.nespresso.selenium.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyConfiguration {
    Properties properties;
    private static final String CONFIGURATIONS_PROPERTIES = "./configurations/configurations.properties";

    public PropertyConfiguration() {
        File file = new File(CONFIGURATIONS_PROPERTIES);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception exception) {
            System.out.println("Exception occurred while loading property files with message : " + exception.getMessage());
        }
    }

    public String getUsername() {
        return this.properties.getProperty("username");
    }

    public String getPassword() {
        return this.properties.getProperty("password");
    }

    public String getBaserUrl() {
        return this.properties.getProperty("baseUrl");
    }
}
