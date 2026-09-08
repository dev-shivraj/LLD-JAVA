package practice.factory.base.factory;


import practice.factory.base.chatClients.AiChatClient;
import practice.factory.base.chatClients.OpenAiChatClient;
import practice.factory.base.vectorClient.AiVectorClient;
import practice.factory.base.vectorClient.OpenAiVectorClient;

public class OpenAiClientFactory implements AiClientFactory{
    @Override
    public AiChatClient getAiChatClient() {
        return new OpenAiChatClient();
    }

    @Override
    public AiVectorClient getAiVectorClient() {
        return new OpenAiVectorClient();
    }
}
