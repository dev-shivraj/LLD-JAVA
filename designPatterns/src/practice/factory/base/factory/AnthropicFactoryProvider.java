package practice.factory.base.factory;

public class AnthropicFactoryProvider implements AiClientFactoryProvider {

    @Override
    public boolean supports(String provider) {
        return "anthropic".equalsIgnoreCase(provider);
    }

    @Override
    public AiClientFactory createFactory() {
        return new AnthropicClientFactory();
    }
}