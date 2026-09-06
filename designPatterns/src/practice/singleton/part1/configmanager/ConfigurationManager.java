package practice.singleton.part1.configmanager;

public class ConfigurationManager {
    private static ConfigurationManager instance = new ConfigurationManager();

    private String applicationName;
    private String environment;

    private ConfigurationManager() {
        applicationName = "My Application";
        environment = "Development";
    }

    public static ConfigurationManager getInstance() {
        return instance;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getEnvironment() {
        return environment;
    }
}