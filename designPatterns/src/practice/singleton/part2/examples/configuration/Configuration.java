package practice.singleton.part2.examples.configuration;

public class Configuration {
    private Configuration() {
    }

    private static class Holder {
        private static final Configuration INSTANCE = new Configuration();
    }

    public static Configuration getInstance() {
        return Holder.INSTANCE;
    }

    public String getEnvironment() {
        return "PRODUCTION";
    }
}