package practice.factory.base.factory.simpleFactory;


import practice.factory.base.chatClients.AiChatClient;
import practice.factory.base.chatClients.AnthropicChatClient;
import practice.factory.base.chatClients.OpenAiChatClient;

public class ChatClientFactory {

    // simple factory method
    public static AiChatClient getAiChatClient(String providerName) {
        if(providerName.equals("openai")) {
            return new OpenAiChatClient();
        }
        else if(providerName.equals("anthropic")) {
            return new AnthropicChatClient();
        }
        throw new RuntimeException("Invalid provider");
    }
}
