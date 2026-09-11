package practice.decorator.part1.example2.service;

public class BasicNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending basic notification: " + message);
    }
}