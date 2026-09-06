package practice.singleton.part4.practice5;

public class ApplicationConfig {
    private final String applicationName;
    private final String environment;
    private final String version;

    private ApplicationConfig() {
        applicationName = "BankingApp";
        environment = "PROD";
        version = "1.0";
    }

    private static class Holder {
        private static final ApplicationConfig INSTANCE = new ApplicationConfig();
    }

    public static ApplicationConfig getInstance() {
        return Holder.INSTANCE;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getVersion() {
        return version;
    }

    public void printConfig() {
        System.out.println("Application: " + applicationName);
        System.out.println("Environment: " + environment);
        System.out.println("Version: " + version);
    }
}