package practice.factory.base.vectorClient;


public class OpenAiVectorClient implements AiVectorClient {
    @Override
    public void embedd(String prompt) {
        System.out.println("Vector embedding from Open AI");
    }
}
