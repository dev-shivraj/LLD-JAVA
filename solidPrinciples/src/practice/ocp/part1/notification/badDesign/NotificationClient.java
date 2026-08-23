package practice.ocp.part1.notification.badDesign;

public class NotificationClient {

    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.sendNotification("EMAIL");
        service.sendNotification("SMS");
        service.sendNotification("PUSH");
    }
}