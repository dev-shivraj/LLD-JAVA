package practice.factory.base.factory.simpleFactory;


import practice.factory.base.vectorClient.AiVectorClient;
import practice.factory.base.vectorClient.AnthropicVectorClient;
import practice.factory.base.vectorClient.OpenAiVectorClient;

public class VectorClientFactory {

    public static AiVectorClient getAiVectorClient(String providerName) {
        if(providerName.equals("openai")) {
            return new OpenAiVectorClient();
        }
        else if(providerName.equals("anthropic")) {
            return new AnthropicVectorClient();
        }
        throw new RuntimeException("Invalid provider");
    }
}
