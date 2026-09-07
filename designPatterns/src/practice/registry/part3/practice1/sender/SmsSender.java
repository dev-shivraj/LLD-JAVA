package practice.registry.part3.practice1.sender;

public class SmsSender implements NotificationSender {

    public SmsSender() {
        System.out.println("Creating SmsSender");
    }

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}