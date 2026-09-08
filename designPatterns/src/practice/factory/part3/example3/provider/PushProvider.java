package practice.factory.part3.example3.provider;

public class PushProvider {

    public void sendPush(String message) {
        System.out.println("Push Provider: Sending push -> " + message);
    }
}