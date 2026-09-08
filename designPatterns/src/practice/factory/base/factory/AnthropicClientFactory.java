package practice.factory.base.factory;

import practice.factory.base.chatClients.AiChatClient;
import practice.factory.base.chatClients.AnthropicChatClient;
import practice.factory.base.vectorClient.AiVectorClient;
import practice.factory.base.vectorClient.AnthropicVectorClient;

public class AnthropicClientFactory implements AiClientFactory{
    @Override
    public AiChatClient getAiChatClient() {
        return new AnthropicChatClient();
    }

    @Override
    public AiVectorClient getAiVectorClient() {
        return new AnthropicVectorClient();
    }
}
