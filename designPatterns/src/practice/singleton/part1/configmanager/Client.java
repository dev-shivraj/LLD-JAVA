package practice.singleton.part1.configmanager;

public class Client {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        System.out.println(config1.getApplicationName());
        System.out.println(config1.getEnvironment());

        System.out.println(config1 == config2);
    }
}