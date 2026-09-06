package practice.singleton.part2.examples.configuration;

public class Client {
    public static void main(String[] args) {
        Configuration config1 = Configuration.getInstance();
        Configuration config2 = Configuration.getInstance();

        System.out.println(config1.getEnvironment());
        System.out.println(config1 == config2);
    }
}