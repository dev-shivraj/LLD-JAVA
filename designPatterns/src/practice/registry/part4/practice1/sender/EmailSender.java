package practice.registry.part4.practice1.sender;

public class EmailSender implements NotificationSender {

    private static int count = 0;

    private final int id;

    public EmailSender() {
        id = ++count;
        System.out.println("Creating EmailSender #" + id);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL #" + id + ": " + message);
    }
}