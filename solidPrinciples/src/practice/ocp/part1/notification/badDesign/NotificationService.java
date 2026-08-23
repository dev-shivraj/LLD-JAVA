package practice.ocp.part1.notification.badDesign;

public class NotificationService {

    public void sendNotification(String type) {
        if (type.equals("EMAIL")) {
            System.out.println("Sending notification through Email");
        } else if (type.equals("SMS")) {
            System.out.println("Sending notification through SMS");
        } else if (type.equals("PUSH")) {
            System.out.println("Sending notification through Push Notification");
        }
    }
}