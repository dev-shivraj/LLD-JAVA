package practice.singleton.part1.appconfig;

public class ConfigClient {
    public static void main(String[] args) {
        ApplicationConfig config1 = ApplicationConfig.getInstance();
        ApplicationConfig config2 = ApplicationConfig.getInstance();

        System.out.println(config1.getApplicationName());
        System.out.println(config1.getEnvironment());

        System.out.println(config1 == config2);
    }
}