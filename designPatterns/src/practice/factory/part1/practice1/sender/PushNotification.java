package practice.factory.part1.practice1.sender;

public class PushNotification implements NotificationSender {

    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}