package practice.registry.part4.practice1.sender;

public class PushSender implements NotificationSender {

    private static int count = 0;

    private final int id;

    public PushSender() {
        id = ++count;
        System.out.println("Creating PushSender #" + id);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending PUSH #" + id + ": " + message);
    }
}