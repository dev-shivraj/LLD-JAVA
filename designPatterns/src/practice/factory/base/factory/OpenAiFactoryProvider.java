package practice.factory.base.factory;

public class OpenAiFactoryProvider implements AiClientFactoryProvider {

    @Override
    public boolean supports(String provider) {
        return "openai".equalsIgnoreCase(provider);
    }

    @Override
    public AiClientFactory createFactory() {
        return new OpenAiClientFactory();
    }
}