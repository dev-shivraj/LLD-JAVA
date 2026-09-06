package practice.singleton.part1.appconfig;

public class ApplicationConfig {
    private static ApplicationConfig instance = new ApplicationConfig();

    private String applicationName;
    private String environment;

    private ApplicationConfig() {
        applicationName = "Banking Application";
        environment = "PRODUCTION";
    }

    public static ApplicationConfig getInstance() {
        return instance;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getEnvironment() {
        return environment;
    }
}