package practice.factory.base.factory;

public interface AiClientFactoryProvider {

    boolean supports(String provider);

    AiClientFactory createFactory();
}