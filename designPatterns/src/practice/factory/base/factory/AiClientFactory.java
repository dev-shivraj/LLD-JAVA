package practice.factory.base.factory;


import practice.factory.base.chatClients.AiChatClient;
import practice.factory.base.vectorClient.AiVectorClient;

// abstract factory
public interface AiClientFactory {

    AiChatClient getAiChatClient();
    AiVectorClient getAiVectorClient();
}
