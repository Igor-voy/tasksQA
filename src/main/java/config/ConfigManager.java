package config;

import java.io.FileReader;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;

    public ConfigManager(String configFile) {
        properties = new Properties();
        try {
            properties.load(new FileReader(configFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBrowserName() {
        return properties.getProperty("browser", "chrome");
    }

    public String getBaseUrl() {
        return properties.getProperty("base_url", "https://demoqa.com");
    }

    public int getTimeout() {
        String timeout = properties.getProperty("timeout", "10");
        return Integer.parseInt(timeout);
    }
}
