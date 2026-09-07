package practice.registry.part3.practice1.sender;

public class PushSender implements NotificationSender {

    public PushSender() {
        System.out.println("Creating PushSender");
    }

    @Override
    public void send(String message) {
        System.out.println("Sending PUSH: " + message);
    }
}