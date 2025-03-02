package com.snhu.sslserver;

import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }
    
    public static String getKeystoreFile() {
        return properties.getProperty("keystore.file");
    }
    
    public static String getKeystoreAlias() {
        return properties.getProperty("keystore.alias");
    }

    public static String getKeystorePassword() {
        return properties.getProperty("keystore.password");
    }
    
    public static String getCertFile() {
        return properties.getProperty("cert.file");
    }
}
