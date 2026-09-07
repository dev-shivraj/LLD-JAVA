package practice.registry.part4.practice1.sender;

public class SmsSender implements NotificationSender {

    private static int count = 0;

    private final int id;

    public SmsSender() {
        id = ++count;
        System.out.println("Creating SmsSender #" + id);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending SMS #" + id + ": " + message);
    }
}