package practice.registry.part3.practice1.sender;

public class EmailSender implements NotificationSender {

    public EmailSender() {
        System.out.println("Creating EmailSender");
    }

    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}